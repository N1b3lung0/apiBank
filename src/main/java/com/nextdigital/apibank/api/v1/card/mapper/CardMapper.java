package com.nextdigital.apibank.api.v1.card.mapper;

import com.nextdigital.apibank.api.v1.account.mapper.AccountMapper;
import com.nextdigital.apibank.api.v1.card.model.CardDTO;
import com.nextdigital.apibank.domain.card.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardMapper {

    private final AccountMapper accountMapper;

    public CardDTO toCardDTO(Card card) {
        return card == null ?
                null :
                new CardDTO(card.getId(), card.getPin(), card.getActivated(),
                        card.getCardType(), card.getCredit(), accountMapper.toAccountDTO(card.getAccount()));
    }

    public Card toCard(CardDTO cardDTO) throws Exception {
        return cardDTO == null ?
                null :
                new Card(cardDTO.getId(), cardDTO.getPin(), cardDTO.getActivated(),
                        cardDTO.getCardType(), cardDTO.getCredit(), accountMapper.toAccount(cardDTO.getAccountDTO()));
    }
}
