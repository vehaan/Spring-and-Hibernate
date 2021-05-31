package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//OR @Component("anyId")
//@Scope("prototype") //For scope, singleton is default
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("happyFortuneService") //provide bean id if multiple implementation of class is there
	private FortuneService fortuneService;
	
//	@Value("${foo.email}") //to fill value from property file
//	private String email;

	//Commented because setter injection is used below
	//@Autowired 
	//Autowired annotation is not needed post spring 4.3 but if there are multiple constructors then it must be there to specify the constructor to be used
	/*
	 * public TennisCoach(FortuneService fortuneService) { this.fortuneService =
	 * fortuneService; }
	 */
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	
	//Example of setter injection
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	//Example of Method injection
//	@Autowired
//	public void anyMethodname(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	@PostConstruct //PUT JAVAX.ANNOTATION IN BUILD PATH FOR JAVA 9+
	public void doMySetupStufF() {
		System.out.println("Post Construct method");
	}
	
	@PreDestroy //PROTOTYPE SCOPED BEAN DOESN'T EXECUTE THIS
	public void doMyCleanupStufF() {
		System.out.println("Pre Destroy method");
	}
	

	
	

}
