package com.hibernate.chapter3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestSchool {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(School.class);
		//config.configure("hibernate.cfg.xml");
		config.configure();
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		SchoolDetail annsDetail = new SchoolDetail();
		annsDetail.setPublicSchool(false);
		annsDetail.setSchoolAddress("101 washington, DC");
		annsDetail.setStudentCount(300);

		School stanns = new School();
		stanns.setSchoolName("St. Anns School");
		stanns.setSchoolDetail(annsDetail);

		session.save(stanns);
		session.getTransaction().commit();

	}
}
