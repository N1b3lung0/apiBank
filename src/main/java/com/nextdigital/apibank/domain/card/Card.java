package com.nextdigital.apibank.domain.card;

import com.nextdigital.apibank.domain.account.Account;
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
@Table(name = "cards")
public final class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final UUID id;

    @Column(name = "card_number", nullable = false)
    private final Integer cardNumber;

    @Column(name = "pin", nullable = false)
    private final Integer pin;

    @Column(name = "is_activated", nullable = false)
    private final Boolean activated;

    @Column(name = "card_type", nullable = false)
    private final CardType cardType;

    @Column(name = "credit", nullable = false)
    private final double credit;

    @OneToOne
    private final Account account;

    private static final long serialVersionUID = 3975634709368236646L;

}
