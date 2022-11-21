package com.project.matchday;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



@Service
public interface ProfiloUtenteService extends JpaRepository<Utente, Integer> {
	
	@Query(value = "SELECT saldo FROM utente WHERE email=e")
    Double getSaldo(String e);
    
	@Query(value = "UPDATE utente SET saldo=s WHERE email=e")
    void setSaldo(String e,Double s);
	
	

	ArrayList<Schedina> visualizzaSchedine();
    Utente visualizzaProfilo();
	void giocaSchedina(Schedina schedina);


	void preleva(String email, Double importo);

	void deposita(String email, Double importo);
	

}
