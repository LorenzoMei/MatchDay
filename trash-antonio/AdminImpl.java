package com.project.matchday.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.matchday.model.Evento;
import com.project.matchday.model.Utente;
import com.project.matchday.interfaces.EventiRepository;
import com.project.matchday.interfaces.UserRepository;

@Controller
public class AdminImpl {
	
	private Utente utente;
	@Autowired	
	private EventiRepository eventiRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	public ArrayList<Utente> visualizzaUtenti(){
		ArrayList<Utente> listaUtenti = (ArrayList<Utente>)userRepository.findAll();
		return listaUtenti;
	}
	
	public void banna() {
		utente.setStatoAttivo(false);
	}
	
	public void sbanna() {
		utente.setStatoAttivo(true);
	}
	
	public void aggiungiEvento(Evento evento) {
		eventiRepository.save(evento);
	}
	
	public void generaRisultati() {
		//////////////////////
	}
	

}
