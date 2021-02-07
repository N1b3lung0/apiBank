package com.nextdigital.apibank.api.v1.atm.model;

import com.nextdigital.apibank.api.v1.bank.model.BankDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtmDTO implements Serializable {

    private UUID id;
    private BankDTO bankDTO;

    private static final long serialVersionUID = 7899133544423652551L;
}
