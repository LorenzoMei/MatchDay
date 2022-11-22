package com.project.matchday.interfaces;

import org.springframework.stereotype.Service;

import com.project.matchday.model.Utente;

import java.util.List;

import com.project.matchday.model.Schedina;



@Service
public interface ProfiloUtenteService {
	

	List<Schedina> visualizzaSchedine(String email);
    Utente visualizzaProfilo(String email);
	void giocaSchedina(Schedina schedina);
	void preleva(String email, Double importo);
	void deposita(String email, Double importo);
	

}
