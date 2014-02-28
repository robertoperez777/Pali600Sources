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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	@Column(name = "MALE_NAME")
	private String maleName;
	@Column(name = "FEMALE_NAME")
	private String femaleName;
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	@Column(name = "MAIDEN_NAME")
	private String maidenName;
	@Column(name = "BIRTH_DATE")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@Column(name = "COMMENT")
	private String comment;
	@OneToMany
	@JoinTable(name="PERSON_CHILDREN", joinColumns = @JoinColumn(name="PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
	private Set<Child> children = new HashSet<Child>();
	@OneToMany
	@JoinTable(name = "PERSON_ADDRESS", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
	private Set<Address> addresses = new HashSet<Address>();
	@Column(name = "GENDER")
	private Gender gender;
	@OneToMany
	@JoinTable(name = "PERSON_PHONE_NUMBER", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "PHONE_NUMBER_ID"))
	private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
	@OneToMany
	@JoinTable(name = "PERSON_CONTRIBUTION", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "CONTRIBUTION_ID"))
	private Set<Contribution> contributions = new HashSet<Contribution>();
	@OneToMany
	@JoinTable(name = "PERSON_MUNIFICENCE", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "MUNIFICENCE_ID"))
	private Set<Munificence> munificences = new HashSet<Munificence>();

	public String getFemaleName() {
		return femaleName;
	}

	public void setFemaleName(String femaleName) {
		this.femaleName = femaleName;
	}

	public String getMaleName() {
		return maleName;
	}

	public void setMaleName(String maleName) {
		this.maleName = maleName;
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

	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}

	public Set<Contribution> getContributions() {
		return contributions;
	}

	public void setContributions(Set<Contribution> contributions) {
		this.contributions = contributions;
	}
}
