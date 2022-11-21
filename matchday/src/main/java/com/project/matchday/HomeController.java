package com.project.matchday;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "home")
	public void getHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
	}	
}
