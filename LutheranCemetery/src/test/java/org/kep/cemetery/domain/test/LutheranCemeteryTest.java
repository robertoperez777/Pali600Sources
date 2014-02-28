package org.kep.cemetery.domain.test;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.kep.cemetery.domain.Address;
import org.kep.cemetery.domain.Child;
import org.kep.cemetery.domain.Contribution;
import org.kep.cemetery.domain.Gender;
import org.kep.cemetery.domain.Munificence;
import org.kep.cemetery.domain.Person;
import org.kep.cemetery.domain.PhoneNumber;
import org.kep.cemetery.util.HibernateUtil;

public class LutheranCemeteryTest {

	Session session = null;
	Transaction transaction = null;

	@Before
	public void setUp() throws Exception {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	@Test
	public void testLutheranCemetery() {
		try {
			this.transaction = this.session.beginTransaction();
			Person person = new Person();
			person.setMaleName("Gipsz Jánosné");
			person.setGender(Gender.FEMALE);
			person.setBirthDate(new Date());
			person.setEmailAddress("mail@mail.hu");
			person.setComment("Megjegyzés");
			
			Child child = new Child();
			child.setName("Tom");
			child.setBirthDate(new Date());
			
			Child child2 = new Child();
			child2.setName("Jerry");
			child2.setBirthDate(new Date());

			Address address = new Address();
			address.setCity("Test city");
			address.setCountry("Test country");
			address.setStreet("Test street");
			address.setZipCode("6200");
			address.setPerson(person);

			PhoneNumber phoneNumber1 = new PhoneNumber();
			phoneNumber1.setPhoneNumber("06309169033");
			PhoneNumber phoneNumber2 = new PhoneNumber();
			phoneNumber2.setPhoneNumber("06201234667");
			phoneNumber1.setPerson(person);

			Contribution contribution = new Contribution();			
			contribution.setAmount(new BigDecimal(5000));
			contribution.setDate(new Date());
			contribution.setDescription("Hozzájárulás");
			contribution.setPaymentNumber(12);
			contribution.setPerson(person);

			Contribution contribution2 = new Contribution();
			contribution2.setAmount(new BigDecimal(6000));
			contribution2.setDate(new Date());
			contribution2.setDescription("Hozzájárulás 2");
			contribution2.setPaymentNumber(13);
			contribution2.setPerson(person);

			Munificence munificence = new Munificence();
			munificence.setAmount(new BigDecimal(6000));
			munificence.setDate(new Date());
			munificence.setPurpose("Oka");
			munificence.setDescription("megjegyzés");
			munificence.setPerson(person);

			Munificence munificence2 = new Munificence();
			munificence2.setAmount(new BigDecimal(4000));
			munificence2.setDate(new Date());
			munificence2.setPurpose("Oka 2");
			munificence2.setDescription("megjegyzés 2");
			munificence2.setPerson(person);

			person.getAddresses().add(address);
			person.getPhoneNumbers().add(phoneNumber1);
			person.getPhoneNumbers().add(phoneNumber2);
			person.getContributions().add(contribution);
			person.getContributions().add(contribution2);
			person.getMunificences().add(munificence);
			person.getMunificences().add(munificence2);
			person.getChildren().add(child);
			person.getChildren().add(child2);

			this.session.save(address);
			this.session.save(phoneNumber1);
			this.session.save(phoneNumber2);
			this.session.save(contribution);
			this.session.save(contribution2);
			this.session.save(munificence);
			this.session.save(munificence2);
			this.session.save(child);
			this.session.save(child2);
			this.session.save(person);

			this.transaction.commit();
		} catch (HibernateException e) {
			this.transaction.rollback();
			e.printStackTrace();
		} finally {
			this.session.close();
		}
	}
}
