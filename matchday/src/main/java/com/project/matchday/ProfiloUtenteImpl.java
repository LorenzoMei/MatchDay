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

@Controller
@SessionAttributes("utente")
public class ProfiloUtenteImpl implements ProfiloRepository,ProfiloUtenteService {
	
	@Autowired
	ProfiloUtenteService utente;

	@Override
	@GetMapping("utente")
	public void deposita(String email, Double importo) {
		Double saldo = utente.getSaldo(email) + importo; 
		setSaldo(email,saldo);
		
		
	}

	@Override
	@GetMapping("utente")
	public void preleva(String email, Double importo) {
		if(utente.getSaldo(email) >= importo) {
			Double saldo = utente.getSaldo(email) - importo; 
			setSaldo(email,saldo);
		}
		else {
			System.out.println("SALDO INSUFFICIENTE");
			}
		
	}

	@Override
	@GetMapping("utente/{email}")
	public Double getSaldoUtente(@PathVariable String email) {
		Double saldo = utente.getSaldo(email);
		return saldo;
	}

	@Override
	public void giocaSchedina(Schedina schedina) {}
	public ArrayList<Schedina> visualizzaSchedine(){}
	public ArrayList<Schedina> getSchedineUtente(String email);

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Utente> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Utente> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Utente> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Utente> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Utente> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Utente> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Utente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Utente> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Utente> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Utente> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Utente> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Utente> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Utente> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Utente> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Utente, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Double> getSaldo(String e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Double> setSaldo(String e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente visualizzaProfilo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void giocaSchedina(Schedina schedina) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposita(String email, double importo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preleva(String email, double importo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giocaSchedina(Schedina schedina) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giocaSchedina(Schedina schedina) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
