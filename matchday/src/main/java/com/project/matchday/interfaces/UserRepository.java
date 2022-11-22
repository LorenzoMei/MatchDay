package com.project.matchday.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.matchday.model.Utente;

public interface UserRepository extends JpaRepository<Utente, String>{
	Utente findByEmail(String email);
}
