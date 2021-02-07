package com.nextdigital.apibank.domain.account;

import com.nextdigital.apibank.domain.bank.Bank;
import com.nextdigital.apibank.domain.card.Card;
import com.nextdigital.apibank.domain.customer.Customer;
import com.nextdigital.apibank.domain.operation.Operation;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor // Generates a constructor with 1 parameter for each field thar requires special handling
@NoArgsConstructor(force = true) // Constructor with no parameters. Final fields are initialized with 0 / false / null
@EqualsAndHashCode(callSuper = false)
@Table(name = "accounts")
public final class Account implements Serializable {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private final UUID id;

    @Column(name = "balance", nullable = false)
    private final double balance;

    @Column(name = "iban", nullable = false)
    private final String iban;

    @Column(name = "account_number", nullable = false)
    private final String accountNumber;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne
    private final Card card;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private final Bank bank;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private final Customer customer;

    @OneToMany(fetch = FetchType.EAGER)
    private final List<Operation> operations;

    private static final long serialVersionUID = -8990944830025803370L;
}
