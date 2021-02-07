package com.nextdigital.apibank.domain.bank;

import com.nextdigital.apibank.domain.account.Account;
import com.nextdigital.apibank.domain.atm.Atm;
import com.nextdigital.apibank.domain.customer.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
@Table(name = "banks")
public class Bank implements Serializable {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private final UUID id;

    @OneToMany(fetch = FetchType.EAGER)
    private final List<Account> accounts;

    private static final long serialVersionUID = 3766001821340805955L;
}
