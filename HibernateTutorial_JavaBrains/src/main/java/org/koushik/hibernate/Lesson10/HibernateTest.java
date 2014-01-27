package org.koushik.hibernate.Lesson10;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Lesson10.Address;
import org.javabrains.koushik.dto.Lesson10.UserDetails;



public class HibernateTest {
	
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		Address addr1 = new Address();
		addr1.setStreet("First Street");
		addr1.setCity("First City");
		addr1.setState("First State");
		addr1.setPinCode("100001");
		
		Address addr2 = new Address();
		addr2.setStreet("Second Street");
		addr2.setCity("Second City");
		addr2.setState("Second State");
		addr2.setPinCode("200002");
		
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		user = null;
		
		session = sessionFactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getListOfAddresses().size());
	}

}
