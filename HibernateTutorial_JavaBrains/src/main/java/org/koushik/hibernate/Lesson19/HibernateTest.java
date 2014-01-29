package org.koushik.hibernate.Lesson19;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Lesson19.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for (int i = 0; i < 10; i++) {
			UserDetails user = new UserDetails();
			user.setUserName("User " + i);
			session.save(user);
		}
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		//session.delete(user);
		user.setUserName("Updated User");
		session.update(user);
		
		System.out.println("User name pulled up is: " + user.getUserName());
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("User name pulled up is: " + user.getUserName());
	}
}
