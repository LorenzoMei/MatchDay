package com.project.matchday.interfaces;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.matchday.model.Evento;
import com.project.matchday.model.Utente;

@Service
public interface AdminService{

	public ArrayList<Utente> visualizzaUtenti();
	
	public void banna(String email);
	
	public void sbanna(String email);
	
	public void aggiungiEvento(Evento evento);
	
	public void generaRisultati();
}

