# IDEA

В качестве `IDE` (Integrated development environment)
используется `IntelliJ Idea Community Edition`. Для комфортной работы
рекомендуется ознакомиться с интерфейсом и различными полезными
возможностями.

### Скачивание и установка

<img src="../images/idea_main_page.png" alt="IDEA page" width="900" height="400">

- Перейти на сайт - [Официальная страница с IDEA](https://www.jetbrains.com/idea/)
- Нажать `Donwload`
- Пролистать чуть вниз
- Нажать `Download` у `IntelliJ IDEA Community Edition`
- Установить

### Интерфейс среды

- `Главное меню` - расположено в верхней части окна, содержит все основные команды
- `Панель инструментов` - под главным меню, быстрый доступ к часто используемым функциям
- `Навигационная панель` - показывает путь к текущему файлу
- `Проектное окно` - отображает структуру проекта
- `Редактор кода` - центральная часть, где происходит основная работа
- `Панель инструментов редактора` - справа от редактора, содержит кнопки для навигации
- `Панель вкладок` - показывает открытые файлы
- `Статус бар` - внизу окна, отображает информацию о проекте и IDE
- `Боковые панели` (Run, Debug, Terminal и др.) - открываются при необходимости

<img src="../images/idea_interface.png" width="950" height="500">

### Запуск тестов

После установки аннотации `@Test` у метода -
появиться возможность запуска тестовых методов отдельно, 
всех методов в классе.

<img src="../images/idea_tests.png" width="357" height="295">

### Дебаг

#### Установка точек останова (breakpoints):
- Кликните на левое поле редактора рядом с нужной строкой
- Нажмите на значок жука вместо зеленой стрелки (
Убедитесь , что выбран нужный класс)

<img src="../images/idea_debug.png" width="500" height="300">

#### Основные действия при отладке

- `Step Over` - выполнить текущую строку
- `Step Into` - войти в метод
- `Step Out`- выйти из метода
- `Resume Program` - продолжить выполнение до следующей 
точки останова

<img src="../images/idea_debug_5.png" width="212" height="74">

Пример с `Step Into`:

<img src="../images/idea_debug_1.png" width="600" height="400">

<img src="../images/idea_debug_2.png" width="800" height="200">

<img src="../images/idea_debug_3.png" width="700" height="400">

Переменные в `Threads & Variables`:

<img src="../images/idea_debug_4.png" width="700" height="350">

Значение в переменной в момент выполнения программы :

<img src="../images/idea_debug_6.png" width="650" height="360">

### Терминал

Пример вывода в терминал (логи теста):

<img src="../images/idea_console_logs.png" width="700" height="300">

Можно выбрать `Git bash` терминал :

<img src="../images/idea_console_git.png" width="500" height="300">

`Powershell` терминал :

<img src="../images/idea_console_ps.png" width="500" height="300">

### Настройки

В Настройках можно определить пути до необходимых
зависимостей. (Определить версию `Maven`)

<img src="../images/idea_setting.png" width="600" height="450">

В `Project Structure` можно настроить структуру проекта.

- `Project SDK` – выбор `JDK` (можно добавить 
несколько версий).
- `Project language level` – уровень совместимости 
`Java` (например, 8, 11, 17).
- `Project compiler output` – папка для скомпилированных 
классов (обычно out или target).

<img src="../images/idea_setting_1.png" width="600" height="300">

<img src="../images/idea_setting_2.png" width="500" height="300">