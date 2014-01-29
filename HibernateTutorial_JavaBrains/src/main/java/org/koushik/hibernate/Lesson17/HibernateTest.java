package org.koushik.hibernate.Lesson17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Lesson17.FourWheeler;
import org.javabrains.koushik.dto.Lesson17.TwoWheeler;
import org.javabrains.koushik.dto.Lesson17.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porshe");
		car.setSteeringWheel("Porsche Steering Wheel");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
	}
}
