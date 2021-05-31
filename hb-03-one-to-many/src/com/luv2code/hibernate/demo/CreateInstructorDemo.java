package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a Instructor object
			
			  Instructor tempInstructor = new
			  Instructor("Susan","public","susan@luv2code.com");
			  
			  InstructorDetail tempInstructorDetail = new
			  InstructorDetail("http://www.luv2code.com.youtube", "Luv 2 game!");
			  
			  tempInstructor.setInstructorDetail(tempInstructorDetail);
			 
			
			Instructor tempInstructor1 = new Instructor("Madhu","Patel","madhu@luv2code.com");
			
			InstructorDetail tempInstructorDetail1 = new InstructorDetail("http://www.luv2code.com.youtube", "Luv 2 code!");
			
			tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		
			//start a transaction
			session.beginTransaction();
			
			//save the object
			//NOTE: This will also save the detail object
			//because of cascadeType.ALL
			session.save(tempInstructor);
			session.save(tempInstructor1);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			session.close();
			factory.close();
		}
		

	}

}
