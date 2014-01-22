package com.hibernate.chapter3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestAccount {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Accounts.class);
		config.configure();

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();

		CompoundKey key1 = new CompoundKey(100, 10001);
		Accounts savings = new Accounts();
		savings.setCompoundKey(key1);
		savings.setAccountBalance(8500);
	}

}
