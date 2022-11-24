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
import com.project.matchday.model.Schedina;
import com.project.matchday.model.Utente;
import com.project.matchday.interfaces.ProfiloRepository;
import com.project.matchday.interfaces.ProfiloUtenteService;
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
	
	@RequestMapping(value = "profiloUtente")
	public ModelAndView getProfiloUtente() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("profiloUtente");
        Utente utente = visualizzaProfilo();
        mav.addObject("utente", utente);
		mav.setViewName("profiloUtente");
	    return mav;	
	    
	}
		
	@Override
	@RequestMapping(value = "profiloUtente/visualizzaSchedine")
	public ModelAndView visualizzaSchedine(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("profiloUtente");
		Utente utente = visualizzaProfilo();
		List<Schedina> schedinaList = profiloRep.getSchedineByUtente(utente);
		System.out.println(schedinaList.size());
		mav.addObject("schedinaList", schedinaList);
		mav.setViewName("profiloUtente");
	    return mav;	
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
	public ModelAndView preleva(@RequestParam("numPre") Double importo) {
		Utente utente = visualizzaProfilo();
		String risultato = "";
		ModelAndView mav = new ModelAndView();
		mav.setViewName("profiloUtente");
		
		if(utente.getSaldo() >= importo) {
		Double saldo = utente.getSaldo() - importo;
		utente.setSaldo(saldo);
		userRep.save(utente);}
		else {
			risultato = "SALDO INSUFFICIENTE";
			System.out.println("saldo insufficiente");
		}

        mav.addObject("risultato", risultato);
		mav.setViewName("profiloUtente");
	    return mav;	
		
		
	}
		
	@Override
	@RequestMapping(value="/deposita", method = RequestMethod.POST) 
	public String deposita( @RequestParam("numDep") Double importo) {
		Utente utente = visualizzaProfilo();
		Double saldo = utente.getSaldo() + importo;
		utente.setSaldo(saldo);
		userRep.save(utente);
		return "redirect:profiloUtente";
		
	}

		
		
}
	
