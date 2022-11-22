package com.project.matchday;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.matchday.model.Schedina;

import interfaces.ProfiloRepository;
import interfaces.ProfiloUtenteService;

@Controller
@SessionAttributes("utente")
public class ProfiloUtenteImpl implements ProfiloUtenteService {
	
	private Utente utente;
	private Schedina schedina;
	@Autowired
	private ProfiloRepository profiloRep;
	
	public ArrayList<Schedina> visualizzaSchedine(String email){
		ArrayList<Schedina> schedinaList = profiloRep.getSchedineByEmail(email);
		return schedinaList;
	}
	
	public Utente visualizzaProfilo() {
		return utente;
	}
	
	public void giocaSchedina(Schedina s) {
		
		schedina.save(s);
	}
	
	public void preleva(String email, Double importo) {
		if(utente.getSaldo() >= importo) {
		Double saldo = utente.getSaldo() - importo;
		profiloRep.setSaldoByEmail(email,saldo);
		}
		else {
			System.out.println("Saldo insufficiente");
		}
	}
	
	public void deposita(String email, Double importo) {
		Double saldo = utente.getSaldo() + importo;
		profiloRep.setSaldoByEmail(email,saldo);
	}
	
		
		
}
	

