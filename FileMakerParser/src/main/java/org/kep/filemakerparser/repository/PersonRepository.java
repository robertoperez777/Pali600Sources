package org.kep.filemakerparser.repository;

import org.kep.filemakerparser.domain.Person;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Person.class)
public interface PersonRepository {
}
