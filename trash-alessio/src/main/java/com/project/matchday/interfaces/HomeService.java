package com.project.matchday.interfaces;

import java.util.ArrayList;

import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.model.Evento;

public interface HomeService {
	
	ModelAndView visualizzaEventiPerTipo(String tipo);
}
