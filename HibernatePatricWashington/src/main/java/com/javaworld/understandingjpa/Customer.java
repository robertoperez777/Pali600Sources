package com.javaworld.understandingjpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import com.javaworld.understandingjpa.Customer.CustListener;

@EntityListeners({ CustListener.class })
@Entity(name = "CUSTOMER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CUST_TYPE", discriminatorType = DiscriminatorType.STRING, length = 10)
@DiscriminatorValue("RETAIL")
@IdClass(Customer.CustomerId.class)
public class Customer implements Serializable {

	private static final long serialVersionUID = -8506468669650180826L;

	@Id
	@Column(name = "CUST_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long custId;
	@Column(name = "FIRST_NAME", nullable = false, length = 50)
	private String fistName;
	@Column(name = "LAST_NAME", length = 50)
	private String lastName;
	@Embedded
	private Address address = new Address();
	@Column(name = "CUST_TYPE", length = 10)
	private String custType;
	@Version
	@Column(name = "LAST_UPDATED_TIME")
	private Date updatedTime;

	public class CustomerId {

		public String firstname;
		public String lastName;

		public String getFirstname() {
			return this.firstname;
		}

		public String getLastName() {
			return this.lastName;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

	}

	public class CustListener {

		@PreUpdate
		public void preUpdate() {
			System.out.println("In pre update");
		}

		@PostUpdate
		public void postUpdate(Customer cust) {
			System.out.println("In post update");
		}
	}

	public long getCustId() {
		return this.custId;
	}

	public String getFistName() {
		return this.fistName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getCustType() {
		return this.custType;
	}

	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
