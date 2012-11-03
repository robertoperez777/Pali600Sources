package org.kep.filemakerparser.repository;

import org.kep.filemakerparser.domain.PhoneNumber;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = PhoneNumber.class)
public interface PhoneNumberRepository {
}
