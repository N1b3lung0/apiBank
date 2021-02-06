package com.nextdigital.apibank.repositories.bank;

import com.nextdigital.apibank.domain.bank.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {

}
