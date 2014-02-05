package org.kep.cemetery.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CHURCH_MAINTENANCE")
public class ChurchMaintenance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "PAYMENT_NUMBER")
	private int paymentNumber;
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "DESCRIPTION")
	private String description;
	@ManyToOne
	private Person person;

	public int getPaymentNumber() {
		return this.paymentNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
