## Проект по результатам стажировки в компании "Лига цифровой экономики" в рамках курса по автоматизации тестирования

![Логотип компании](/images/Liga_img.jpg)

# Описание:
Этот проект включает базовые технологии и паттерны, необходимые для разработки решения, предназначенного для тестирования веб-сервисов.


# Технологии , используемые в данном проекте:
- Язык программирования ![Java](/images/icons8-java-48.png) `Java` 22 Версии
- Инструмент для сборки проекта ![Maven](/images/icons8-apache-a-free-and-open-source-cross-platform-web-server-software-48.png) `Apache Maven`
- Framework для тестирования пользовательских интерфейсов ![Selenium](/images/icons8-selenium-48.png) `Selenium` Версии 4.10
- Библиотека для запуска тестов ![TestNG](/images/testNG_Icon.webp) `TestNG` Версии 7.8
- Framework для создания отчетов <img src="images/extent_report_ico.jfif" alt="ExtentReport" width="48" height="48"> `ExtentReport` Версии 5.1


# Описание стуктуры проекта:

- `src/main/java/browser` - Классы конфигурации браузера
- `src/main/java/constant` - Enum файлы для получения значений списка
- `src/main/java/pages` - Классы с описанием страниц
- `src/main/java/utils` - Вспомогательные классы
- `src/main/resources` - Ресурсы для проекта (расположение драйвера)
- `src/test/java/base` - Базовый класс теста
- `src/test/java/UI` - Классы для тесирования UI (интерфейса веб-сервиса)
- `src/test/java/utils` - Вспомогательные классы для тестов (листенер)
- `src/test/resources` - Ресурсы для тестов


# Комментарии по стилю кода:
- Проект написан в соответствии с паттерном проектирования `PageObject`
- Проект написан в соответстии с практиками и рекомендациями `Code Policy` принятыми в компании для `Java`
- В качестве локаторов использованы переменные типа `String` и `By`
- Описание класса `Browser` представлено одним методом createDriver, не учитывается использование `WebDriverManager`, выбора типа операционной системы.
- Не используется логирование
- Тесты выполняются последовательно в одном потоке , для настройки многопоточности использовать `testng.xml`
- В качестве браузера по умолчанию выбран - <img src="images/chrome_icon.png" alt="Chrome" width="25" height="25"> Chrome версии 133.0.6943.141 (актуальной на момент создания проекта). Для запуска возможно потребуется актуализация.
- Также есть возможность запуска тестов в <img src="images/firefox_icon.png" alt="Firefox" width="25" height="25"> Firefox (версии 135.0.1) и <img src="images/egde_icon.png" alt="Edge" width="25" height="25"> Edge (версии 133.0.3065.92) браузерах. Для настройки использовать класс `Config`
- Использованы драйверы для OS - <img src="images/windows_icon.png" alt="Windows" width="25" height="25"> `Windows`. Для тестирования на <img src="images/linux_icon.png" alt="Linux" width="25" height="25"> `Linux` требуется скачать соответствующий драйвер.
- Используется CI pipeline в качестве примера

# Для скачивания проекта:
1. Нажать на зеленую кнопку "`Code`"
2. Скопировать строчку для выбора скачивания проекта по `HTTPS`
3. В IDE Выбрать "`New Project`" -> "`Project from Version Control`"
4. В "`Url`" вставить скопированное значение
5. Нажать "`Clone`"

# Для запуска проекта необходимы:
1. `Java` <img src="images/icons8-java-48.png" alt="Java_logo" width="30" height="30"> 22 версии и выше
2. `Maven` <img src="images/icons8-apache-a-free-and-open-source-cross-platform-web-server-software-48.png" alt="Maven_logo" width="30" height="30"> версии 3.9.8 и выше
# Также рекомендуется использовать:
3. `Git` <img src="images/git_icon.png" alt="Git_logo" width="30" height="30"> версии 2.45 и выше
4. `IntellIJ Idea` <img src="images/idea_icon.png" alt="Idea_logo" width="30" height="30"> версии 2023.3.7 `Community edition` и выше

Проверка в консоли:

<img src="images/java_mvn_check.png" alt="Пример вывода в консоли" width="500" height="300">

Для запуска всех тестов использовать комманду:
``
mvn clean test
``

