package com.project.matchday.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.interfaces.EventiRepository;
import com.project.matchday.interfaces.HomeService;
import com.project.matchday.model.Evento;

@Controller
public class HomeImpl implements HomeService{
	
	@Autowired
	private EventiRepository eventiRepository;
	
	@Override
	public ArrayList<Evento> visualizzaEventiPerTipo(String tipo) {
		
		ArrayList<Evento> listaEventi =  eventiRepository.getEventiByTipo(tipo);
		
		return listaEventi;
	}
	
	@RequestMapping(value = "home")
	public ModelAndView visualizzaEventiPerTipo() {
		
		ModelAndView mav = new ModelAndView();
		ArrayList<Evento> listaEventi =  visualizzaEventiPerTipo("calcio");
				
		mav.addObject("listaEventi", listaEventi);
		mav.setViewName("home");
		
		return mav;
	}
}
