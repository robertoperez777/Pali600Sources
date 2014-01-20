package org.koushik.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
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
		session.beginTransaction();
		
		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserId(5);
		exampleUser.setUserName("User 5");
		
		Example example = Example.create(exampleUser).excludeProperty("userName");
		
		Criteria criteria = session.createCriteria(UserDetails.class).add(example);

		criteria
			.add(Restrictions.like("userName", "%User%"))
			.add(Restrictions.between("userId", 0, 50));
		List<UserDetails> users = (List<UserDetails>) criteria.list();
		for (UserDetails userDetails : users) {
			System.out.println(userDetails.getUserName());
		}				
		
		
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "Second User");
		users = (List<UserDetails>) query.list();
		for (UserDetails userDetails : users) {
			System.out.println(userDetails.getUserName());
		}				
		
		String minUserId = "0";
		String userName = "Second User";
		query = session.createQuery("from UserDetails where userId > :userId and userName = :userName");
		query.setInteger("userId", Integer.parseInt(minUserId));
		query.setString("userName", userName);
		
		users = (List<UserDetails>) query.list();
		System.out.println("User list size: " + users.size());
		//session.getTransaction().commit();
		session.close();
		//System.out.println(user.getListOfAdresses().size());
	}
}
