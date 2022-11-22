package com.project.matchday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "quote")
public class Quota {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "idquote")
	private int idQuota;
	private float quotaCasa;
	private float quotaPareggio;
	private float quotaOspite;
	
	public Quota() {
	}
	
	public Quota(float quotaCasa, float quotaPareggio, float quotaOspite) {
		this.quotaCasa = quotaCasa;
		this.quotaPareggio = quotaPareggio;
		this.quotaOspite = quotaOspite;
	}

	@Column(name = "quota_casa")
    public float getQuotaCasa() {
		return quotaCasa;
    }
    public void setQuotaCasa(float quotaCasa) {
		this.quotaCasa = quotaCasa;
    }
    
	@Column(name = "quota_pareggio")
    public float getQuotaPareggio() {
		return quotaPareggio;
    }
    public void setQuotaPareggio(float quotaPareggio) {
		this.quotaPareggio = quotaPareggio;
    }
    
	@Column(name = "quota_ospite")
    public float getQuotaOspite() {
		return quotaOspite;
    }
    public void setQuotaOspite(float quotaOspite) {
		this.quotaOspite = quotaOspite;
    }
}