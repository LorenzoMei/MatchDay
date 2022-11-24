package com.project.matchday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    public Utente getUtente() {
		return utente;
    }
    public void setUtente(Utente utente) {
		this.utente = utente;
    }
}
