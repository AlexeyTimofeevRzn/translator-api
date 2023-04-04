package ru.timofeev.translator.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TranslationRequestDTO {

    String targetLanguageCode;

    List<String> texts;

    String folderId;

}
