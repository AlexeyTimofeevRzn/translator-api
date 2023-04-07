package ru.timofeev.translator.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.timofeev.translator.config.YandexConfig;

import org.springframework.http.HttpHeaders;
import ru.timofeev.translator.data.Translation;
import ru.timofeev.translator.dto.TranslationResponseDTO;
import ru.timofeev.translator.utils.TextSpliterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YandexTranslationService {

    final YandexConfig yandexConfig;

    public YandexTranslationService(YandexConfig yandexConfig) {
        this.yandexConfig = yandexConfig;
    }

    public TranslationResponseDTO getTranslations(List<String> texts, String targetLanguageCode) {
        TranslationResponseDTO responseDTO = new TranslationResponseDTO();
        List<Translation> translations = new ArrayList<>();

        for (String text : texts) {
            translations
                    .add(this.getTranslationForSingleWord(text, targetLanguageCode));
        }

        responseDTO.setTranslations(translations);

        return responseDTO;

    }

    private Translation getTranslationForSingleWord(String text, String targetLanguageCode) {
        Map<String, String> jsonRequest = new HashMap<>();

        List<String> words = TextSpliterator.getSplitTextBySpaces(text);

        jsonRequest.put("folderId", yandexConfig.getFolderId());
        jsonRequest.put("texts", "[" + text + "]");
        jsonRequest.put("targetLanguageCode", targetLanguageCode);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonRequest, getHeaders());

        RestTemplate restTemplate = new RestTemplate();

        TranslationResponseDTO translations = restTemplate
                .postForObject(yandexConfig.getURL(), request, TranslationResponseDTO.class);

        return translations.getTranslations().get(0);
    }

    private HttpHeaders getHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization", "Bearer " + yandexConfig.getToken());

        return httpHeaders;
    }
}
