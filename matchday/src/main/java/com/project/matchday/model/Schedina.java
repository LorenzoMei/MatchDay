package com.project.matchday.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "schedina")
public class Schedina {
	@id
	private int idSchedina;
	private double importo;
	private Utente utente;
	
	public Schedina() {
	}
	
	public Schedina(double importo, Utente utente) {
		this.importo = importo;
		this.utente= utente;
	}

	@Column(name = "importo")
    public double getImporto() {
		return importo;
    }
    public void setImporto(double importo) {
		this.importo = importo;
    }
    
	@Column(name = "fk_utente")
    public double getUtente() {
		return utente;
    }
    public void setUtente(Utente utente) {
		this.utente = utente;
    }
}
