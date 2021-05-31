package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach3",Coach.class);
		Coach alphaCoach = context.getBean("myCoach3",Coach.class);

		//check if they are same
		boolean result = (theCoach == alphaCoach);
		
		//print the result
		System.out.println("Pointing to the same object " + result);
		
		System.out.println("Memory location for the Coach: " + theCoach);
		
		System.out.println("Memory location for the alphaCoach: " + alphaCoach);
		
		context.close();
	}

}
