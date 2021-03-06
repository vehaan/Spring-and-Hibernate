package com.luv2code.springdemo.mvc;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.*;
@Controller
public class HelloWorldController {

	//need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//add a new controller to read form data
	//add data to model
	
//	@RequestMapping("/processFormVerisonTwo")
//	public String letsShhoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter from HTML form
//		String theName = request.getHeaders("studentName");
		
		//convert data to all caps
//		theName = theName.toUpperCase();
		
		//create the message
//	String result = "Yo!" + theName;
		
		//add message to the model
//		model.addAttribute("message",result);
//		return "helloworld";
//	}
	
	@RequestMapping("/processFormVerisonThree")
	public String letsShhoutDude(@RequestParam("studentName") String theName, Model model) {
	
		//convert data to all caps
		theName = theName.toUpperCase();
		
		//create the message
	String result = "Hey My Friend from V3! " + theName;
		
		//add message to the model
		model.addAttribute("message",result);
		return "helloworld";
	}
}
