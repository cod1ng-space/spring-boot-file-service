**Описание решения:**
  В решении использовались spring-boot и posgreSQL согласно техническому заданию. Также был использован lombok для уменьшения количества кода.

  В микросервисе доступны следующие API-методы:
1. GET без параметров. Возвращает список из всех существующих в данный момент файлов и их атрибутов. Данные возвращаются в порядке добавления! Пример запроса - http://localhost:8081/file-manager
2. GET с путевым параметром id, который возвращает объект по его id. Пример запроса -  http://localhost:8081/file-manager/123
3. GET запрос по адресу "http://localhost:8081/file-manager/pages", который осуществляет пагинацию и сортировку данных по дате создания. В запрос передаётся два параметра: offset - номер страницы(нумерация начинается с 0) и limit - количество объектов(файлов и их атрибутов) на одной странице. Имеются ограничения на их значения: offset >= 0, 1 <= limit <= 100. По умолчанию offset = 0, limit = 5. Пример запроса - http://localhost:8081/file-manager/pages?offset=1&limit=3
4. POST запрос по адресу "http://localhost:8081/file-manager", который добавляет данные и возвращает id добавленного элемента. Важен формат передачи даты создания - "ГГГГ-ММ-ДД ЧЧ:ММ:СС". Пример запроса:
<img width="1074" alt="image" src="https://github.com/user-attachments/assets/ceecde27-a877-42ff-b892-0c7dc9b32631">
5. DELETE запрос, который соответственно удаляет файл с его атрибутами по id. Пример запроса:
<img width="1072" alt="image" src="https://github.com/user-attachments/assets/64ae875b-d096-4a66-b59f-b0e89e2adae3">


**Инструкция по запуску:**
1. Создать базу данных PosgreSQL с помощью приложения (например pgAdmin) или же консоли. Настройки базы данных лежат в файле src/main/resources/application.properties (По умолчанию название - "file-manager-bd", порт - 5432, логин и пароль - "postgres")
2. Зайти в корневую папку .../spring-boot-file-service с помощью команды cd в командной строке. Написать в консоль команду "mvn install" и дождать конца сборки. После этого выполнить команду "mvn spring-boot:run". После сборки проекта для запуска достаточно команды "mvn spring-boot:run". Важно иметь версию maven не ниже 3.9.9 и java не ниже 22.
3. Проект доступен в браузере по ссылке "http://localhost:8081/file-manager". Для тестирования можно использовать Postman или другую аналогичную программу.


**Примеры запросов с использование Postman:**

1. <img width="1073" alt="image" src="https://github.com/user-attachments/assets/049c78b8-0e0f-4a6c-83ad-c2aebc7bd995">
2. <img width="1083" alt="image" src="https://github.com/user-attachments/assets/37b0f5fb-80cd-41a8-8ff3-3139e63e4b31">
3. <img width="1079" alt="image" src="https://github.com/user-attachments/assets/1cfaa4f6-7ece-4e39-b391-fc0f55a3844d">
4. <img width="1074" alt="image" src="https://github.com/user-attachments/assets/27b4adc1-2a00-43f9-9636-16427700958e">
5. <img width="1074" alt="image" src="https://github.com/user-attachments/assets/3c138569-4331-4d6f-b0e8-a7b2ca198183">
