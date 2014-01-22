package com.hibernate.chapter2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
@SecondaryTable(name = "CustomerDetail")
public class Customer {

	private int customerId;
	private String customerName;
	private String customerAddress;
	private int creaditScore;
	private int rewardsPoint;

	@Id
	@GeneratedValue
	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(table = "CustomerDetail")
	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Column(table = "CustomerDetail")
	public int getCreaditScore() {
		return this.creaditScore;
	}

	public void setCreaditScore(int creaditScore) {
		this.creaditScore = creaditScore;
	}

	@Column(table = "CustomerDetail")
	public int getRewardsPoint() {
		return this.rewardsPoint;
	}

	public void setRewardsPoint(int rewardsPoint) {
		this.rewardsPoint = rewardsPoint;
	}
}
