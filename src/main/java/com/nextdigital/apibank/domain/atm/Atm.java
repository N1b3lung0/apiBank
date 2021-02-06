package com.nextdigital.apibank.domain.atm;

import com.nextdigital.apibank.domain.bank.Bank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor // Generates a constructor with 1 parameter for each field thar requires special handling
@NoArgsConstructor(force = true) // Constructor with no parameters. Final fields are initialized with 0 / false / null
@EqualsAndHashCode(callSuper = false)
@Table(name = "atms")
public class Atm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final UUID id;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private final Bank bank;

    private static final long serialVersionUID = -5060635705662946394L;
}
