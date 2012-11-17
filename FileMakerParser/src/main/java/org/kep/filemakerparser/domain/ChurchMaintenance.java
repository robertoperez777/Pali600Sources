package org.kep.filemakerparser.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.ManyToOne;
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
public class ChurchMaintenance {

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date yearOfMaintenance;

	@NotNull
	private int paymentNumber;

	@NotNull
	private BigDecimal amount;

	private String description;

	@NotNull
	@ManyToOne
	private Person person;
}
