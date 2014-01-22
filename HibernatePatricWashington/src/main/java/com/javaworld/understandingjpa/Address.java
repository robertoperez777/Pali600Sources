package com.javaworld.understandingjpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

	private static final long serialVersionUID = 5924232205224968592L;

	//By default column name is same as attribute name
	private String street;
	@Column(name = "APPT", nullable = false)
	private String appt;
	//By default column name is same as attribute name
	private String city;
	@Column(name = "ZIP_CODE", nullable = false)
	// Name of the corresponding database column
	private String zipCode;

	public String getStreet() {
		return this.street;
	}

	public String getAppt() {
		return this.appt;
	}

	public String getCity() {
		return this.city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setAppt(String appt) {
		this.appt = appt;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
