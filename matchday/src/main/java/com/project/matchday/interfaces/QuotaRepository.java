package com.project.matchday.interfaces;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.matchday.model.Quota;
import com.project.matchday.model.Schedina;
import com.project.matchday.model.Utente;

public interface QuotaRepository extends JpaRepository<Quota, Integer>{
	
	
}