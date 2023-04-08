package ru.timofeev.translator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.timofeev.translator.dao.TranslationResultDAO;
import ru.timofeev.translator.data.Translation;
import ru.timofeev.translator.data.TranslationResult;
import ru.timofeev.translator.dto.TranslationResponseDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Service
public class TranslationService {

    private final TranslationResultDAO translationResultDAO;

    @Autowired
    public TranslationService(TranslationResultDAO translationResultDAO) {
        this.translationResultDAO = translationResultDAO;
    }

    public void save
            (List<String> requests, TranslationResponseDTO translationResponseDTO, LocalDateTime ldt, String ipAddress, String targetLanguageCode) {

        List<Translation> translations = translationResponseDTO.getTranslations();

        for (int i = 0; i < requests.size(); i++) {

            String params = translations.get(i).getDetectedLanguageCode() + "-" + targetLanguageCode;

            TranslationResult translationResult = TranslationResult.builder()
                    .inputText(requests.get(i))
                    .result(translations.get(i).getText())
                    .date(ldt)
                    .ipAddress(ipAddress)
                    .params(params)
                    .build();

            translationResultDAO.save(translationResult);
        }

    }

    public List<TranslationResult> getAllTranslates() {
        return translationResultDAO.getAllTranslations();
    }

}
