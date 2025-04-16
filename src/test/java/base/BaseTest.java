package base;

import browser.Browser;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentTestNGListener;

import java.io.ByteArrayInputStream;


/**
 * Базовый класс теста.
 */
public abstract class BaseTest {

    public WebDriver driver;
    public static boolean useSelenoid;
    public static String selenoidUrl;

    /**
     * Перед запуском тестового набора будут выполнены действия
     */
    @BeforeSuite
    public void setUpSuite(){
        System.out.println("[INFO] Setting up before test suite.");

        // Env vars
    }

    /**
     * Перед запуском всех тестовых методов будут выполнены действия
     * внутри тэга <test></test> в testng.mxl
     */
    @BeforeTest
    public void setUpTest(){
        System.out.println("[INFO] Setting up before test.");
    }

    /**
     * Перед запуском первого тестового метода в классе будут выполены действия
     * Перед всеми тестами в классе будет создан экземпляр драйвера
     * @param useSelenoidParam использование Selenoid
     * @param selenoidUrlParam адрес Selenoid
     */
    @BeforeClass
    @Parameters({"use.selenoid", "selenoid.url"})
    @Step("Создание драйвера, получение данных для отчета")
    public void setUpClass(@Optional("false") String useSelenoidParam,
                           @Optional("http://localhost:4444/wd/hub") String selenoidUrlParam){
        System.out.println("[INFO] Setting up before class.");

        useSelenoid = Boolean.parseBoolean(useSelenoidParam);
        selenoidUrl = selenoidUrlParam;
        System.out.println(String.format("[CONFIG] Selenoid mode: %s, URL: %s",useSelenoid, selenoidUrl));

        driver = Browser.createDriver();
        ExtentTestNGListener.setSystemInfo(driver);
    }

    /**
     * Перед запуском тестового метода будут выполнены действия
     */
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("[INFO] Setting up before each test method");
    }

    /**
     * После каждого тестового метода будут выполнены действия
     */
    @AfterMethod
    public void tearDownMethod(ITestResult result){
        System.out.println("[INFO] Tearing down after each test method");

        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SUCCESS) {
            takeScreenshot("Screenshot after test: " + result.getName());
        }
    }

    /**
     * После всех тестовых методов в классе будут выполнены действия
     * После всех тестов в классе браузер будет закрыт
     */
    @AfterClass(alwaysRun = true)
    @Step("Закрытие сессии драйвера")
    public void tearDownClass(){
        System.out.println("[INFO] Tearing down after all test's methods in class.");

        try {
            if (useSelenoid && driver instanceof RemoteWebDriver) {
                String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
                String videoUrl = selenoidUrl.replace("/wd/hub", "") + "/video/" + sessionId + ".mp4";
                System.out.println("VIDEO URL: " + videoUrl);

                Allure.addAttachment("Selenoid Video", "text/uri-list", videoUrl);
            }
        } catch (Exception e) {
            System.err.println("Failed to get video URL: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    /**
     * После всех тестовых методов в классе будут выполнены действия
     * внутри тэга <test></test> в testng.mxl
     */
    @AfterTest
    public void tearDownTest(){
        System.out.println("[INFO] Tearing down after all test's methods.");
    }

    /**
     * После прохождения тестового набора будут выполнены действия
     */
    @AfterSuite
    public void tearDownSuite(){
        System.out.println("[INFO] Tearing down after test suite.");
    }

    /**
     * Создает скриншот и прикрепляет его к Allure отчету
     * @param name название скриншота в отчете
     */
    @Step("Создание скриншота: {name}")
    public void takeScreenshot(String name) {
        if (driver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
            } catch (Exception e) {
                System.err.println("Failed to take screenshot: " + e.getMessage());
            }
        }
    }
}