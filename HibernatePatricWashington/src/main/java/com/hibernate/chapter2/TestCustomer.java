package com.hibernate.chapter2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestCustomer {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Customer.class);
		//		config.configure("hibernate.cfg.xml");
		config.configure();

		new SchemaExport(config).create(true, true);

		final SessionFactory sessionFactory = config.buildSessionFactory();
		final Session session = sessionFactory.openSession();

		session.beginTransaction();
		Customer alex = new Customer();
		alex.setCustomerName("Alex Rod");
		alex.setCustomerAddress("101 washington st, DC");
		alex.setCreaditScore(780);
		alex.setRewardsPoint(12000);

		session.save(alex);
		session.getTransaction().commit();
	}

}
