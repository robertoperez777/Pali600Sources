package org.kep.filemakerparser.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaEntity
@RooJson(deepSerialize = true)
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
