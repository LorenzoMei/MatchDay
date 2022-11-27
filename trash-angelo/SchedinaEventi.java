package com.project.matchday.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.Table;

@Entity
@Table(name = "schedina_eventi")
public class SchedinaEventi {
	
	@Id
	private int idschedinaeventi;
	
	@ManyToOne
    @JoinColumn(name = "fk_schedina", referencedColumnName = "idschedina")
	private Schedina schedina;
	
	@Column(name = "giocata")
	private char giocata;
	
	
	
	public SchedinaEventi() {
	}
	
	public SchedinaEventi(Schedina schedina, char giocata) {
		this.schedina = schedina;
		this.giocata = giocata;

	
	}

	
    public Schedina getSchedina() {
		return schedina;
    }
    public void setSchedina(Schedina schedina) {
		this.schedina = schedina;
    }
    

    
	
    public char getGiocata() {
		return giocata;
    }
    public void setGiocata(char giocata) {
		this.giocata = giocata;
    }
}
