package com.project.matchday.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "eventi")
public class Evento {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "ideventi")
	private int idEvento;
	private String squadraCasa;
	private String squadraOspite;
	private String tipo;
	private Date data;
	@ManyToOne
	@JoinColumn(name = "fk_quote", referencedColumnName="idquote")
	private Quota quota;

	public Evento() {
	}
	public Evento(String squadraCasa, String squadraOspite, String tipo, Date data) {
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.tipo = tipo;
		this.data = data;
	}
	public Evento(String squadraCasa, String squadraOspite, String tipo, Date data, Quota quota) {
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.tipo = tipo;
		this.data = data;
		this.quota = quota;
	}
    
	@Column(name = "squadra_casa")
    public String getSquadraCasa() {
		return squadraCasa;
    }
    public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
    }
	
	@Column(name = "squadra_ospite")
    public String getSquadraOspite() {
		return squadraOspite;
    }
    public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
    }
    
	@Column(name = "tipo")
    public String getTipo() {
		return tipo;
    }
    public void setTipo(String tipo) {
		this.tipo = tipo;
    }
    
	@Column(name = "data")
	@Temporal(TemporalType.TIMESTAMP)
    public Date getData() {
		return data;
    }
    public void setData(Date data) {
		this.data = data;
    }
    
	@Column(name = "fk_quote")
    public Quota getQuota() {
		return quota;
    }
    public void setData(Quota quota) {
		this.quota = quota;
    }
    
}
