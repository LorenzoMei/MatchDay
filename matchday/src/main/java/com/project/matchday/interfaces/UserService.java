package com.project.matchday.interfaces;

import com.project.matchday.model.Utente;

public interface UserService {
	
	/**
     * Register a new user
     *
     * @param userDto
     * @return
     */
    Utente signup(Utente user);

    /**
     * Search an existing user
     *
     * @param email
     * @return
     */
    Utente findUserByEmail(String email);

}
