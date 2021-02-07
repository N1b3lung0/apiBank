package com.nextdigital.apibank.services.card;

import com.nextdigital.apibank.api.v1.account.mapper.AccountMapper;
import com.nextdigital.apibank.api.v1.account.model.AccountDTO;
import com.nextdigital.apibank.api.v1.card.mapper.CardMapper;
import com.nextdigital.apibank.api.v1.card.model.CardDTO;
import com.nextdigital.apibank.domain.account.Account;
import com.nextdigital.apibank.domain.card.Card;
import com.nextdigital.apibank.domain.card.CardType;
import com.nextdigital.apibank.repositories.account.AccountRepository;
import com.nextdigital.apibank.repositories.card.CardRepository;
import com.nextdigital.apibank.services.common.uuid.UUIDUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CardDTO> getAllCards() {
        return cardRepository.findAll().stream().map(cardMapper::toCardDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CardDTO getCardById(String id) throws Exception {
        return findCard(id);
    }

    @Override
    @Transactional
    public CardDTO activateCard(String id, String pin) throws Exception {
        CardDTO savedCardDTO = findCard(id);
        savedCardDTO.setActivated(true);
        savedCardDTO.setPin(pin);
        Card newCard = cardMapper.toCard(savedCardDTO);
        return saveAndReturnCardDTO(newCard);
    }

    @Override
    @Transactional
    public CardDTO updatePIN(String id, String pin) throws Exception {
        CardDTO savedCardDTO = findCard(id);
        if (isActivated(savedCardDTO)) {
            savedCardDTO.setPin(pin);
        }
        Card newCard = cardMapper.toCard(savedCardDTO);
        return saveAndReturnCardDTO(newCard);
    }

    @Override
    public Boolean withdrawCash(String id, double cash) throws Exception {
        CardDTO savedCardDTO = findCard(id);
        AccountDTO savedAccountDTO = savedCardDTO.getAccountDTO();
        if (savedCardDTO.getCardType().equals(CardType.CREDIT)) {
            if (savedAccountDTO.getBalance() + savedCardDTO.getCredit() < cash) {
                return false;
            } else {
                savedAccountDTO.setBalance(savedAccountDTO.getBalance() - cash);
                saveAndReturnAccountDTO(accountMapper.toAccount(savedAccountDTO));
                return true;
            }
        } else {
            if (savedAccountDTO.getBalance() < cash) {
                return false;
            } else {
                savedAccountDTO.setBalance(savedAccountDTO.getBalance() - cash);
                saveAndReturnAccountDTO(accountMapper.toAccount(savedAccountDTO));
                return true;
            }
        }
    }

    @Override
    public Boolean depositMoney(String id, double money) throws Exception {
        CardDTO savedCardDTO = findCard(id);
        AccountDTO savedAccountDTO = savedCardDTO.getAccountDTO();
        //if (savedAccountDTO.getBank().getId().equals())
        return null;
    }

    private CardDTO findCard(String id) throws Exception {
        return cardMapper.toCardDTO(cardRepository.findById(UUIDUtils.fromString(id))
                .orElseThrow(() -> new Exception("Card not found - " + id)));
    }

    private Boolean isActivated(CardDTO cardDTO) {
        return cardDTO.getActivated();
    }

    private CardDTO saveAndReturnCardDTO(Card card) {
        Card savedCard = cardRepository.save(card);
        log.debug("Service Card, creating/updating a Card " + savedCard);
        return cardMapper.toCardDTO(savedCard);
    }

    private AccountDTO saveAndReturnAccountDTO(Account account) {
        Account savedAccount = accountRepository.save(account);
        log.debug("Service Card, creating/updating an Account " + savedAccount);
        return accountMapper.toAccountDTO(savedAccount);
    }
}
