package org.koushik.hibernate.Lesson07;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Lesson07.Address;
import org.javabrains.koushik.dto.Lesson07.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		Address addr = new Address();
		addr.setStreet("Street Name");
		addr.setCity("City name");
		user.setHomeAddress(addr);
		
		Address addr2 = new Address();
		addr2.setStreet("Second Street Name");
		addr2.setCity("Second City name");
		user.setOfficeAddress(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

}
