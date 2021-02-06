package com.nextdigital.apibank.services.card;

import com.nextdigital.apibank.api.v1.card.mapper.CardMapper;
import com.nextdigital.apibank.api.v1.card.model.CardDTO;
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
    private final CardRepository cardRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CardDTO> getAllCards() {
        return cardRepository.findAll().stream().map(cardMapper::toCardDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CardDTO getCardById(String id) throws Exception {
        return cardMapper.toCardDTO(cardRepository.findById(UUIDUtils.fromString(id))
                .orElseThrow(() -> new Exception("Card not found - " + id)));
    }

    @Override
    @Transactional
    public CardDTO activateCard(String id, String pin) throws Exception {
        CardDTO savedCardDTO = cardMapper.toCardDTO(cardRepository.findById(UUIDUtils.fromString(id))
                .orElseThrow(() -> new Exception("Card not found - " + id)));
        savedCardDTO.setActivated(true);
        savedCardDTO.setPin(pin);
        return savedCardDTO;
    }

    @Override
    @Transactional
    public CardDTO updatePIN(CardDTO cardDTO) {
        return null;
    }
}
