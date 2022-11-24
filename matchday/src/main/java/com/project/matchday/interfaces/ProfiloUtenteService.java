package com.project.matchday.interfaces;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.model.Utente;

import java.util.List;

import com.project.matchday.model.Schedina;



@Service
public interface ProfiloUtenteService {
	

	List<Schedina> visualizzaSchedine();
	void giocaSchedina(Schedina schedina);
	void preleva(Double importo);
	void deposita(Double importo);
	Utente visualizzaProfilo();

	

}
