package com.project.matchday;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfiloRepository extends JpaRepository<Utente, Integer>{
	
	public ArrayList<Schedina> getSchedineUtente(String email);
	public double getSaldoUtente(String email);
}
