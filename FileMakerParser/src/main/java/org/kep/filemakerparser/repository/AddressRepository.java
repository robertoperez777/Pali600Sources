package org.kep.filemakerparser.repository;

import org.kep.filemakerparser.domain.Address;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Address.class)
public interface AddressRepository {
}
