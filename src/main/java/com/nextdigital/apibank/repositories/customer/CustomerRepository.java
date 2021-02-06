package com.nextdigital.apibank.repositories.customer;

import com.nextdigital.apibank.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
