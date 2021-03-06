package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			//start a transaction
			session.beginTransaction();

			int studentId = 101;
	
			//retrieve the student based on id
			Student myStudent = session.get(Student.class, studentId);
			
			//updating student
			myStudent.setEmail("vehaanskundra@gmail.com");
		
			
			//commit transaction
			session.getTransaction().commit();
			
			//---------------------------------------------
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
		

	}

}
