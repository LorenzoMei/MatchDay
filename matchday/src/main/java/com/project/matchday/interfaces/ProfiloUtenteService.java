package com.project.matchday.interfaces;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.project.matchday.model.Utente;

import java.util.List;

import javax.validation.Valid;

import com.project.matchday.model.EffettuaOperazioni;
import com.project.matchday.model.Schedina;



@Service
public interface ProfiloUtenteService {
	

	List<Schedina> visualizzaSchedine();
	void giocaSchedina(Schedina schedina);
	Utente visualizzaProfilo();
	String preleva(Double importo);
	String deposita(Double importo);




	

}
