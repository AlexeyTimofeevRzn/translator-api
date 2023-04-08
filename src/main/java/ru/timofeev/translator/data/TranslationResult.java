package ru.timofeev.translator.data;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TranslationResult {

    int id;

    String inputText;

    String result;

    String params;

    String ipAddress;

    LocalDateTime date;

}
