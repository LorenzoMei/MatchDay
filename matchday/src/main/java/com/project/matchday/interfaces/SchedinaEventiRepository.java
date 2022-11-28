package com.project.matchday.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.matchday.model.Schedina;
import com.project.matchday.model.SchedinaEventi;

public interface SchedinaEventiRepository extends JpaRepository<SchedinaEventi,Integer>{
	
	public List<SchedinaEventi> getSchedinaEventiBySchedina(Schedina schedina);

}
