package com.project.matchday.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "utente")
public class Utente {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int idutente;
	
	private String nome;
	private String cognome;
	private String email;
	private String password;
	
	private String ruolo;
	
	private boolean stato;
	private double saldo;
	
	public Utente() {
		
	}
	
	public Utente(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
	public String getRole() {
        return ruolo;
    }

    public void setRole(String ruolo) {
        this.ruolo = ruolo;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isStatoAttivo() {
		return stato;
	}

	public void setStatoAttivo(boolean stato) {
		this.stato = stato;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
    
    

}
