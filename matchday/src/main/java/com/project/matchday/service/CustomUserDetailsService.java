package com.project.matchday.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.matchday.interfaces.UserService;
import com.project.matchday.model.Utente;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utente user = userService.findUserByEmail(email);
        if (user != null) {
        	
            List<GrantedAuthority> authorities = getUserAuthority(user);
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("user with email " + email + " does not exist.");
        }
    }

    private List<GrantedAuthority> getUserAuthority(Utente user) {
        Set<GrantedAuthority> roles = new HashSet<>();
        
        roles.add(new SimpleGrantedAuthority(user.getRole()));
        
        return new ArrayList<GrantedAuthority>(roles);
    }
    
    private UserDetails buildUserForAuthentication(Utente user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}