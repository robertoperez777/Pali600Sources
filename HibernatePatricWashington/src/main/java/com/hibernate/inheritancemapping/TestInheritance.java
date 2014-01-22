package com.hibernate.inheritancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestInheritance {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(Module.class);
		config.addAnnotatedClass(Task.class);
		//config.configure("hibernate.cfg.xml");
		config.configure();
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Project p = new Project();
		p.setProjectName("Hibernate Lessons");

		Module m = new Module();
		m.setProjectName("Spring lessons");
		m.setModuleName("AOP");

		Task t = new Task();
		t.setProjectName("Java lessons");
		t.setModuleName("Collections");
		t.setTaskName("ArrayList");

		session.save(p);
		session.save(m);
		session.save(t);

		session.getTransaction().commit();

	}
}
