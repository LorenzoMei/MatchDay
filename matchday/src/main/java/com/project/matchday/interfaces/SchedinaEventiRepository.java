package com.project.matchday.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.matchday.model.Evento;
import com.project.matchday.model.SchedinaEventi;

public interface SchedinaEventiRepository extends JpaRepository<SchedinaEventi, String>{

}
