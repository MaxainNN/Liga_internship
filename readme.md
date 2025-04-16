![Логотип компании](/images/Liga_img.jpg)

# Проект "Тестирование веб-сервисов"

- [Описание](#описание)
- [Стэк](#технологии--используемые-в-данном-проекте)
- [Структура проекта](#описание-структуры-проекта)
- [Комментарии по стилю кода](#комментарии-по-стилю-кода)
- [Как скачать проект](#для-скачивания-проекта)
- [Требования для запуска](#для-запуска-проекта-необходимы)
- [Отчеты](#после-выполнения-тестов-будут-доступны-отчеты-)
- [Полезные ссылки](#полезные-ссылки)
- [Список литературы](#список-литературы)
- Дополнительные материалы
     - <span style="margin-right: 10px;"><img src="images/bug_icon.png" alt="Maven" width="30" height="30"></span>[Теория тестирования](descriptions/test_theory.md)
     - <span style="margin-right: 10px;"><img src="images/icons8-java-48.png" alt="Maven" width="30" height="30"></span>[Java](descriptions/java_tutorial.md) 
     - <span style="margin-right: 10px;"><img src="images/maven_icon_new.png" alt="Maven" width="30" height="30"></span>[Maven](descriptions/maven_tutorial.md)
     - <span style="margin-right: 10px;"><img src="images/git_icon.png" alt="Git_logo" width="30" height="30"></span>[Git](descriptions/git_tutorial.md)
     - <span style="margin-right: 10px;"><img src="images/xpath_icon.svg" alt="Xpath" width="40" height="30"></span>[Xpath](descriptions/xpath_tutorial.md)
     - <span style="margin-right: 10px;"><img src="images/testbng_icon.png" alt="TestNG" width="40" height="30"></span>[TestNG](descriptions/testng_tutorial.md)
     - <span style="margin-right: 10px;"><img src="images/selenium_icon.svg" alt="Selenium" width="30" height="30"></span>[Selenium](descriptions/selenium_tutorial.md)
     - <span style="margin-right: 10px;"><img src="images/idea_icon.png" alt="Idea" width="30" height="30"></span>[Idea](descriptions/idea_tutorial.md)
     - <span style="margin-right: 10px;"><img src="images/devtools_icon.png" alt="Devtools" width="30" height="30"></span>[Devtools](descriptions/devtools.md)
     - <span style="margin-right: 10px;"><img src="images/github_icon.png" alt="GH Actions" width="30" height="30"></span>[GitHub Actions](descriptions/github_actions.md)
     - <span style="margin-right: 10px;"><img src="images/docker_icon.svg" alt="Docker" width="30" height="30"></span>[Docker](descriptions/docker_tutorial.md)
     - <span style="margin-right: 10px;"><img src="images/allure_r.png" alt="Allure Report" width="30" height="30"></span>[Allure Report](descriptions/allure_tutorial.md)
     - <span style="margin-right: 10px;"><img src="images/jenkins_icon_n.svg" alt="Jenkins" width="30" height="30"></span>[Jenkins](descriptions/jenkins_tutorial.md)


# Описание:
Этот проект включает базовые технологии и паттерны, необходимые для разработки решения, предназначенного для тестирования веб-сервисов.
В качестве объектов для тестирования были выбраны следующие сервисы:
- <span style="margin-right: 5px;">[DemoQA](https://demoqa.com/)</span> <img src='images/demoqa_long_icon.jpg' alt='demoqa' width='70' height='30'>
- <span style="margin-right: 5px;">[SauceDemo](https://www.saucedemo.com/)</span> <img src='images/saucedemo_long_icon.svg' alt='saucedemo' width='70' height='30'>
- <span style="margin-right: 5px;">[Google](https://www.google.com/)</span>  <img src='images/google_title.png' alt='google' width='70' height='30'>
- <span style="margin-right: 5px;">[Habr](https://habr.com/ru/feed/)</span>  <img src='images/habr_icon.webp' alt='habr' width='30' height='30'>
- <span style="margin-right: 5px;">[Test Engineer](https://testengineer.ru/)</span>  <img src='images/test_ing_icon.png' alt='habr' width='30' height='30'>


# Технологии , используемые в данном проекте:
- Язык программирования <img src="images/icons8-java-48.png" alt="Maven" width="30" height="30"> `Java` 22 Версии
- Инструмент для сборки проекта <img src="images/maven_icon_new.png" alt="Maven" width="30" height="30"> `Apache Maven`
- Framework для тестирования пользовательских интерфейсов <img src="images/selenium_icon.svg" alt="Selenium" width="30" height="30"> `Selenium` Версии 4.10
- Библиотека для запуска тестов <img src="images/testbng_icon.png" alt="TestNG" width="40" height="30"> `TestNG` Версии 7.8
- Framework для создания отчетов <img src="images/extent_report_ico.jfif" alt="ExtentReport" width="30" height="30"> `ExtentReport` Версии 5.1
- Framework для создания отчетов `Allure Report` <img src="images/allure_r.png" alt="Allure" width="30" height="30"> Версии 2.24
- Инструмент для параллельного запуска тестов в Docker-контейнерах с браузерами `Selenoid` <img src="images/selenoid_icon.png" alt="Selenoid" width="30" height="30"> Версии 1.13.3
- CI/CD-сервер для автоматизации сборки, тестирования и развертывания `Jenkins` <img src="images/jenkins_icon_n.svg" alt="Jenkins" width="30" height="30"> Версии 2.492.2

# Описание структуры проекта:

```plaintext
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── browser # Классы конфигурации браузера
│   │   │   │   ├── Browser.java # Инициализация и конфигурация браузера
│   │   │   │   ├── Config.java # Дополнительная конфинурация браузера
│   │   │   │   └── Path.java # Пути директорий
│   │   │   ├── constant # Enum файлы для получения значений списка
│   │   │   │   ├── CategoryCards.java # Категории вкладок
│   │   │   │   ├── Item.java # Элементы из списка
│   │   │   │   └── LocatorsType.java # Типы локаторов    
│   │   │   ├── pages  # Классы с описанием страниц
│   │   │   │   ├── base # Базовый класс страницы
│   │   │   │   ├── demoqa # Классы для страниц DemoQA
│   │   │   │   │   ├── elements # Классы для страницы с "Элементами"
│   │   │   │   │   ├── main # Класс для основной страницы
│   │   │   │   │   ├── secondPage # Классы для основной страницы со списком категорий
│   │   │   │   │   └── widgets # Класс для страницы с "Виджетами"
│   │   │   │   ├── google # Классы для страницы "Google"
│   │   │   │   └── sauceDemo # Классы для страницы "SauceDemo"
│   │   │   └── utils # Вспомогательные классы
│   │   │       └── DataGenerator.java # Вспомогательный класс для генерации данных
│   │   └── resources # Ресурсы для проекта (Драйверы)
│   └── test
│       ├── java
│       │   ├── base # Базовый класс теста
│       │   │   └── BaseTest.java # Базовый класс для инициализации и завершения тестов
│       │   ├── UI  # Классы для тестирования UI (интерфейса веб-сервиса)
│       │   └── utils # Вспомогательные классы для тестов
│       │       ├── ChromeOnlyTransformer.java # Трансформер аннотаций
│       │       └── ExtentTestNGListener.java  # Листенер для обработки событий тестов
│       └── resources  # Ресурсы для тестов
│           ├── downloadFiles # Загруженные файлы после тестов        
│           ├── testFiles # Тестовые файлы для загрузки
│           ├── googleProfile # Кэш с данными профиля Google 
│           └── testng.xml # Конфигурация TestNG
└── run_tests.bat # Скрипт для запуска тестов и просмотра отчета (для Windows)
```


# Комментарии по стилю кода:
- Проект написан в соответствии с паттерном проектирования `Page Object Model`
- Проект написан в соответстии с практиками и рекомендациями `Code Policy` принятыми в компании для `Java`
- Не учитывается использование `WebDriverManager`, выбора типа операционной системы.
- Не используется логирование с помошью библиотек `sl4j` и `log4j2`
- Тесты выполняются последовательно в одном потоке , для настройки многопоточности использовать `testng.xml`
- В качестве браузера по умолчанию выбран - <img src="images/chrome_icon.png" alt="Chrome" width="25" height="25"> [Chrome](https://googlechromelabs.github.io/chrome-for-testing/) версии 134.0.6998.90 (актуальной на момент создания проекта). Для запуска возможно потребуется актуализация.
- Также есть возможность запуска тестов в <img src="images/firefox_icon.png" alt="Firefox" width="25" height="25"> [Firefox](https://github.com/mozilla/geckodriver/releases) (версии 136.0.2) и <img src="images/egde_icon.png" alt="Edge" width="25" height="25"> [Edge](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver?form=MA13LH) (версии 133.0.3065.92) браузерах. Для настройки использовать класс `Config`
- Использованы драйверы для OS - <img src="images/windows_icon.png" alt="Windows" width="25" height="25"> `Windows`. Для тестирования на <img src="images/linux_icon.png" alt="Linux" width="25" height="25"> `Linux` требуется скачать соответствующий драйвер.
- Используется `CI pipeline` для `GitHub Actions` в качестве примера

# Для скачивания проекта:
1. Нажать на зеленую кнопку "`Code`"
2. Скопировать строчку для выбора скачивания проекта по `HTTPS`
3. В IDE Выбрать "`New Project`" -> "`Project from Version Control`"
4. В "`Url`" вставить скопированное значение
5. Нажать "`Clone`"

# Для запуска проекта необходимы:
- `Java` <img src="images/icons8-java-48.png" alt="Java_logo" width="30" height="30"> 22 версии и выше
- `Maven` <img src="images/icons8-apache-a-free-and-open-source-cross-platform-web-server-software-48.png" alt="Maven_logo" width="30" height="30"> версии 3.9.8 и выше
# Также рекомендуется использовать:
- `Git` <img src="images/git_icon.png" alt="Git_logo" width="30" height="30"> версии 2.45 и выше
- `IntellIJ Idea` <img src="images/idea_icon.png" alt="Idea_logo" width="30" height="30"> версии 2023.3.7 `Community edition` и выше

Проверка в консоли:

<img src="images/java_mvn_check.png" alt="Пример вывода в консоли" width="600" height="300">

Для запуска всех тестов использовать комманду:

```bash
mvn clean test
```

## После выполнения тестов будут доступны отчеты :

- `target/surefire-reports/index.html` - `Surefire` отчет
- `target/TestsReport.html` - `ExtentReport` отчет

## После выполения команд :

```bash
mvn site
```

```bash
mvn surefire-report:report-only
```

## Будет доступен отчет:

- `target/site/surefire-report.html` - `Surefire site` отчет

## После выполнения команды :

```bash
mvn allure:report
```

## Будет доступен отчет:

- `target/site/allure-report/index.html` - `Allure` отчет

## Пример отчета:

### Общие сведения:

<img src="images/intern_pr_general_r.png" alt="google_screen" width="600" height="300">

### Тесты , прошли успешно:

<img src="images/intern_pr_general_all.png" alt="google_screen" width="600" height="300">

### Скриншот после Google теста:

<img src="images/intern_pr_google_test_1.png" alt="google_screen" width="700" height="300">

### Скриншот после DemoQA теста:

<img src="images/intern_pr_demoqa_r.png" alt="google_screen" width="600" height="300">

### Скриншот после SauceDemo теста:

<img src="images/intern_pr_sauce_sc.png" alt="google_screen" width="600" height="300">

# Полезные ссылки:
- https://demoqa.com/ - сайт для тренировки написания `UI` тестов с различными формами (Используется в проекте)
- https://www.saucedemo.com/ - сайт для тренировки `UI` тестов в виде магазина (Используется в проекте)
- https://googlechromelabs.github.io/chrome-for-testing/ - страница для скачивания драйверов для Chrome
- https://github.com/mozilla/geckodriver/releases- страница для скачивания `Geckodriver` (Firefox)
- https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver?form=MA13LH - страница для скачивания `Edge driver`
- https://mvnrepository.com/ - Репозиторий с зависимостями
- https://maven.apache.org/download.cgi - Загрузка `Maven`
- https://www.oracle.com/java/technologies/downloads/ - Загрузка `JDK`

# Список литературы:
- Фулстэк тестирование (Гаятри Мохан) главы 1-3
- Selenium Testing Tools Cookbook Second Edition (Unmesh Gundecha)
- ISTQB Certified Tester - Foundation Level Syllabus v4.0

### 

|                                                                                                                                                                                           Автор                                                                                                                                                                                            |                                                                                                                                                                                              Компания                                                                                                                                                                                              |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                                                                                                                                                                        Калугин М.С.                                                                                                                                                                                        |                                                                                                                                                                                      Лига Цифровой Экономики                                                                                                                                                                                       |
| <a href="https://github.com/MaxainNN" target="_blank"><img src="images/github_icon.png" alt="Github" width="30" height="30"></a> <a href="mailto:imenolys23@gmail.com"><img src="images/google_mail_icon.png" alt="Написать письмо" width="40" height="30"></a> <a href="https://t.me/maxain" target="_blank"><img src="images/tg_n_icon.webp" alt="Telegram" width="30" height="30"></a>  | <a href="https://www.digitalleague.ru/" target="_blank"><img src="images/Liga_img_1.webp" alt="Liga_site" width="30" height="30"></a> <a href="https://t.me/digitalleague" target="_blank"><img src="images/tg_n_icon.webp" alt="Liga_tg" width="30" height="30"></a> <a href="https://t.me/digitalleague" target="_blank"><img src="images/vk_icon.png" alt="Liga_vk" width="30" height="30"></a> |


