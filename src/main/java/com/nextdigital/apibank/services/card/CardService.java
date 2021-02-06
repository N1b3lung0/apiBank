package com.nextdigital.apibank.services.card;

import com.nextdigital.apibank.api.v1.card.model.CardDTO;

import java.util.List;

public interface CardService {

    List<CardDTO> getAllCards();
    CardDTO getCardById(String id) throws Exception;
    CardDTO activateCard(String id, String pin) throws Exception;
    CardDTO updatePIN(CardDTO cardDTO);
}
