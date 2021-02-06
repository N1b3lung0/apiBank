package com.nextdigital.apibank.api.v1.account.model;

import com.nextdigital.apibank.domain.card.Card;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Component
public class AccountDTO implements Serializable {

    private UUID id;
    private double balance;
    private String iban;
    private String accountNumber;

    private static final long serialVersionUID = -6456423791398288060L;
}
