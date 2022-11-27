package com.project.matchday.controller;

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
import com.project.matchday.model.Utente;
import com.project.matchday.interfaces.AdminService;
import com.project.matchday.interfaces.EventiRepository;
import com.project.matchday.interfaces.QuotaRepository;
import com.project.matchday.interfaces.UserRepository;

@Controller
public class AdminImpl implements AdminService{
	
	@Autowired	
	private EventiRepository eventiRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private QuotaRepository quotaRepository;
	
	
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
	}
	
	
	@GetMapping(value = "adminBS")
	public ModelAndView visualizzaTuttiUtenti() {
		
		ModelAndView mav = new ModelAndView("adminBS");
		ArrayList<Utente> listaUtenti =  visualizzaUtenti();
		mav.addObject("listaUtenti", listaUtenti);
		
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
            	return new ModelAndView("home");
            	}
            catch (Exception exception) {
                bindingResult.rejectValue("squadraCasa", "error.registerEventFull", exception.getMessage());
                return mav;
            }
    	}
    	
    }
	
	@GetMapping(value = "simulazione")
	public ModelAndView simulazione() {
		
		ModelAndView mav = new ModelAndView("profileAdmin");
		return mav;
	}
	
	@PostMapping(value = "simulazione")
	public ModelAndView simul() {
		
		generaRisultati();
		ModelAndView mav = new ModelAndView("profileAdmin");
		return mav;
	}
	

}



