package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
	
			//start a transaction
			session.beginTransaction();
			
			//retrieve a student based on primary key
			Student myStudent = session.get(Student.class, 0);
			
			//delete the student
//			session.delete(myStudent);
			
			//delete using query approach
			session.createQuery("delete from Student where id=103").executeUpdate();
			

			//commit the transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		

	}

}
