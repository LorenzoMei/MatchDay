package com.project.matchday.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

	@Autowired
	private SchedinaEventiRepository schedinaEventiRep;
	

@RequestMapping(value = "profiloUtente")
	public ModelAndView getProfiloUtente() {
		
		ModelAndView mav = new ModelAndView();
        Utente utente = visualizzaProfilo();
        List<Schedina> schedinaList = visualizzaSchedine();
        List<SchedinaEventi> listSchedineEventi = new ArrayList();
        for(Schedina s : schedinaList) {
        listSchedineEventi.addAll(visualizzaDettagliSchedina(s));
        mav.addObject(listSchedineEventi);
        }
        mav.addObject("utente", utente);
        mav.addObject("schedinaList",schedinaList);
        
      
		mav.setViewName("profiloUtente");
	    return mav;	
	    
	}
@Override
public List<SchedinaEventi> visualizzaDettagliSchedina(Schedina s){
	Utente utente = visualizzaProfilo();
	List<Schedina> listSchedine = visualizzaSchedine();
	List<SchedinaEventi> listSchedineEventi = new ArrayList();
	List<Evento> dettagliSchedine = new ArrayList();

	return listSchedineEventi;
	
}

	
