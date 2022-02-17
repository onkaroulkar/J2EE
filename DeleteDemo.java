package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			
			// start a transaction
			session.beginTransaction();
			
			//get instructor by primay key/id
			int theId1=4;
			//int theId2=3;
			Instructor tempInstructor1 = session.get(Instructor.class, theId1);
			//Instructor tempInstructor2 = session.get(Instructor.class, theId2);
			System.out.println("deleting: "+ tempInstructor1);
			
			//Note: will Also delete associated "details" object
			//because of CascadeType.All
			
			session.delete(tempInstructor1);
			//session.delete(tempInstructor2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





