package com.project.matchday.interfaces;
import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.model.SchedinaAjax;

public interface HomeService {
	
	ModelAndView visualizzaEventiPerTipo(String tipo);
	String giocaSchedina(SchedinaAjax schedinaAjax);
}
