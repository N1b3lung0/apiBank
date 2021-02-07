package com.nextdigital.apibank.api.v1.account.model;

import com.nextdigital.apibank.domain.bank.Bank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO implements Serializable {

    private UUID id;
    private double balance;
    private Bank bank;

    private static final long serialVersionUID = -6456423791398288060L;
}
