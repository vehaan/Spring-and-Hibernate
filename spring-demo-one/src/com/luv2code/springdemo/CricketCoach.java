package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	//add new fields for email and team
	private String email;
	private String team;
	
	
	
	public CricketCoach() {
		System.out.println("Inside no arg");
	}

	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Have a good day";
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside fortune setter");
		this.fortuneService = fortuneService;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		System.out.println("Inside email setter");
		this.email = email;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		System.out.println("Inside team setter");
		this.team = team;
	}
	
	
	
	

}
