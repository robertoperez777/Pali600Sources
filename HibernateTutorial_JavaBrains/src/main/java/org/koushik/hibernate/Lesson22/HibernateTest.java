package org.koushik.hibernate.Lesson22;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Lesson22.UserDetails;

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
		
		Query query = session.createQuery("from UserDetails where userId > 5");
		List users = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Size of list result = " + users.size());
	}
}
