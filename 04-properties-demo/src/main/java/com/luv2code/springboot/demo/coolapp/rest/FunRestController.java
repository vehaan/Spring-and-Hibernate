package com.luv2code.springboot.demo.coolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	//inject properties for: coach.name and team.name
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + coachName + " , Team name:  " + teamName;
	}

	@RequestMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}
	
	@RequestMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	
	@RequestMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day";
	}
	
}
