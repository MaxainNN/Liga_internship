## Devtools

`Chrome DevTools` — это встроенный в браузер инструмент 
для отладки, анализа производительности и управления 
поведением страницы. В контексте автоматизации тестов 
он позволяет:

- ✅ Эмулировать устройства, сети, геолокацию.
- ✅ Перехватывать и модифицировать `HTTP`-запросы.
- ✅ Анализировать `DOM`, `CSS`, `JavaScript`.
- ✅ Работать с `Cookies`, `LocalStorage`.

### Вкладки `Devtools`

|Вкладка|                             Для чего нужна?                             |   Пример использования в Selenium   |
|:--:|:-----------------------------------------------------------------------:|:-----------------------------------:|
|Elements|                   Просмотр и редактирование HTML/CSS.                   |  Поиск элементов через XPath/CSS.   |
|Console|                 Запуск JavaScript, логирование ошибок.                  |executeScript("console.log('test')").|
|Network|               Мониторинг HTTP-запросов, подмена ответов.                |Перехват API-запросов через CDP. |
|Performance|                   Анализ скорости загрузки страницы.                    |Замер времени выполнения теста.      |
|Application|            Управление Cookies, LocalStorage, SessionStorage.            |Очистка кэша перед тестом.|
|Security|                      Проверка HTTPS-сертификатов.                       |Отключение проверки сертификатов.       |
|Lighthouse|      Аудит производительности и SEO.|Не используется в автотестах.       |

### Примеры использования :

#### Создание сессии

```java
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class DevtoolsExample(){
    
    ChromeDriver driver = new ChromeDriver();
    DevTools devTools = driver.getDevTools();
    
    public void createSession(){
        devTools.createSession();
    }
}
```

#### Эмуляция геолокации

```java
import org.openqa.selenium.devtools.v114.emulation.Emulation;

public class DevtoolsExample(){

    ChromeDriver driver = new ChromeDriver();
    DevTools devTools = driver.getDevTools();
    
    public void setGeoLocation(){
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(52.5200),  // Широта (Москва)
                Optional.of(13.4050),  // Долгота
                Optional.of(1)         // Точность
        ));

        driver.get("https://www.google.com/maps");  // Проверит локацию
    }
}

```

#### Перехват сетевых запросов

```java
import org.openqa.selenium.devtools.v114.emulation.Emulation;

public class DevtoolsExample(){

    ChromeDriver driver = new ChromeDriver();
    DevTools devTools = driver.getDevTools();
    
    public void setListener(){
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("Request URL: " + request.getRequest().getUrl());
        });
    }
}
```

#### Блокировка ресурсов (CSS, изображений)

```java
import org.openqa.selenium.devtools.v114.emulation.Emulation;

public class DevtoolsExample(){

    ChromeDriver driver = new ChromeDriver();
    DevTools devTools = driver.getDevTools();
    
    public void blockCss(){
        devTools.send(Network.enable());
        devTools.send(Network.setBlockedURLs(List.of("*.css", "*.png")));
        driver.get("https://example.com");  // Страница загрузится без CSS.
    }
}
```

#### Работа с Cookies

```java
import org.openqa.selenium.devtools.v114.emulation.Emulation;

public class DevtoolsExample(){

    ChromeDriver driver = new ChromeDriver();
    DevTools devTools = driver.getDevTools();
    
    public void handleCookies(){
        // Get all
        List<Cookie> cookies = devTools.send(Network.getAllCookies());
        cookies.forEach(cookie -> System.out.println(cookie.getName()));
        // Delete all
        devTools.send(Network.clearBrowserCookies());
    }
}
```

### Настройки для `Chrome`

- https://peter.sh/experiments/chromium-command-line-switches/ — полный список всех аргументов.
- https://chromedevtools.github.io/devtools-protocol/ — для низкоуровневого управления.

В браузере :

Открыть `Chrome` и введите в адресной строке:

```plaintext
 chrome://flags
```
