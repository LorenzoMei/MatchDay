package com.project.matchday.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@id
	private int idRole;
	private String role;
	
	public Role() {
	}
	
	public Role(String role) {
		this.role = role;
	}

	@Column(name = "role")
    public String getRole() {
		return role;
    }
    public void setCognome(String role) {
		this.role = role;
    }
}



	
