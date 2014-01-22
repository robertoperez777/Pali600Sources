package com.hibernate.onetoonemapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PersonDetail {

	private int personDetailId;
	private String zipCode;
	private String job;
	private double income;
	private Person person;

	@Id
	@GeneratedValue
	public int getPersonDetailId() {
		return this.personDetailId;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public String getJob() {
		return this.job;
	}

	public double getIncome() {
		return this.income;
	}

	public void setPersonDetailId(int personDetailId) {
		this.personDetailId = personDetailId;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	@OneToOne(mappedBy = "pDetail", cascade = CascadeType.ALL)
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
