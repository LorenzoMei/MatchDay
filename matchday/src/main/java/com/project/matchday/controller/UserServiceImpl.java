package com.project.matchday.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.matchday.interfaces.UserRepository;
import com.project.matchday.interfaces.UserService;
import com.project.matchday.model.UserRoles;
import com.project.matchday.model.Utente;

@Component
@Controller
public class UserServiceImpl implements UserService{

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;
    
    
    
    @GetMapping(value = {"/login"})
    public ModelAndView login() {
        return new ModelAndView("login");
    }
    
    @GetMapping(value = {"/logout"})
    public String logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:login";
    }



    @GetMapping(value = "/register")
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("userRegistrationData", new Utente());
        return modelAndView;
    }
    
    @PostMapping(value = "/register")
    public ModelAndView signup(@Valid @ModelAttribute("userRegistrationData") Utente user, BindingResult bindingResult) {
    	ModelAndView modelAndView = new ModelAndView("register");
    	if (bindingResult.hasErrors()) {
            return modelAndView;
    	}
    	else {
            try {
            	Utente nuovo = signup(user);
            	if(nuovo == null) {
            		bindingResult.rejectValue("email", "error.userRegistrationData", "Account già esistente con questa email!");
            		return modelAndView;
            	}
            	return new ModelAndView("login");
            	}
            catch (Exception exception) {
                bindingResult.rejectValue("email", "error.userRegistrationData", exception.getMessage());
                return modelAndView;
            }
    	}
        
    	
    	
    }
    
    @Override
    public Utente signup(Utente user) { 
    	
    	Utente userFromDb = userRepository.findByEmail(user.getEmail());
    	if(userFromDb != null ) {
            return null;
        }
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setStatoAttivo(true);
        user.setRole(UserRoles.USER.name());
        user.setSaldo(0.00);
        
        userRepository.save(user);
        return user;
    }
    
    /**
     * Search an existing user
     *
     * @param email
     * @return
     */
    public Utente findUserByEmail(String email) {
        Optional<Utente> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {
            return user.get();
        }
        else {
        	user.isEmpty();
        	return null;
        }
    }


}
