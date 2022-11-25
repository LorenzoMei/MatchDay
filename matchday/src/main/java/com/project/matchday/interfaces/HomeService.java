package com.project.matchday.interfaces;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.model.Evento;

public interface HomeService {
	
	ModelAndView visualizzaEventiPerTipo(String tipo);
	ModelAndView giocaSchedina(String schedina, double importo);
}
