Описание решения:


Инструкция по запуску:
1. Создать базу данных PosgreSQL с помощью приложения (например pgAdmin) или же консоли. Настройки базы данных лежат в файле src/main/resources/application.properties (По умолчанию название - "file-manager-bd", порт - 5432, логин и пароль - "postgres")
2. Зайти в корневую папку .../spring-boot-file-service с помощью команды cd в командной строке. Написать в консоль команду "mvn spring-boot:run". Важно иметь версию maven не ниже 3.9.9!
3. Проект доступен в браузере по ссылке "http://localhost:8080/file-manager". Для тестирования можно использовать Postman или другую аналогичную программу.

В микросервисе доступны следующие API-методы:
1.

Примеры тестовых запросов:
