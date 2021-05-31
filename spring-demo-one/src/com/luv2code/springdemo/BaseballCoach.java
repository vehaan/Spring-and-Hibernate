package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	//define a private field for dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	
	public BaseballCoach() {
		super();
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {

		//use my fortuneService to get fortune
		return fortuneService.getFortune();
	}
	
	//add an init method
	public void doMyStartupStuff() {
		System.out.println("Inside startup method");
	}
	
	//add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("Inside Cleanup method");
	}

}
