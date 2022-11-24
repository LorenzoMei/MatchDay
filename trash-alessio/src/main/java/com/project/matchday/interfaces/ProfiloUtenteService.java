package com.project.matchday.interfaces;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.model.Utente;

import java.util.List;

import com.project.matchday.model.Schedina;



@Service
public interface ProfiloUtenteService {
	

	ModelAndView visualizzaSchedine();
	void giocaSchedina(Schedina schedina);
	ModelAndView preleva(Double importo);
	String deposita(Double importo);
	Utente visualizzaProfilo();


	

}
