package com.javaworld.understandingjpa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ONLINECUSTOMER")
@DiscriminatorValue("ONLINE")
public class OnlineCustomer extends Customer {

	@Column(name = "WEBSITE", length = 100)
	private String website;

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
}
