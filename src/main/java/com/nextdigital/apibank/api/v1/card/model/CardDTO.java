package com.nextdigital.apibank.api.v1.card.model;

import com.nextdigital.apibank.domain.account.Account;
import com.nextdigital.apibank.domain.card.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true) // Constructor with no parameters. Final fields are initialized with 0 / false / null
public class CardDTO implements Serializable {

    private UUID id;
    private String pin;
    private Boolean activated;
    private CardType cardType;
    private double credit;
    private Account account;

    private static final long serialVersionUID = -8937706326684022681L;
}
