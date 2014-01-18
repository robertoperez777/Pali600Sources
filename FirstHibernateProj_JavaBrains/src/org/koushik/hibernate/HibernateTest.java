package org.koushik.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest {
	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("First User");
		user.setJoinedDate(new Date());
		user.setDescription("Description of the user goes here");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		vehicle.setUser(user);

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		vehicle2.setUser(user);

		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);

		Address address = new Address();
		address.setStreet("First Street");
		address.setCity("First City");
		address.setState("First State");
		address.setPinCode("100001");

		UserDetails user2 = new UserDetails();
		user2.setUserName("Second User");
		user2.setJoinedDate(new Date());
		user2.setDescription("Description of the user goes here");
		user.setHomeAddress(address);

		Address address2 = new Address();
		address2.setStreet("Second Street");
		address2.setCity("Second City");
		address2.setState("Second State");
		address2.setPinCode("200002");
		user2.setOfficeAddress(address2);

		user.getListOfAdresses().add(address);
		user.getListOfAdresses().add(address2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();

		user = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User name retrived is " + user.getUserName());
		session.close();

		user = null;
		session = sessionFactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getListOfAdresses().size());
	}
}
