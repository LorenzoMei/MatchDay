package com.project.matchday.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "schedina_eventi")
public class SchedinaEventi {
	private Schedina schedina;
	private char giocata;
	private ArrayList<Evento> listaEventi;
	
	public SchedinaEventi() {
	}
	
	public SchedinaEventi(Schedina schedina, char giocata, ArrayList<Evento> listaEventi) {
		this.schedina = schedina;
		this.giocata = giocata;
		this.listaEventi = listaEventi;
	}

	@Column(name = "fk_schedina")
    public Schedina getSchedina() {
		return schedina;
    }
    public void setSchedina(Schedina schedina) {
		this.schedina = schedina;
    }
    
	@Column(name = "fk_eventi")
    public ArrayList<Evento> getListaEventi() {
		return listaEventi;
    }
    public void setListaEventi(ArrayList<Evento> listaEventi) {
		this.listaEventi = listaEventi;
    }
    
	@Column(name = "giocata")
    public char getGiocata() {
		return giocata;
    }
    public void setGiocata(char giocata) {
		this.giocata = giocata;
    }
}