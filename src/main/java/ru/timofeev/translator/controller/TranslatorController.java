package ru.timofeev.translator.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.timofeev.translator.data.TranslationResult;
import ru.timofeev.translator.dto.TranslationRequestDTO;
import ru.timofeev.translator.dto.TranslationResponseDTO;
import ru.timofeev.translator.service.TranslationService;

import java.util.List;

@RestController
@RequestMapping("/translator")
public class TranslatorController {

    private final TranslationService translationService;

    @Autowired
    public TranslatorController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @PostMapping("/translate")
    public ResponseEntity<TranslationResponseDTO> translateText
            (@RequestBody TranslationRequestDTO requestDTO, HttpServletRequest request) {

        TranslationResponseDTO result = translationService.translate(requestDTO);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/allTranslates")
    public ResponseEntity<List<TranslationResult>> getPreviousTranslations() {

        return ResponseEntity.ok(List.of(new TranslationResult()));
    }

}
