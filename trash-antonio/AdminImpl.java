package com.project.matchday.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.model.Evento;
import com.project.matchday.model.Utente;
import com.project.matchday.interfaces.AdminService;
import com.project.matchday.interfaces.EventiRepository;
import com.project.matchday.interfaces.UserRepository;

@Controller
public class AdminImpl implements AdminService{
	
	@Autowired	
	private EventiRepository eventiRepository;
	@Autowired
	private UserRepository userRepository;
	
	
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
	
	public void aggiungiEvento(Evento evento) {
		eventiRepository.save(evento);
	}
	
	public void generaRisultati() {
		//////////////////////
	}
	
	
	@GetMapping(value = "test")
	public ModelAndView visualizzaEventiPerTipo() {
		
		ModelAndView mav = new ModelAndView();
		ArrayList<Utente> listaUtenti =  visualizzaUtenti();
		mav.addObject("listaUtenti", listaUtenti);
		mav.setViewName("test");
		
		return mav;
	}
	
	@PostMapping(value = "test/{email}")
	public ModelAndView bannaU() {
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("test");
		
		return mav;
	}

}
