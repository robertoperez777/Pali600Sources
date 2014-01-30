package org.koushik.hibernate.Lesson27;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.javabrains.koushik.dto.Lesson27.UserDetails;

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

		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.like("userName", "%User 1%")).add(Restrictions.between("userId", 5, 50))
				.add(Restrictions.or(Restrictions.between("userId", 0, 3), Restrictions.between("userId", 7, 11)));

		List<UserDetails> users = criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails u : users) {
			System.out.println(u.getUserName());
		}
	}
}
