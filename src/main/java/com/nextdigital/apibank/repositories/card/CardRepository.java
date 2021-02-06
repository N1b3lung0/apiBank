package com.nextdigital.apibank.repositories.card;

import com.nextdigital.apibank.domain.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

}
