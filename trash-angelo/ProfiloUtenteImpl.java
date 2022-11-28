package com.project.matchday.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.model.EffettuaOperazioni;
import com.project.matchday.model.Evento;
import com.project.matchday.model.Schedina;
import com.project.matchday.model.SchedinaEventi;
import com.project.matchday.model.Utente;
import com.project.matchday.interfaces.ProfiloRepository;
import com.project.matchday.interfaces.ProfiloUtenteService;
import com.project.matchday.interfaces.SchedinaEventiRepository;
import com.project.matchday.interfaces.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@SessionAttributes("utente")
public class ProfiloUtenteImpl implements ProfiloUtenteService {
	

	@Autowired
	private ProfiloRepository profiloRep;
	@Autowired
	private UserRepository userRep;
	@Autowired
	private SchedinaEventiRepository schedinaEventiRep;
	

		
	
	@Override
	public List<Schedina> visualizzaSchedine(){
		Utente utente = visualizzaProfilo();
		List<Schedina> schedinaList = profiloRep.getSchedineByUtente(utente);
		return schedinaList;
	}
	
	
	
	@Override
	public Utente visualizzaProfilo() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = userRep.findByEmail(auth.getName());
		return utente;	
	}
	
		
	@Override
	public void giocaSchedina(Schedina s) {
		
		profiloRep.save(s);
	}
	
	
	
@RequestMapping(value = "profiloUtente")
	public ModelAndView getProfiloUtente() {
		
		ModelAndView mav = new ModelAndView();
		List<Schedina> schedinaList = visualizzaSchedine();
        Utente utente = visualizzaProfilo();  
        Map<Schedina,List<Evento>> eventiPerSchedinaList = new HashMap<Schedina,List<Evento>>();
        Map<Schedina,List<SchedinaEventi>> schedinaEventiPerSchedinaList = new HashMap<Schedina,List<SchedinaEventi>>();
       
        for(int i = 0; i < schedinaList.size(); i++) {
        ArrayList<SchedinaEventi> schedinaEventiList = new ArrayList<SchedinaEventi>();
        	schedinaEventiList.addAll(schedinaEventiRep.getSchedinaEventiBySchedina(schedinaList.get(i)));
        	schedinaEventiPerSchedinaList.put(schedinaList.get(i), schedinaEventiList);
      
        	for(int k = 0; k< schedinaEventiList.size(); k++) {
        		ArrayList<Evento> eventiList = new ArrayList<Evento>();
        		for( int s = 0; s< schedinaEventiList.size(); s++ ) {
        			eventiList.add(schedinaEventiList.get(s).getListaEventi());
        		}
        		eventiPerSchedinaList.put(schedinaList.get(i), eventiList);
        		}
        } 

        mav.addObject("schedinaEventiPerSchedinaList",schedinaEventiPerSchedinaList);
        mav.addObject("utente", utente);
        mav.addObject("schedinaList",schedinaList);
        mav.addObject("eventiPerSchedinaList",eventiPerSchedinaList);
        mav.addObject("deposito",new EffettuaOperazioni());
        mav.addObject("prelievo",new EffettuaOperazioni());
		mav.setViewName("profiloUtente");
		
	    return mav;	
	    
	}

@Override
@RequestMapping(value="/preleva", method = RequestMethod.POST) 
public String preleva(@Valid @ModelAttribute("prelievo") EffettuaOperazioni importo, BindingResult bindingResult) {
	if (bindingResult.hasErrors()) {
		System.out.println("sono qui1");
		bindingResult.rejectValue("importo","error", "Numero non valido");
        return "/profiloUtente";
	}
	else {
        try {
        	Utente utente = visualizzaProfilo();
        	if( importo.getImporto() < 0 || importo.getImporto() > utente.getSaldo()  ) {
        		System.out.println("QUI2");
        		bindingResult.rejectValue("importo","error", "Numero non valido");
        		return "/profiloUtente";
        	} else {
        		System.out.println("QUI3");
        		System.out.println(utente.getSaldo());
        		System.out.println(importo.getImporto());
	        	Double saldo = utente.getSaldo() - importo.getImporto();
	        	utente.setSaldo(saldo);
	        	userRep.save(utente);
	        	System.out.println(utente.getSaldo());
	        	return "redirect:profiloUtente";
        		}
        	}
    	
        catch (Exception exception) {
            bindingResult.rejectValue("importo","error",  "Impossibile depositare!");
            return "/profiloUtente";
        	}
        }
	}

	
@Override
@RequestMapping(value="/deposita", method = RequestMethod.POST) 
public String deposita(@Valid @ModelAttribute("deposito") EffettuaOperazioni importo, BindingResult bindingResult) {
	if (bindingResult.hasErrors()) {
		bindingResult.rejectValue("importo","error", "Numero non valido");
        return "/profiloUtente";
	}
        else {
            try {
            	Utente utente = visualizzaProfilo();
            	if( importo.getImporto() <0) {
            		bindingResult.rejectValue("importo","error", "Numero non valido");
            		return "/profiloUtente";
            	}
            	Double saldo = utente.getSaldo() + importo.getImporto();
            	utente.setSaldo(saldo);
            	userRep.save(utente);
            	return "redirect:profiloUtente";
            	}
            catch (Exception exception) {
                bindingResult.rejectValue("importo","error.deposito",  "Impossibile depositare!");
                return "/profiloUtente";
            }
    	}
	}
}

	
	
	
