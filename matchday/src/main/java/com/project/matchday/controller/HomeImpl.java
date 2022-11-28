package com.project.matchday.controller;

import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.project.matchday.interfaces.EventiRepository;
import com.project.matchday.interfaces.HomeService;
import com.project.matchday.interfaces.ProfiloRepository;
import com.project.matchday.interfaces.SchedinaEventiRepository;
import com.project.matchday.interfaces.UserRepository;
import com.project.matchday.model.Evento;
import com.project.matchday.model.Schedina;
import com.project.matchday.model.SchedinaAjax;
import com.project.matchday.model.SchedinaEventi;
import com.project.matchday.model.SchedinaGiocata;
import com.project.matchday.model.Utente;

@Controller
public class HomeImpl implements HomeService{
	
	@Autowired
	private EventiRepository eventiRepository;
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private ProfiloRepository schedinaRep;
	
	@Autowired
	private EventiRepository eventiRep;
	
	@Autowired
	private SchedinaEventiRepository schedinaEventiRep;
	
	@Override
	@GetMapping(value = "home")
	public ModelAndView visualizzaEventiPerTipo(
			@RequestParam(name="tipo", required = false, defaultValue = "calcio") String tipo) {
		
		ModelAndView mav = new ModelAndView();
		
		ArrayList<Evento> listaEventi =  eventiRepository.getEventiByTipo(tipo);
				
		mav.addObject("listaEventi", listaEventi);
		mav.setViewName("home");
		
		return mav;
	}

	@Override
	@PostMapping(value = "gioca", consumes={"application/json","application/json"})
	public String giocaSchedina( @Valid @RequestBody SchedinaAjax schedinaAjax) {
		String stato = "";
		
		//Parsing dati da JSON ad array di oggetti SchedinaGiocata
		Gson gson = new Gson();
		SchedinaGiocata[] schedinaGiocata = gson.fromJson(schedinaAjax.getSchedinaGiocata(), SchedinaGiocata[].class);
		
		double importo = Double.valueOf(schedinaAjax.getImporto());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = userRep.findByEmail(auth.getName());
		
		//controlla se il saldo dell'utente è maggiore dell'importo giocato
		if(utente.getSaldo() >= importo) {
			
			//aggiorna il saldo
			double newSaldo = utente.getSaldo() - importo;
			utente.setSaldo(newSaldo);
			
			//salvataggio della nuova schedina
			Schedina schedina = new Schedina(importo, utente, "attesa");
			Schedina newSchedina = schedinaRep.save(schedina);
			
			//salvataggio di SchedinaEventi con il collegamento tra la schedina ed ogni evento
			for(int i = 0; i < schedinaGiocata.length; i++) {
				int idEvento = schedinaGiocata[i].getIdEvento();
				Evento evento = eventiRep.getEventiByIdEvento(idEvento);
				char giocata = schedinaGiocata[i].getGiocata();
				
				SchedinaEventi schedinaEventi = new SchedinaEventi(newSchedina, giocata, evento);
				schedinaEventiRep.save(schedinaEventi);
			}
			
			stato = "Schedina giocata con successo";
		}
		else {
			stato = "Importo non sufficiente";
		}
		return stato;
	}
	
	
}
