package ru.timofeev.translator.data;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TranslationResult {

    int id;

    String inputText;

    String result;

    String params;

    String ipAddress;

    Date date;

}
