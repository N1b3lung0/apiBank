package com.nextdigital.apibank.api.v1.account.mapper;

import com.nextdigital.apibank.api.v1.account.model.AccountDTO;
import com.nextdigital.apibank.domain.account.Account;
import com.nextdigital.apibank.repositories.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class AccountMapper {

    private final AccountRepository accountRepository;

    public AccountDTO toAccountDTO(Account account) {
        return account == null ?
                null :
                new AccountDTO(account.getId(), account.getBalance());
    }

    public Account toAccount(AccountDTO accountDTO) throws Exception {
        Account account = accountRepository.findById(accountDTO.getId())
                .orElseThrow(() -> new Exception("Account not found - " + accountDTO.getId()));
        return new Account(accountDTO.getId(), accountDTO.getBalance(), account.getIban(), account.getAccountNumber(),
                account.getCard(), account.getBank(), account.getCustomer(), account.getOperations());
    }
}
