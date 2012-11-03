package org.kep.filemakerparser.repository;

import org.kep.filemakerparser.domain.Munificence;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Munificence.class)
public interface MunificenceRepository {
}
