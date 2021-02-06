package com.nextdigital.apibank.api.v1.card.mapper;

import com.nextdigital.apibank.api.v1.card.model.CardDTO;
import com.nextdigital.apibank.domain.card.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardDTO toCardDTO(Card card) {
        return card == null ?
                null :
                new CardDTO(card.getId(), card.getPin(), card.getActivated(),
                        card.getCardType(), card.getCredit(), card.getAccount());
    }

    public Card toCard(CardDTO cardDTO) {
        return cardDTO == null ?
                null :
                new Card(cardDTO.getId(), cardDTO.getPin(), cardDTO.getActivated(),
                        cardDTO.getCardType(), cardDTO.getCredit(), cardDTO.getAccount());
    }
}
