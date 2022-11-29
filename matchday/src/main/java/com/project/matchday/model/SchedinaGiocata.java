package com.project.matchday.model;

import java.util.Date;

public class SchedinaGiocata {
	
	private int idEvento;
	private String squadraCasa;
	private String squadraOspite;
	private String tipo;
	private Date data;
	private float quota;
	private char giocata;
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getSquadraCasa() {
		return squadraCasa;
	}
	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}
	public String getSquadraOspite() {
		return squadraOspite;
	}
	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public float getQuota() {
		return quota;
	}
	public void setQuota(float quota) {
		this.quota = quota;
	}
	public char getGiocata() {
		return giocata;
	}
	public void setGiocata(char giocata) {
		this.giocata = giocata;
	}
	
	
}
