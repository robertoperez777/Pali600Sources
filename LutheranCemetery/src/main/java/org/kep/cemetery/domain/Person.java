package org.kep.cemetery.domain;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
    private String name;
    private String emailAddress;
    private String maidenName;
    private Date birthDate;
    private String marriedName;
    private String comment;
    private Set<Address> addresses = new HashSet<Address>();
    private Gender gender;
    @OneToMany
    private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
    @OneToMany
    private Set<ChurchMaintenance> churchMaintenances = new HashSet<ChurchMaintenance>();
    @OneToMany
    private Set<Munificence> munificences = new HashSet<Munificence>();
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMaidenName() {
		return maidenName;
	}
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getMarriedName() {
		return marriedName;
	}
	public void setMarriedName(String marriedName) {
		this.marriedName = marriedName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Set<ChurchMaintenance> getChurchMaintenances() {
		return churchMaintenances;
	}
	public void setChurchMaintenances(Set<ChurchMaintenance> churchMaintenances) {
		this.churchMaintenances = churchMaintenances;
	}
	public Set<Munificence> getMunificences() {
		return munificences;
	}
	public void setMunificences(Set<Munificence> munificences) {
		this.munificences = munificences;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
