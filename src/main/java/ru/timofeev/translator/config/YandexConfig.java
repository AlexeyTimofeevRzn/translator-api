package ru.timofeev.translator.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class YandexConfig {

    @Value("${yandex.token}")
    String token;

    @Value("${yandex.folderId}")
    String folderId;

    final String URL = "https://translate.api.cloud.yandex.net/translate/v2/translate";

}
