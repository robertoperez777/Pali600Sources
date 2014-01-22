package com.hibernate.chapter1;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestEmployee {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Employee.class);
		//		config.configure("hibernate.cfg.xml");
		config.configure();

		//		new SchemaExport(config).create(true, true);

		final SessionFactory sessionFactory = config.buildSessionFactory();
		final Session session = sessionFactory.openSession();

		session.beginTransaction();
		{
			Employee alex = new Employee();
			//alex.setEmpId(100);
			alex.setEmpName("Alex Berry");
			alex.setEmpEmailAddress("alex@hibernate.com");
			alex.setEmpPassword("alexpass");
			alex.setPermanent(true);
			alex.setEmpJoinDate(new GregorianCalendar(2009, 05, 26));
			alex.setEmpLoginTime(Date.valueOf("2010-06-05"));

			session.saveOrUpdate(alex);
		}
		{
			Employee linda = new Employee();
			linda.setEmpName("Linda Chase");
			linda.setEmpEmailAddress("linda@hibernate.com");
			linda.setEmpPassword("lindapass");
			linda.setPermanent(true);
			linda.setEmpJoinDate(new GregorianCalendar(2008, 04, 20));
			linda.setEmpLoginTime(new java.util.Date());
			session.saveOrUpdate(linda);
		}
		{
			Employee john = new Employee();
			john.setEmpName("John Love");
			john.setEmpEmailAddress("john@hibernate.com");
			john.setEmpPassword("johnpass");
			john.setPermanent(true);
			john.setEmpJoinDate(new GregorianCalendar(2008, 04, 20));
			john.setEmpLoginTime(new java.util.Date());
			session.saveOrUpdate(john);
		}

		session.getTransaction().commit();
		session.close();

	}
}
