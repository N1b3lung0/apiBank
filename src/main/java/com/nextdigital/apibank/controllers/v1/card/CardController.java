package com.nextdigital.apibank.controllers.v1.card;

import com.nextdigital.apibank.api.v1.card.model.CardDTO;
import com.nextdigital.apibank.services.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cards")
public class CardController {

    private final CardService cardService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<CardDTO>> getAllCars() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping(value = { "/{id}"})
    public ResponseEntity<CardDTO> getOneCard(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @PostMapping(value = { "/{id}"})
    public ResponseEntity<CardDTO> activateCard(@PathVariable String id, @RequestParam(name = "pin") String pin) throws Exception {
        return ResponseEntity.ok(cardService.activateCard(id, pin));
    }
}
