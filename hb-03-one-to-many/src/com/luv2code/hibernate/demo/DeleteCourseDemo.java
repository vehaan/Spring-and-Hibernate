package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			//get a course 
			Course tempCourse = session.get(Course.class, 5);
			
			//delete a course
			session.delete(tempCourse);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			session.close();
			factory.close();
		}
		

	}

}
