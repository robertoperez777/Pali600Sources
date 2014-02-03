package org.kep.cemetery.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Person {

    /**
     */
    @NotNull
    private String name;

    /**
     */
    private String emailAddress;

    /**
     */
    private String maidenName;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date birthDate;

    /**
     */
    private String marriedName;

    /**
     */
    private String comment;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<Address>();

    /**
     */
    @Enumerated
    private Gender gender;

    /**
     */
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();

    /**
     */
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ChurchMaintenance> churchMaintenances = new HashSet<ChurchMaintenance>();

    /**
     */
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Munificence> munificences = new HashSet<Munificence>();
}
