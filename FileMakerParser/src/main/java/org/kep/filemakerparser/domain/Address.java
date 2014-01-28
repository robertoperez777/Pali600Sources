package org.kep.filemakerparser.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Address {

	@NotNull
	private String street;

	@NotNull
	private String city;

	@NotNull
	@Size(min = 4)
	private String zipCode;

	private String country;

	@NotNull
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
	private Set<Person> pesons = new HashSet<Person>();
}
