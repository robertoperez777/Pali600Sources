package org.kep.filemakerparser.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaEntity
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

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<Address>();

    @Enumerated
    private Gender gender;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
}
