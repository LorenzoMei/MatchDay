package com.project.matchday.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.project.matchday.interfaces.UserRepository;
import com.project.matchday.model.Utente;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private UserRepository userRep;
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if ("USER".equals(auth.getAuthority())) {
            	authentication = SecurityContextHolder.getContext().getAuthentication();
        		Utente utente = userRep.findByEmail(authentication.getName());
            	
            	if(utente.getStato() == false) {
            		response.sendRedirect("/login?error=true");
            	}
            	else {
            		response.sendRedirect("/home");
            	}
            	
            }
            if ("ADMIN".equals(auth.getAuthority())) {
            	response.sendRedirect("/home");
            }
        }
    }

}
