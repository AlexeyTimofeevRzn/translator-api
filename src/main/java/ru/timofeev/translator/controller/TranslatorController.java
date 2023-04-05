package ru.timofeev.translator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.timofeev.translator.data.TranslationResult;
import ru.timofeev.translator.dto.TranslationRequestDTO;
import ru.timofeev.translator.dto.TranslationResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/translator")
public class TranslatorController {

    @PostMapping("/translate")
    public ResponseEntity<TranslationResponseDTO> translateText(@RequestBody TranslationRequestDTO requestDTO) {


        return ResponseEntity.ok(new TranslationResponseDTO());
    }

    @GetMapping("/allTranslates")
    public ResponseEntity<List<TranslationResult>> getPreviousTranslations() {

        return ResponseEntity.ok(List.of(new TranslationResult()));
    }

}
