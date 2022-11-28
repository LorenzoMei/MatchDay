package com.project.matchday.controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.model.AppoggioEvento;
import com.project.matchday.model.Evento;
import com.project.matchday.model.Quota;
import com.project.matchday.model.Schedina;
import com.project.matchday.model.SchedinaEventi;
import com.project.matchday.model.Utente;
import com.project.matchday.interfaces.AdminService;
import com.project.matchday.interfaces.EventiRepository;
import com.project.matchday.interfaces.ProfiloRepository;
import com.project.matchday.interfaces.ProfiloUtenteService;
import com.project.matchday.interfaces.QuotaRepository;
import com.project.matchday.interfaces.SchedinaEventiRepository;
import com.project.matchday.interfaces.UserRepository;

@Controller
public class AdminImpl implements AdminService{
	
	@Autowired	
	private EventiRepository eventiRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private QuotaRepository quotaRepository;
	@Autowired
	private ProfiloRepository schedinaRepository;
	@Autowired
	private SchedinaEventiRepository schedinaEventiRepository;
	@Autowired
	private ProfiloUtenteService profiloUtenteService;
    private static final DecimalFormat df = new DecimalFormat("0.00");

	
	public ArrayList<Utente> visualizzaUtenti(){
		ArrayList<Utente> listaUtenti = (ArrayList<Utente>)userRepository.findAll();
		return listaUtenti;
	}
	
	public void banna(String email) {
		Utente utente = userRepository.findByEmail(email);
		utente.setStatoAttivo(false);
		userRepository.save(utente);
	}
	
	public void sbanna(String email) {
		Utente utente = userRepository.findByEmail(email);
		utente.setStatoAttivo(true);
		userRepository.save(utente);
	}
	
	public void aggiungiEvento(AppoggioEvento appoggioEvento) {
    	Quota quota = new Quota(appoggioEvento.getQuotaCasa(),appoggioEvento.getQuotaPareggio(),appoggioEvento.getQuotaOspite());
		quotaRepository.save(quota);
		ArrayList<Quota> quoteAll = new ArrayList<Quota>(quotaRepository.findAll());
		Quota quotaUltima= quoteAll.get(quoteAll.size() - 1);
    	Evento evento = new Evento(appoggioEvento.getSquadraCasa(),appoggioEvento.getSquadraOspite(),appoggioEvento.getTipo(),appoggioEvento.getData(),'-',quotaUltima);
    	eventiRepository.save(evento);
	}
	
	public char randomRes(String tipo) {
		
		Random rn = new Random();
		int res;
		char fin;
		
		if (tipo.equals("calcio")) {
			res = rn.nextInt(3);
		}else {
			res = rn.nextInt(2)+1;
		}
		
		if (res == 1 || res == 2) {
			fin = (char)(res + '0');
		}else {
			fin = 'X';
		}

		return fin;
	}
	
