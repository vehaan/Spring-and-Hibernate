package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "plain-login";
	}
	
	//add a request mapping for acess denied
	@GetMapping("/access-denied")
	public String showMAccessDenied() {
		return "access-denied";
	}
}
