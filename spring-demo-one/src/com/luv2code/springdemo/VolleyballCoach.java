package com.luv2code.springdemo;

public class VolleyballCoach implements Coach {
	
	String name;
	int id;
	
	public VolleyballCoach() {
		// TODO Auto-generated constructor stub
	}
		
	public VolleyballCoach(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}


	@Override
	public String getDailyWorkout() {
		return "I," + this.name +  " " + this.id +",is your Volleyball Coach.";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
