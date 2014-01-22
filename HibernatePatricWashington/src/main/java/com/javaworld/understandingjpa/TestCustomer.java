package com.javaworld.understandingjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestCustomer {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testjpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction userTransaction = em.getTransaction();

		userTransaction.begin();
		//insert Customer
		Customer customer = new Customer();
		customer.setFistName("Charles");
		customer.setLastName("Dickens");
		customer.setCustType("RETAIL");
		customer.getAddress().setStreet("10 Downing Street");
		customer.getAddress().setAppt("1");
		customer.getAddress().setCity("NewYork");
		customer.getAddress().setZipCode("12345");
		em.persist(customer);

		//insert Online customer
		OnlineCustomer onlineCust = new OnlineCustomer();
		onlineCust.setFistName("Henry");
		onlineCust.setLastName("Ho");
		onlineCust.setCustType("ONLINE");
		onlineCust.getAddress().setStreet("1 Mission Street");
		onlineCust.getAddress().setAppt("111");
		onlineCust.getAddress().setCity("New York");
		onlineCust.getAddress().setZipCode("23456");
		onlineCust.setWebsite("www.amazon.com");
		em.persist(onlineCust);

		userTransaction.commit();

		Query query = em.createQuery("SELECT customer from ONLINECUSTOMER customer");
		List<OnlineCustomer> list = query.getResultList();

		em.close();
		entityManagerFactory.close();
	}
}
