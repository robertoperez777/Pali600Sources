package org.kep.filemakerparser.repository;

import org.kep.filemakerparser.domain.Gender;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Gender.class)
public interface GenderRepository {
}
