package ru.timofeev.translator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.timofeev.translator.constants.query.TranslationQueries;
import ru.timofeev.translator.dao.mapper.TranslationResultRowMapper;
import ru.timofeev.translator.data.TranslationResult;

import java.util.List;

@Component
public class TranslationResultDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TranslationResultDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(TranslationResult translationResult) {
        jdbcTemplate.update(TranslationQueries.SAVE_TRANSLATION,
                translationResult.getInputText(),
                translationResult.getResult(),
                translationResult.getParams(),
                translationResult.getIpAddress(),
                translationResult.getDate());
    }

    public List<TranslationResult> getAllTranslations() {
        return jdbcTemplate.query(TranslationQueries.FIND_TRANSLATIONS, new TranslationResultRowMapper());
    }
}
