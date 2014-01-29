package org.koushik.hibernate.Lesson15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Lesson15.FourWheeler;
import org.javabrains.koushik.dto.Lesson15.TwoWheeler;

public class HibernateTest {

	public static void main(String[] args) {

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porshe");
		car.setSteeringWheel("Porsche Steering Wheel");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
	}

}
