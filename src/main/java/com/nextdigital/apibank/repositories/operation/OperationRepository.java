package com.nextdigital.apibank.repositories.operation;

import com.nextdigital.apibank.domain.operation.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperationRepository extends JpaRepository<Operation, UUID> {

}
