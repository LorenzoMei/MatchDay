package com.project.matchday.interfaces;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.model.Evento;
import com.project.matchday.model.SchedinaAjax;

public interface HomeService {
	
	ModelAndView visualizzaEventiPerTipo(String tipo);
	ModelAndView giocaSchedina(SchedinaAjax schedinaAjax);
}
