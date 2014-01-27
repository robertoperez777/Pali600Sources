package org.koushik.hibernate.Lesson06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Lesson06.Address;
import org.javabrains.koushik.dto.Lesson06.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Second User");
		Address addr = new Address();
		addr.setStreet("Street Name");
		addr.setCity("City name");
		user.setAddress(addr);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
	}

}
