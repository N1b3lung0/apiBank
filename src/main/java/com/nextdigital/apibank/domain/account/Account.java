package com.nextdigital.apibank.domain.account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor // Generates a constructor with 1 parameter for each field thar requires special handling
@NoArgsConstructor(force = true) // Constructor with no parameters. Final fields are initialized with 0 / false / null
@EqualsAndHashCode(callSuper = false)
@Table(name = "accounts")
public final class Account implements Serializable {

    @Id
    @GeneratedValue
    private final UUID id;



    private static final long serialVersionUID = -8990944830025803370L;
}
