package com.nextdigital.apibank.repositories.atm;

import com.nextdigital.apibank.domain.atm.Atm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AtmRepository extends JpaRepository<Atm, UUID> {

}
