# Translator
API для перевода текста.
Использует API Яндекс Переводчика.


## Запуск приложения

### Если у вас есть Docker
1. Клонируете проект
2. В файле docker-compose.yml нужно установить свои token и folderId для доступа к API Яндекс переводчика
![image](https://user-images.githubusercontent.com/109170524/230736621-ba0e322f-33b7-4cae-b498-5a55d1afda29.png)
3. В терминале написать следующие команды:
```
mvn clean install
docker compose build
docker-compose up
```
