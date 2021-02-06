package com.nextdigital.apibank.repositories.account;

import com.nextdigital.apibank.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

}