	public String checkVittoria(ArrayList<SchedinaEventi> listaSchedinaEventiforSchedina) {
		
		String output = "Vincente";
		for(SchedinaEventi schedinaEvento: listaSchedinaEventiforSchedina){
			
			Evento evento = schedinaEvento.getListaEventi();
			char risultato = evento.getRisultato();
			char giocata = schedinaEvento.getGiocata();
			
			if (risultato != giocata) {
				output = "Perdente";
				break;
			}
		}
		
		return output;
	}

	
	public void generaRisultati() {
		//Carico tutti gli eventi		
		
		ArrayList<Evento> listaEventi =  (ArrayList<Evento>)eventiRepository.findAll();
		
		//Genero un risultato per ogni evento e lo salvo
		
		for(Evento evento: listaEventi) {
			char res = evento.getRisultato();
			if(res == '-') {
				String tipo = evento.getTipo();
				evento.setRisultato(randomRes(tipo));
				eventiRepository.save(evento);
			}
		}
		
		//Carico tutte le schedine
		System.out.println("---CARICO TUTTE LE SCHEDINE");
		ArrayList<Schedina> listaSchedine =  (ArrayList<Schedina>)schedinaRepository.findAll();
		System.out.println("---SCHEDINE CARICATE!");

		//Per ogni schedina controllo se è vincente e aggiorno lo stato della schedina e il saldo utente
		
		for(Schedina schedina: listaSchedine) {
			
			if (schedina.getEsito().equals("attesa")) {
				
				ArrayList<SchedinaEventi> listaSchedinaEventiforSchedina = (ArrayList<SchedinaEventi>) schedinaEventiRepository.getSchedinaEventiBySchedina(schedina);

				String risultato = checkVittoria(listaSchedinaEventiforSchedina);
				schedina.setEsito(risultato);
				schedinaRepository.save(schedina);
				
				//se la schedina è vincente aggiorno il saldo
				if(risultato.equals("Vincente")) {

					Utente utente = schedina.getUtente();
					//prendo la quota finale della schedina
					double quotaVincita = 0;
					for(SchedinaEventi schedinaEvento: listaSchedinaEventiforSchedina){
						
						Evento evento = schedinaEvento.getListaEventi();
						Quota quota = evento.getQuota();
						float quotaGiocata;

						if (schedinaEvento.getGiocata() == '1') {
							quotaGiocata = quota.getQuotaCasa();
						} else if (schedinaEvento.getGiocata() == '2') {
							quotaGiocata = quota.getQuotaOspite();
						} else {
							quotaGiocata = quota.getQuotaPareggio();
						}
						
						quotaVincita += (double)quotaGiocata;
					}
					//calcolo la vincita
					double vincita = quotaVincita * schedina.getImporto();
					
					//aggiungo la vincita al conto
					double saldo = utente.getSaldo();
			        df.setRoundingMode(RoundingMode.UP);
					String sf = df.format(saldo+vincita);
					double saldoFinale = Double.parseDouble(sf); 
					utente.setSaldo(saldoFinale);	
					userRepository.save(utente);
				}
			}
		}
	}
	
	
	@GetMapping(value = "adminBS")
	public ModelAndView visualizzaTuttiUtenti() {
		
		ModelAndView mav = new ModelAndView("adminBS");
		ArrayList<Utente> listaUtenti =  visualizzaUtenti();
		mav.addObject("listaUtenti", listaUtenti.subList(1, listaUtenti.size()));
		
		mav.setViewName("adminBS");
		return mav;
	}
	
	@PostMapping(value = "banna")
	public ModelAndView bannaU(@ModelAttribute("email") String email) {
		
		banna(email);
		
		return visualizzaTuttiUtenti();
	}
	
	@PostMapping(value = "sbanna")
	public ModelAndView sbannaU(@ModelAttribute("email") String email) {
		
		sbanna(email);
		
		return visualizzaTuttiUtenti();
	}
	
	@GetMapping(value = "addEvent")
	public ModelAndView aggiungiEvento() {
		
		ModelAndView mav = new ModelAndView("addEvent");
		mav.addObject("registerEventFull", new AppoggioEvento());
		mav.setViewName("addEvent");
		return mav;
	}
	
	@PostMapping(value = "addEvent")
    public ModelAndView registraEvento(@ModelAttribute("registerEventFull") AppoggioEvento appoggioEvento, BindingResult bindingResult) {
    	ModelAndView mav = new ModelAndView();
    	
    	if (bindingResult.hasErrors()) {
            return mav;
    	}
    	else { 
            try {
        		aggiungiEvento(appoggioEvento);
        		mav.setViewName("profileAdmin");
            	return mav;
            	}
            catch (Exception exception) {
                bindingResult.rejectValue("squadraCasa", "error.registerEventFull", exception.getMessage());
                return mav;
            }
    	}
    	
    }
	
	@GetMapping(value = "simulazione")
	public ModelAndView simulazione() {
		
		ModelAndView mav = new ModelAndView();
		String redirect = "redirect:profileAdmin";
		mav.setViewName(redirect);
		return mav;
	}
	
	@PostMapping(value = "simulazione")
	public ModelAndView simul() {
		
		generaRisultati();
		ModelAndView mav = new ModelAndView("profileAdmin");
		return mav;
	}
	

}




