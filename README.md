# Translator
API для перевода текста.
Использует API Яндекс Переводчика.


## Запуск приложения

### Если у вас есть Docker
1. Клонируете проект
2. В файле docker-compose.yml нужно установить свои YANDEX_TOKEN и YANDEX_FOLDERID для доступа к API Яндекс Переводчика

![image](https://user-images.githubusercontent.com/109170524/230736621-ba0e322f-33b7-4cae-b498-5a55d1afda29.png)

3. В терминале написать следующие команды:
```
mvn clean install
docker compose build
docker-compose up
```
4. Все готово, пользуйтесь приложением)

### Если у вас нет Docker
1. Клонируете проект
2. В файле application.yml нужно установить свои yandex.token и yandex.folderId для доступа к API Яндекс Переводчика

![image](https://user-images.githubusercontent.com/109170524/230738905-87b60b12-e2ef-4547-a3a2-dc965ea27c9a.png)

3. Запускаете приложение через main в классе TranslatorApiApplication

![image](https://user-images.githubusercontent.com/109170524/230738949-2b6b84ed-bd56-49a6-bef0-d1657e875d6f.png)

4. Все готово, пользуйтесь приложением)

## Как использовать?

Для перевода слов используйте POST-запрос по адресу: **localhost:8080/translator/translate**
На вход подается JSON в следующем виде:

![image](https://user-images.githubusercontent.com/109170524/230739224-a6659a71-2f2e-484e-b5e8-51164b0b1ea3.png)

text - слова для перевода.
targetLanguageCode - язык, в который требуется переводить слова из text.

В качестве ответа приходит JSON в следующем виде:

![image](https://user-images.githubusercontent.com/109170524/230739259-5cb1bbc3-7bf4-4ed9-9ebe-322597c244dc.png)

Если необходимо просмотреть историю переводов в текущем сеансе, то используйте GET-запрос по адресу: **localhost:8080/translator/allTranslates**
В качестве ответа приходит следующий JSON:

![image](https://user-images.githubusercontent.com/109170524/230739340-01d66d1c-baaf-40b0-9817-54d0cb5994b2.png)

Telegram для связи:
@AlekseyBack
