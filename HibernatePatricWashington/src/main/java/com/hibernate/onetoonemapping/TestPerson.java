package com.hibernate.onetoonemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestPerson {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);

		config.configure();
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		PersonDetail alexDetail = new PersonDetail();
		alexDetail.setZipCode("20815");
		alexDetail.setJob("Accountant");
		alexDetail.setIncome(67245.56);
		Person alex = new Person();
		alex.setPersonName("Alex Berry");
		alex.setPersonDetail(alexDetail);

		session.save(alex);
		session.getTransaction().commit();
	}

}
