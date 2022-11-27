package com.project.matchday.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "schedina_eventi")
public class SchedinaEventi {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int idschedinaeventi;
	
	@ManyToOne
    @JoinColumn(name = "fk_schedina", referencedColumnName = "idschedina")
	private Schedina schedina;
	
	@Column(name = "giocata")
	private char giocata;
	
	
	@ManyToOne(targetEntity = Evento.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_eventi", referencedColumnName = "ideventi")
	private Evento evento;
	
	public SchedinaEventi() {
	}
	
	public SchedinaEventi(Schedina schedina, char giocata, Evento evento) {
		this.schedina = schedina;
		this.giocata = giocata;
		this.evento = evento;
	}

	
    public Schedina getSchedina() {
		return schedina;
    }
    public void setSchedina(Schedina schedina) {
		this.schedina = schedina;
    }
    
	
    public Evento getListaEventi() {
		return evento;
    }
    public void setListaEventi(Evento evento) {
		this.evento = evento;
    }
    
	
    public char getGiocata() {
		return giocata;
    }
    public void setGiocata(char giocata) {
		this.giocata = giocata;
    }
}
