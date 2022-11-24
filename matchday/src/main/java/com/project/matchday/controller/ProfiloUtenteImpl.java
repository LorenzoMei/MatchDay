package com.project.matchday.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.project.matchday.model.Schedina;
import com.project.matchday.model.Utente;
import com.project.matchday.interfaces.ProfiloRepository;
import com.project.matchday.interfaces.ProfiloUtenteService;
import com.project.matchday.interfaces.UserRepository;


@Controller
@SessionAttributes("utente")
public class ProfiloUtenteImpl implements ProfiloUtenteService {
	


	@Autowired
	private ProfiloRepository profiloRep;
	@Autowired
	private UserRepository userRep;
        @RequestMapping(value = "profiloUtente")
	public void getProfiloUtente() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("profiloUtente");
	}
	
	@Override
	public List<Schedina> visualizzaSchedine(String email){
		Utente utente = visualizzaProfilo(email);
		List<Schedina> schedinaList = profiloRep.getSchedineByUtente(utente);
		System.out.println(schedinaList.size());
		return schedinaList;
	}
	@Override
	public Utente visualizzaProfilo(String email) {
		return userRep.findByEmail(email);
		
	}
	@Override
	public void giocaSchedina(Schedina s) {
		
		profiloRep.save(s);
	}
	@Override
	public void preleva(String email, Double importo) {
		Utente utente = visualizzaProfilo(email);
		if(utente.getSaldo() >= importo) {
		Double saldo = utente.getSaldo() - importo;
		utente.setSaldo(saldo);
		userRep.save(utente);
		}
		else {
			System.out.println("Saldo insufficiente");
		}
	}
	@Override
	public void deposita(String email, Double importo) {
		Utente utente = visualizzaProfilo(email);
		Double saldo = utente.getSaldo() + importo;
		utente.setSaldo(saldo);
		userRep.save(utente);
	}


		
		
}
	
