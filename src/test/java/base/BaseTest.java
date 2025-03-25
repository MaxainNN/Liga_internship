package base;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.ExtentTestNGListener;


/**
* Базовый класс теста.
*/
public abstract class BaseTest {

    public WebDriver driver;

    /**
     * Перед запуском тестового набора будут выполнены действия
     */
    @BeforeSuite
    public void setUpSuite(){
        System.out.println("[INFO] Setting up before test suite.");
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
     */
    @BeforeClass
    public void setUpClass(){
        System.out.println("[INFO] Setting up before class.");
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
    public void tearDownMethod(){
        System.out.println("[INFO] Tearing down after each test method");
    }

    /**
     * После всех тестовых методов в классе будут выполнены действия
     * После всех тестов в классе браузер будет закрыт
     */
    @AfterClass
    public void tearDownClass(){
        System.out.println("[INFO] Tearing down after all test's methods in class.");
        if (driver != null) {
            driver.quit();
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

}
