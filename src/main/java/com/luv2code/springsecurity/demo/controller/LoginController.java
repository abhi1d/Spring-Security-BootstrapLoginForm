package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		//return "plain-login";
		return "fancy-login";
	}
	
	
	// Add request Mapping for /access-denied page 
	
	@GetMapping("/access-denied")
	public String showAcessdenied() {
		return "access-denied";
	}
}
