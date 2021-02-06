package com.nextdigital.apibank.services.card;

import com.nextdigital.apibank.api.v1.card.mapper.CardMapper;
import com.nextdigital.apibank.api.v1.card.model.CardDTO;
import com.nextdigital.apibank.domain.card.Card;
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
        return findCard(id);
    }

    @Override
    @Transactional
    public CardDTO activateCard(String id, String pin) throws Exception {
        CardDTO savedCardDTO = findCard(id);
        savedCardDTO.setActivated(true);
        savedCardDTO.setPin(pin);
        Card newCard = cardMapper.toCard(savedCardDTO);
        return saveAndReturnDTO(newCard);
    }

    @Override
    @Transactional
    public CardDTO updatePIN(String id, String pin) throws Exception {
        CardDTO savedCardDTO = findCard(id);
        if (isActivated(savedCardDTO)) {
            savedCardDTO.setPin(pin);
        }
        return savedCardDTO;
    }

    private CardDTO findCard(String id) throws Exception {
        return cardMapper.toCardDTO(cardRepository.findById(UUIDUtils.fromString(id))
                .orElseThrow(() -> new Exception("Card not found - " + id)));
    }

    private Boolean isActivated(CardDTO cardDTO) {
        return cardDTO.getActivated();
    }

    private CardDTO saveAndReturnDTO(Card card) {
        Card savedCard = cardRepository.save(card);
        log.debug("Service Card, creating/updating a Card " + savedCard);
        return cardMapper.toCardDTO(savedCard);
    }
}
