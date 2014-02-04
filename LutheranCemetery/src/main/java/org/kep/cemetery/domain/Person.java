package org.kep.cemetery.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	@Column(name = "MAIDEN_NAME")
	private String maidenName;
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	@Column(name = "MARRIED_NAME")
	private String marriedName;
	@Column(name = "COMMENT")
	private String comment;
	@OneToMany
	@JoinTable(name = "PERSON_ADDRESS", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
	private Set<Address> addresses = new HashSet<Address>();
	@Column(name = "GENDER")
	private Gender gender;
	@OneToMany
	@JoinTable(name = "PERSON_PHONE_NUMBER", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "PHONE_NUMBER_ID"))
	private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
	@OneToMany
	@JoinTable(name = "PERSON_CHURCH_MAINTENANCE", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "CHURCH_MAINTENANCE_ID"))
	private Set<ChurchMaintenance> churchMaintenances = new HashSet<ChurchMaintenance>();
	@OneToMany
	@JoinTable(name = "PERSON_MUNIFICENCE", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "MUNIFICENCE_ID"))
	private Set<Munificence> munificences = new HashSet<Munificence>();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMaidenName() {
		return this.maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMarriedName() {
		return this.marriedName;
	}

	public void setMarriedName(String marriedName) {
		this.marriedName = marriedName;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Set<PhoneNumber> getPhoneNumbers() {
		return this.phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Set<ChurchMaintenance> getChurchMaintenances() {
		return this.churchMaintenances;
	}

	public void setChurchMaintenances(Set<ChurchMaintenance> churchMaintenances) {
		this.churchMaintenances = churchMaintenances;
	}

	public Set<Munificence> getMunificences() {
		return this.munificences;
	}

	public void setMunificences(Set<Munificence> munificences) {
		this.munificences = munificences;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
