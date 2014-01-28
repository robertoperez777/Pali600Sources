package org.kep.filemakerparser.domain;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class PhoneNumber {

	private String phoneNumber;

	@NotNull
	@ManyToOne
	private Person person;
}
