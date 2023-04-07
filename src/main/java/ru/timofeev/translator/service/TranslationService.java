package ru.timofeev.translator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Text;
import ru.timofeev.translator.data.Translation;
import ru.timofeev.translator.dto.TranslationRequestDTO;
import ru.timofeev.translator.dto.TranslationResponseDTO;
import ru.timofeev.translator.utils.TextSpliterator;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslationService {

    YandexTranslationService yandexTranslationService;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TranslationService(JdbcTemplate jdbcTemplate, YandexTranslationService yandexTranslationService) {
        this.jdbcTemplate = jdbcTemplate;
        this.yandexTranslationService = yandexTranslationService;
    }

    public TranslationResponseDTO translate(TranslationRequestDTO translationRequestDTO) {
        return yandexTranslationService.getTranslation(translationRequestDTO);
    }

    public void save(TranslationResponseDTO translationResponseDTO, String ipAddress) {

    }

}
