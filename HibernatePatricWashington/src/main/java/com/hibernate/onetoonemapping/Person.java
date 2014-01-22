package com.hibernate.onetoonemapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {

	private int personId;
	private String personName;
	private PersonDetail personDetail;

	@Id
	@GeneratedValue
	@Column(name = "detailId_PK")
	public int getPersonId() {
		return this.personId;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pDetail_FK")
	public PersonDetail getPersonDetail() {
		return this.personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

}
