package org.koushik.hibernate.Lesson21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Lesson21.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Test User");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		user = null;
		
		user = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();

		user.setUserName("Updated username after session close");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
	}
}
