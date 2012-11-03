package org.kep.filemakerparser.repository;

import org.kep.filemakerparser.domain.ChurchMaintenance;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = ChurchMaintenance.class)
public interface ChurchMaintenanceRepository {
}
