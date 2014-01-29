package org.koushik.hibernate.Lesson20;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Lesson20.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Test User");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		user.setUserName("Updated User");
		user.setUserName("Updated User Again");
		
		session.getTransaction().commit();
		session.close();
		
		user.setUserName("Updated User After Session Close");
	}
}
