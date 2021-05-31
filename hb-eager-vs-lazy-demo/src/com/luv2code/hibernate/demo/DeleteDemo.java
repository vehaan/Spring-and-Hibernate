package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get instructor by id/primary key
			int theId = 3;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor: " + tempInstructor);
			
			//delete the instructor
			if (tempInstructor != null)
				session.delete(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
		

	}

}
