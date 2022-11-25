package com.project.matchday.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.interfaces.EventiRepository;
import com.project.matchday.interfaces.HomeService;
import com.project.matchday.interfaces.ProfiloUtenteService;
import com.project.matchday.model.Evento;

@Controller
public class HomeImpl implements HomeService{
	
	@Autowired
	private EventiRepository eventiRepository;
	
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
	@PostMapping(value = "gioca", consumes="application/json")
	public ModelAndView giocaSchedina(
			@RequestParam(name="schedina",  required = false) Map<Evento, String> schedina,
			@RequestParam(name="importo") double importo) {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("SONO QUI");
		
		Set<Evento> keys = schedina.keySet();
        for ( Evento key : keys ) {
            System.out.println("CASA " + key.getSquadraCasa() );
            System.out.println("OSPITE " + key.getSquadraOspite() );
            System.out.println("QUOTA " + key.getQuota() );
            System.out.println("GIOCATA " + schedina.get(key) );
        }
        
		return mav;
	}
	
	
}
