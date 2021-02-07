package com.nextdigital.apibank.services.card;

import com.nextdigital.apibank.api.v1.card.model.CardDTO;

import java.util.List;

public interface CardService {

    List<CardDTO> getAllCards();
    CardDTO getCardById(String id) throws Exception;
    CardDTO activateCard(String id, String pin) throws Exception;
    CardDTO updatePIN(String id, String pin) throws Exception;
    Boolean withdrawCash(String id, double cash) throws Exception;
    Boolean depositMoney(String id, double money) throws Exception;
}
