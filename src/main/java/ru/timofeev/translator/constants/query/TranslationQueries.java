package ru.timofeev.translator.constants.query;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
public class TranslationQueries {

    public static final String FIND_TRANSLATIONS = "select * from translation_result";

    public static final String SAVE_TRANSLATION
            = "insert into " +
            "translation_result(input_text, result, params, ip_address, request_data) values (?, ?, ?, ?, ?)";

}
