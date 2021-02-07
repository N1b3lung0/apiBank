package com.nextdigital.apibank.api.v1.card.model;

import com.nextdigital.apibank.api.v1.account.model.AccountDTO;
import com.nextdigital.apibank.domain.card.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO implements Serializable {

    private UUID id;
    private String pin;
    private Boolean activated;
    private CardType cardType;
    private double credit;
    private AccountDTO accountDTO;

    private static final long serialVersionUID = -8937706326684022681L;
}
