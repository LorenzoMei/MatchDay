package com.project.matchday.interfaces;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.model.Utente;

import java.util.List;

import com.project.matchday.model.EffettuaOperazioni;
import com.project.matchday.model.Schedina;



@Service
public interface ProfiloUtenteService {
	

	List<Schedina> visualizzaSchedine();
	void giocaSchedina(Schedina schedina);
	String preleva(EffettuaOperazioni importo, BindingResult b);
	String deposita(EffettuaOperazioni importo, BindingResult b);
	Utente visualizzaProfilo();



	

}
