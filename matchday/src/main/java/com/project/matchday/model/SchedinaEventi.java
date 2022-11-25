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
	
	
	@ManyToOne(targetEntity = Evento.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_eventi", referencedColumnName = "ideventi")
	private ArrayList<Evento> listaEventi;
	
	public SchedinaEventi() {
	}
	
	public SchedinaEventi(Schedina schedina, char giocata, ArrayList<Evento> listaEventi) {
		this.schedina = schedina;
		this.giocata = giocata;
		this.listaEventi = listaEventi;
	}

	
    public Schedina getSchedina() {
		return schedina;
    }
    public void setSchedina(Schedina schedina) {
		this.schedina = schedina;
    }
    
	
    public ArrayList<Evento> getListaEventi() {
		return listaEventi;
    }
    public void setListaEventi(ArrayList<Evento> listaEventi) {
		this.listaEventi = listaEventi;
    }
    
	
    public char getGiocata() {
		return giocata;
    }
    public void setGiocata(char giocata) {
		this.giocata = giocata;
    }
}
