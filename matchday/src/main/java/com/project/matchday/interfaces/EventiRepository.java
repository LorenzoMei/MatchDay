package com.project.matchday.interfaces;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.matchday.model.Evento;

public interface EventiRepository extends JpaRepository<Evento, String>{
	
	ArrayList<Evento> getEventiByTipo(String tipo);
}
