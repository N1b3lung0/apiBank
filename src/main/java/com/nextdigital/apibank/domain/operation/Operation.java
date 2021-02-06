package com.nextdigital.apibank.domain.operation;

import com.nextdigital.apibank.domain.account.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor // Generates a constructor with 1 parameter for each field thar requires special handling
@NoArgsConstructor(force = true) // Constructor with no parameters. Final fields are initialized with 0 / false / null
@EqualsAndHashCode(callSuper = false)
@Table(name = "operations")
public class Operation implements Serializable {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private final UUID id;

    @Column
    private final OperationType operationType;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private final Account account;

    private static final long serialVersionUID = -9144982998131748421L;
}
