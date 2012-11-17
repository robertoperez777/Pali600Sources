package org.kep.filemakerparser.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaEntity
@RooJson(deepSerialize = true)
public class Person {

	@NotNull
	private String name;

	private String emailAddress;

	private String maidenName;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date birthDate;

	private String marriedName;

	private String comment;

	@ManyToOne
	private Address address;

	@Enumerated
	private Gender gender;

	@NotNull
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();

	@NotNull
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private Set<ChurchMaintenance> churchMaintenances = new HashSet<ChurchMaintenance>();

	@NotNull
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private Set<Munificence> munificences = new HashSet<Munificence>();
}
