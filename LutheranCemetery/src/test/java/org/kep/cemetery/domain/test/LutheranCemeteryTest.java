package org.kep.cemetery.domain.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.kep.cemetery.domain.Address;
import org.kep.cemetery.util.HibernateUtil;

public class LutheranCemeteryTest {

	Session session = null;
	Transaction transaction = null;
	
	@Before
	public void setUp() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Test
	public void testLutheranCemetery() {
		try {
			transaction = session.beginTransaction();
			Address address = new Address();
			address.setCity("Test city");
			address.setCountry("Test country");
			address.setStreet("Test street");
			address.setZipCode("6200");
			session.save(address);
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
