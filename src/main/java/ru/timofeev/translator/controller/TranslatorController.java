package ru.timofeev.translator.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.timofeev.translator.data.TranslationResult;
import ru.timofeev.translator.dto.TranslationRequestDTO;
import ru.timofeev.translator.dto.TranslationResponseDTO;
import ru.timofeev.translator.service.TranslationService;
import ru.timofeev.translator.service.YandexTranslationService;
import ru.timofeev.translator.utils.TextSpliterator;
import ru.timofeev.translator.utils.validator.InputTextValidator;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/translator")
public class TranslatorController {

    private final TranslationService translationService;

    private final YandexTranslationService yandexTranslationService;

    @Autowired
    public TranslatorController(TranslationService translationService, YandexTranslationService yandexTranslationService) {
        this.translationService = translationService;
        this.yandexTranslationService = yandexTranslationService;
    }

    @PostMapping("/translate")
    public ResponseEntity<TranslationResponseDTO> translateText
            (@RequestBody TranslationRequestDTO requestDTO, HttpServletRequest request) {

        InputTextValidator.validateInputText(requestDTO.getText());

        List<String> texts = TextSpliterator.getSplitTextBySpacesAndCommas(requestDTO.getText());

        String ipAddress = request.getRemoteAddr();
        Date date = new Date(System.currentTimeMillis());
        String targetLanguageCode = requestDTO.getTargetLanguageCode();

        TranslationResponseDTO result = yandexTranslationService
                .getTranslations(texts, requestDTO.getTargetLanguageCode());

        translationService.save(texts, result, date, ipAddress, targetLanguageCode);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/allTranslates")
    public ResponseEntity<List<TranslationResult>> getPreviousTranslations() {

        List<TranslationResult> translationResults = translationService.getAllTranslates();

        return ResponseEntity.ok(translationResults);
    }

}
