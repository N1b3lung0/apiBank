package com.nextdigital.apibank.api.v1.bank.model;

import com.nextdigital.apibank.api.v1.account.model.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDTO implements Serializable {

    private UUID id;
    private List<AccountDTO> accountDTOS;

    private static final long serialVersionUID = 7366186152311422929L;
}
