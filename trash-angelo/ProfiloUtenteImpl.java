package com.project.matchday.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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
		System.out.println(schedinaList.size());
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
	@Override
	@RequestMapping(value="/preleva", method = RequestMethod.POST) 
	public String preleva( @RequestParam("numPre") Double importo) {
		Utente utente = visualizzaProfilo();
		if(utente.getSaldo() >= importo) {
		Double saldo = utente.getSaldo() - importo;
		utente.setSaldo(saldo);
		userRep.save(utente);
		return "redirect:profiloUtente";}
		else {
			return "redirect:profiloUtente";
		}
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
        	/////
   
        }
        
for(int s = 0; s< schedinaList.size(); s++ ) {
	System.out.println( schedinaList.get(s).getImporto());

		List<Evento> eventiList2 = eventiPerSchedinaList.get(schedinaList.get(s));
		for(int k = 0; k < eventiList2.size(); k++ ) {
	System.out.println(eventiList2.get(k).getTipo());
	System.out.println(eventiList2.get(k).getSquadraCasa());
	System.out.println(eventiList2.get(k).getSquadraOspite());
}}

        mav.addObject("schedinaEventiPerSchedinaList",schedinaEventiPerSchedinaList);
        mav.addObject("utente", utente);
        mav.addObject("schedinaList",schedinaList);
        mav.addObject("eventiPerSchedinaList",eventiPerSchedinaList);
		mav.setViewName("profiloUtente");
	    return mav;	
	    
	}
	
@Override
@RequestMapping(value="/deposita", method = RequestMethod.POST) 
public String deposita(@RequestParam("numDep") Double importo) {
	Utente utente = visualizzaProfilo();
	Double saldo = utente.getSaldo() + importo;
	utente.setSaldo(saldo);
	userRep.save(utente);
	return "redirect:profiloUtente";
	}
	
}

	
	
