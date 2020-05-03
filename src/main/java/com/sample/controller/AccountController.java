package com.sample.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AccountController {

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(
			Model model,
			@RequestParam
			Optional<String> error
			) {
		
		if(error.isPresent()) {
	    	model.addAttribute("errorMessage", "Cannot Authentication...Please check username and password"); 	
		}
    	model.addAttribute("message", "This is signin page"); 	
	    	
        return "account/signin";
	}
		

}