После выполнения тестов будут доступны отчеты:

`target/surefire-reports/index.html` - дефолтный отчет

`target/TestsReport.html` - настраиваемый более современный отчет

# Пример отчета:
Общие сведения:

<img src="images/Report_example.png" alt="Общие сведения в отчете" width="500" height="300">

Пример теста , который прошел успешно:

<img src="images/Report_example_positive.png" alt="Тест прошел успешно" width="500" height="300">

Пример теста , который упал:

<img src="images/Report_example_negative.png" alt="Тест упал" width="500" height="300">

# Полезные ссылки:
- https://demoqa.com/ - сайт для тренировки написания UI тестов (Используется в проекте)
- https://testengineer.ru/selenium-webdriver-java-cheat-sheet/ - Примеры использования методов Selenium
- http://85.192.34.140:8081/ - Тренажер для UI тестов (аналог DemoQA)
- https://googlechromelabs.github.io/chrome-for-testing/ - страница для скачивания драйверов для Chrome
- https://geckodriver.org/ - страница для скачивания Geckodriver (Firefox)
- https://mvnrepository.com/ - Репозиторий с зависимостями
- https://maven.apache.org/download.cgi - Загрузка Maven
- https://www.oracle.com/java/technologies/downloads/ - Загрузка jdk
- https://habr.com/ru/companies/intec_balance/articles/884482/ - статья про использование Devtools

# Список литературы:
- Фулстэк тестирование (Гаятри Мохан) главы 1-3
- Selenium Testing Tools Cookbook Second Edition (Unmesh Gundecha)
- ISTQB Certified Tester - Foundation Level Syllabus v4.0

# Что изучить еще:
- `Devtools` , умение пользоваться консолью в браузере.
- Подход чтения настроек из файлов типа `.env` и `.properties`
- Запуск тестов с использованием `Proxy`
- `RestAssured` <img src="images/restassured_icon.png" alt="Restassured" width="25" height="25"> - инструмент для тестирования API на java
- `WebDriverManager` <img src="images/WebDriverM_Icon.png" alt="WebDriverManager" width="25" height="25"> - библиотека для загрузки и инициализации драйвера актуальной версии
- `Allure Report` <img src="images/allure_icon.png" alt="AllureReport" width="25" height="25"> - инструмент для генерации отчета по результатам тестов
- `Gradle` <img src="images/gradle_icon.png" alt="Gradle" width="25" height="25"> - альтернативный инструмент для сборки проекта
- `JUnit` <img src="images/junit_icon.png" alt="JUnit" width="25" height="25"> - инструмент для запуска тестов. Аналог TestNG.
- `Jenkins` <img src="images/jenkins_icon.png" alt="Jenkins" width="25" height="25"> - инструмент для настройки CI/CD процессов
- `Postman` <img src="images/postman_icon.svg" alt="Postman" width="25" height="25"> - инструмент для тестирования API (HTTP клиент)
- `Apache Kafka` <img src="images/kafka_icon.svg" alt="Kafka" width="25" height="25"> - распределенный брокер сообщений
- `ELK (Elasticsearch, Kibana, Logstash)` <img src="images/elastic_icon.png" alt="Elastic" width="25" height="25"> <img src="images/logstash_icon.png" alt="Logstash" width="25" height="25"> <img src="images/kibana_icon.png" alt="Kibana" width="25" height="25"> - сервис для хранения и поиска данных (логов)
- `Charles` <img src="images/charles_icon.jfif" alt="Charles" width="25" height="25"> - снифер трафика
- `Docker` <img src="images/docker_icon.png" alt="Docker" width="25" height="25"> - программа для контейнеризации, развертывания приложений
- `Apache Jmeter` <img src="images/jmeter_icon.png" alt="Jmeter" width="25" height="25"> - инструмент для нагрузочного тестирования
- `Grafana` <img src="images/grafana_icon.jfif" alt="Grafana" width="25" height="25"> - сервис для просмотра метрик

<img src="images/Liga_img_1.webp" alt="Логотип компании" width="300" height="300">

**Автор:** [Калугин М.С.](https://github.com/MaxainNN)  
**Компания:** [Лига Цифровой Экономики](https://www.digitalleague.ru/)
