package browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static browser.Config.BROWSER_TYPE;
import static browser.Config.WAIT;
import static browser.Path.*;

/**
 * Класс Browser предоставляет функциональность для инициализации и управления веб-драйвером.
 * Поддерживаются следующие типы браузеров : Chrome, Edge и Firefox.
 * Содержит метод createDriver , в котором происходит создание и настройка драйвера
 */
public class Browser {

    /**
     * Параметр для определения использования Selenium Grid
     */
    boolean useGrid = Boolean.parseBoolean(System.getProperty("use.grid", "false"));

    /**
     * Параметр для определения использования Selenoid
     */
    boolean useSelenoid = Boolean.parseBoolean(System.getProperty("use.selenoid", "false"));

    /**
     * Параметр для определения url с hub Selenium Grid
     * Указан дефолтный url для hub'а , локальная nod'а на порту 5555
     */
    String gridUrl = System.getProperty("grid.url", "http://192.168.0.192:4444/wd/hub");

    /**
     * Параметр для определения url с hub Selenoid,
     * который поднят в Docker
     */
    String selenoidUrl = System.getProperty("selenoid.url", "http://localhost:4444/wd/hub");

    public static WebDriver driver;

    /**
     * Инициализируется драйвер (необходимо для работы драйвера, иначе ошибка)
     * Устанавливает разрешение экрана на максимальное и настраивает неявное ожидание.
     * Переменная BROWSER_TYPE определяет, какой браузер будет использоваться.
     * @return - возвращает экземпляр класса WebDriver
     */
    public static WebDriver createDriver(){

        /**
         * Параметр для определения использования Selenium Grid
         */
        boolean useGrid = Boolean.parseBoolean(System.getProperty("use.grid", "false"));

        /**
         * Параметр для определения использования Selenoid
         */
        boolean useSelenoid = Boolean.parseBoolean(System.getProperty("use.selenoid", "false"));

        /**
         * Параметр для определения url с hub Selenium Grid
         * Указан дефолтный url для hub'а , локальная nod'а на порту 5555
         */
        String gridUrl = System.getProperty("grid.url", "http://192.168.0.192:4444/wd/hub");

        /**
         * Параметр для определения url с hub Selenoid,
         * который поднят в Docker
         */
        String selenoidUrl = System.getProperty("selenoid.url", "http://localhost:4444/wd/hub");

        /**
         * Используется конструкция "switch-case" для описания инициализации и настройки браузера
         */
        switch (BROWSER_TYPE){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", DRIVERS_PATH + "chromedriver.exe");

                ChromeOptions chromeOptions = new ChromeOptions();
                /**
                 * Настройка отвечающая за директорию, в которую будут загружаться файлы
                 * (Необходимо , чтобы путь был верный , иначе файлы будут загружены в
                 * дирректорию по умолчанию. Например в папку "Downloads" или "Загрузки")
                 */
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("download.default_directory", DOWNLOAD_DIR);
                /**
                 * Запрос на подтверждение загрузки, устанавливаем false
                 */
                chromePrefs.put("download.prompt_for_download", false);
                /**
                 * Разрешение изменения папки загрузки , устанвливаем true
                 */
                chromePrefs.put("download.directory_upgrade", true);
                /**
                 * Активируем безопасный просмотр, устанавливаем true
                 */
                chromePrefs.put("safebrowsing.enabled", true);
                /**
                 * Разрешаем автоматическую загрузку файлов
                 */
                chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                /**
                 * Отключаем инфобар "Chrome is being controlled by automated test software"
                 * Устаревший
                 */
                chromeOptions.addArguments("--disable-infobars");
                /**
                 * Отключаем все браузерные уведомления
                 */
                chromeOptions.addArguments("--disable-notifications");
                /**
                 * Отключаем всплывающее окно "Сохранить пароль?".
                 */
                chromeOptions.addArguments("--disable-save-password-bubble");
                /**
                 * Разрешаем всплывающие окна, которые Chrome обычно блокирует.
                 */
                chromeOptions.addArguments("--disable-popup-blocking");
                /**
                 * Убираем подсказки автозаполнения на мобильных устройствах.
                 */
                chromeOptions.addArguments("--disable-autofill-keyboard-accessory-view");
                /**
                 * Отключаем все расширения Chrome.
                 */
                chromeOptions.addArguments("--disable-extensions");
                /**
                 * Запрещаем Chrome автоматически обновлять компоненты
                 */
                chromeOptions.addArguments("--disable-component-update");
                /**
                 * Отключить проверку утечек паролей в Chrome
                 * Используется в SauceDemo
                 */
                chromeOptions.addArguments("--disable-features=PasswordLeakDetection");
                /**
                 * Сохраняем пароли в незашифрованном виде
                 */
                chromeOptions.addArguments("--password-store=basic");
                /**
                 * Отключаем встроенную проверку паролей в Blink (движок Chrome)
                 */
                chromeOptions.addArguments("--disable-blink-features=PasswordCheck");
                /**
                 * Блокируем принудительную смену пароля.
                 */
                chromeOptions.addArguments("--disable-features=PasswordChangeInSettings");
                /**
                 * Отключаем повторную аутентификацию в менеджере паролей.
                 */
                chromeOptions.addArguments("--disable-password-manager-reauthentication");
                /**
                 * Скрываем интерфейс менеджера паролей.
                 */
                chromeOptions.addArguments("--disable-password-manager-ui");
                /**
                 * Отключаем индикатор сложности пароля.
                 */
                chromeOptions.addArguments("--disable-password-strength-meter");
                /**
                 * Настройка отвечающая за выполнение тестов в "headless" режиме
                 * (Выполнение теста не показывается на экране)
                 */
                chromeOptions.addArguments("--headless");
                /**
                 * Отключаем GPU (рекомендуется для headless-режима)
                 */
                chromeOptions.addArguments("--disable-gpu");
                /**
                 * Устанавливаем размер окна (важно для headless-режима)
                 */
                chromeOptions.addArguments("--window-size=1920,1080");
                /**
                 * Отключаем песочницу (для CI/CD)
                 */
                chromeOptions.addArguments("--no-sandbox");
                /**
                 * Игнорируем ошибки сертификатов
                 */
                chromeOptions.addArguments("--ignore-certificate-errors");
                /**
                 * Настройка , при которой User-Agent будет изменяться при каждом запуске
                 * (Нужно для теста с Google, чтобы избежать появления CAPTCHA)
                 */
                chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
                /**
                 * Скрывает признаки автоматизации, Частично маскирует WebDriver от детекции как бота
                 */
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                /**
                 * Сохраняет cookies, кэш и историю между запусками тестов
                 */
                chromeOptions.addArguments("--user-data-dir=" + GOOGLE_PROFILE_DIR);
                /**
                 * Разрешает кросс-доменные запросы (отключает Same-Origin Policy)
                 */
                chromeOptions.addArguments("--disable-web-security");
                /**
                 * Удаляет навигационный флаг navigator.webdriver=true (?)
                 * Скрывает использование ChromeDriver от JavaScript-детекторов
                 */
                chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
                /**
                 * Настройка , отвечающая за стратегию загрузки страницы
                 * Может быть normal , eager, none
                 * Eager - значит , что страница считается загруженной , когда DOM
                 * полностью загружен , но некоторые элементы (изображения)
                 * могут еще загружаться
                 */
                chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");

                if (useSelenoid) {
                    chromeOptions.setCapability("browserName", "chrome");
                    chromeOptions.setCapability("browserVersion", "latest");
                    chromeOptions.setCapability("enableVNC", true);
                    chromeOptions.setCapability("enableVideo", true);
                    chromeOptions.setCapability("screenResolution", "1920x1080x24");

                    try {
                        driver = new RemoteWebDriver(new URL(selenoidUrl), chromeOptions);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid Selenoid URL: " + selenoidUrl, e);
                    }
                } else if (useGrid) {
                    try {
                        driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid Grid URL: " + gridUrl, e);
                    }
                } else {
                    ChromeDriverService service = new ChromeDriverService.Builder()
                            .withLogOutput(System.out)
                            .withAppendLog(true)
                            .withReadableTimestamp(true)
                            // Очень подробные логи
                            //.withVerbose(true)
                            .build();

                    driver = new ChromeDriver(service, chromeOptions);
                }

                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", DRIVERS_PATH + "msedgedriver.exe");
                EdgeOptions options = new EdgeOptions();
                Map <String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", DOWNLOAD_DIR);
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--headless");
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");

                if (useSelenoid) {
                    options.setCapability("browserName", "edge");
                    options.setCapability("browserVersion", "latest");
                    options.setCapability("enableVNC", true);
                    options.setCapability("enableVideo", true);
                    options.setCapability("screenResolution", "1920x1080x24");

                    try {
                        driver = new RemoteWebDriver(new URL(selenoidUrl), options);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid Selenoid URL: " + selenoidUrl, e);
                    }
                } else if (useGrid) {
                    try {
                        driver = new RemoteWebDriver(new URL(gridUrl), options);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid Grid URL: " + gridUrl, e);
                    }
                } else {
                    EdgeDriverService service = new EdgeDriverService.Builder()
                            .withLogOutput(System.out)
                            .withAppendLog(true)
                            .withReadableTimestamp(true)
                            .build();

                    driver = new EdgeDriver(service, options);
                }

                break;
            case "firefox":
                System.setProperty("webdriver.firefox.driver", DRIVERS_PATH + "geckodriver.exe");
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.addArguments("--headless");
                fOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");

                if (useSelenoid) {
                    fOptions.setCapability("browserName", "edge");
                    fOptions.setCapability("browserVersion", "latest");
                    fOptions.setCapability("enableVNC", true);
                    fOptions.setCapability("enableVideo", true);
                    fOptions.setCapability("screenResolution", "1920x1080x24");

                    try {
                        driver = new RemoteWebDriver(new URL(selenoidUrl), fOptions);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid Selenoid URL: " + selenoidUrl, e);
                    }
                } else if (useGrid) {
                    try {
                        driver = new RemoteWebDriver(new URL(gridUrl), fOptions);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid Grid URL: " + gridUrl, e);
                    }
                } else {
                    FirefoxDriverService service = new GeckoDriverService.Builder()
                            .withLogOutput(System.out)
                            .build();

                    driver = new FirefoxDriver(service, fOptions);
                }

                break;
            default:
                System.out.println("Некорректное имя браузера: " + BROWSER_TYPE);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));

        return driver;
    }

    /**
     * Получить название браузера
     * @param driver созданный драйвер
     * @return название браузера
     */
    public static String getBrowserName(WebDriver driver) {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        return caps.getBrowserName();
    }

    /**
     * Получить версию браузера
     * @param driver созданный драйвер
     * @return версию браузера
     */
    public static String getBrowserVersion(WebDriver driver) {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        return caps.getBrowserVersion();
    }

    /**
     * Получить ОС (платформу) браузера
     * @param driver созданный драйвер
     * @return ОС , на которой запущен драйвер
     */
    public static String getPlatformType(WebDriver driver){
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        return String.valueOf(caps.getPlatformName());
    }
}