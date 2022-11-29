package com.project.matchday.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AppoggioEvento {

	private String squadraCasa;
	private String squadraOspite;
	private String tipo;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date data;
	private float quotaCasa;
	private float quotaPareggio;
	private float quotaOspite;

	public AppoggioEvento()
	{
		
	}
	public AppoggioEvento(String squadraCasa, String squadraOspite, String tipo, Date data, float quotaCasa, float quotaPareggio, float quotaOspite) {
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.tipo = tipo;
		this.data = data;
		this.quotaCasa = quotaCasa;
		this.quotaPareggio = quotaPareggio;
		this.quotaOspite = quotaOspite;
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
    
    public float getQuotaCasa() {
		return quotaCasa;
    }
    public void setQuotaCasa(float quotaCasa) {
		this.quotaCasa = quotaCasa;
    }
    
    public float getQuotaPareggio() {
		return quotaPareggio;
    }
    public void setQuotaPareggio(float quotaPareggio) {
		this.quotaPareggio = quotaPareggio;
    }
    
    public float getQuotaOspite() {
		return quotaOspite;
    }
    public void setQuotaOspite(float quotaOspite) {
		this.quotaOspite = quotaOspite;
    }
	
	
}




