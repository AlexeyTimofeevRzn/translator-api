package ru.timofeev.translator.constants.query;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class TranslationQueries {

    final String FIND_TRANSLATIONS = "select * from translation_result";

    final String SAVE_TRANSLATION
            = "insert into " +
            "translation_result(input_text, result, params, ip_address, request_data) values (?, ?, ?, ?, ?)";

}
