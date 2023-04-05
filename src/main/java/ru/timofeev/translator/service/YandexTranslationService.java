package ru.timofeev.translator.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.timofeev.translator.config.YandexConfig;

import org.springframework.http.HttpHeaders;
import ru.timofeev.translator.dto.TranslationResponseDTO;
import ru.timofeev.translator.utils.TextSpliterator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YandexTranslationService {

    final YandexConfig yandexConfig;

    public YandexTranslationService(YandexConfig yandexConfig) {
        this.yandexConfig = yandexConfig;
    }

    private void getResponse(String text) {
        Map<String, String> jsonRequest = new HashMap<>();

        List<String> list = List.of(TextSpliterator.getSplitTextBySpaces(text));

        jsonRequest.put("folderId", yandexConfig.getFolderId());
        jsonRequest.put("text", list.toString());
        jsonRequest.put("targetLanguageCode", "en");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonRequest, getHeaders());

        RestTemplate restTemplate = new RestTemplate();

        TranslationResponseDTO translations = restTemplate
                .postForObject(yandexConfig.getURL(), request, TranslationResponseDTO.class);
    }

    private HttpHeaders getHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();

        String url = "https://translate.api.cloud.yandex.net/translate/v2/translate";

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization", "Bearer " + this.yandexConfig.getToken());

        return httpHeaders;
    }
}
