package com.project.matchday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "schedina")
public class Schedina {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "idschedina")
	private int idSchedina;
	private double importo;
	@ManyToOne
	@JoinColumn(name = "fk_utente", referencedColumnName="idutente")
	private Utente utente;
	private String esito;
	
	public Schedina() {
	}
	
	public Schedina(double importo, Utente utente, String esito) {
		this.importo = importo;
		this.utente = utente;
		this.esito = esito;
	}
	
	
	public int getIdSchedina() {
		return idSchedina;
	}

	public void setIdSchedina(int idSchedina) {
		this.idSchedina = idSchedina;
	}

	@Column(name = "importo")
    public double getImporto() {
		return importo;
    }
    public void setImporto(double importo) {
		this.importo = importo;
    }
    
	@Column(name = "fk_utente")
    public Utente getUtente() {
		return utente;
    }
    public void setUtente(Utente utente) {
		this.utente = utente;
    }

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}
}
