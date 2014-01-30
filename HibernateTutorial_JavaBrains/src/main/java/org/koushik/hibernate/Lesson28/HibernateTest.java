package org.koushik.hibernate.Lesson28;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.javabrains.koushik.dto.Lesson28.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 0; i <= 10; i++) {
			UserDetails user = new UserDetails();
			user.setUserName("User " + i);
			session.save(user);
		}

		UserDetails exampleUser = new UserDetails();
		//exampleUser.setUserId(5);
		exampleUser.setUserName("User 5");

		Example example = Example.create(exampleUser);

		Criteria criteria = session.createCriteria(UserDetails.class).add(example);

		List<UserDetails> users = criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails u : users) {
			System.out.println(u.getUserName());
		}
	}
}
