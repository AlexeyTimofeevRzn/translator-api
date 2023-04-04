package ru.timofeev.translator.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.timofeev.translator.data.Translation;

import java.util.List;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TranslationResponseDTO {
    List<Translation> translations;
}
