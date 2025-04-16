package UI;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static browser.Browser.createDriver;
import static io.qameta.allure.Allure.step;

/**
 * Тест с использованием Selenium Grid
 * Нет наследования от BaseTest
 * Для теста не реализован Page Object
 */
@Epic("HABR")
@Feature("Test articles")
@Story("Тест раздела по тестированию веб сервисов")
public class SeleniumGridTest {

    private WebDriver driver;

    @BeforeClass(description = "Создаем экземпляр драйвера, устанваливаем параметр use.grid = true")
    @Step("Создание экземпляра драйвера")
    public void setupClass(){
        // Закоментировать для прохожения без Selenium Grid
        //System.setProperty("use.grid", "true");
        driver = createDriver();
    }

    @AfterClass(description = "Закрываем браузер")
    @Step("Закрытие экземпляра драйвера")
    public void tearDownClass(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test(description = "Переходим на страницу с 'Habr' , получаем заголовок страницы.")
    @Step("Переход на главную страницу 'Habr'")
    public void step_01(){
        driver.get("https://habr.com/ru/hubs/web_testing/articles/page1/");
        System.out.println("[INFO] Page title: " + driver.getTitle());
        Assert.assertTrue(true);
    }

    @Test(description = "Открываем первую статью , проверяем отображение текста")
    @Step("Открытие первой статьи, проверка отображения текста")
    public void step_02(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        step("Проверка - элемент кликабельный", () ->
                wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@data-test-id='articleTitle'][1]"))
                ).click() );
        step("Проверка - отображается текст в статье",() ->
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[1]")
        )).isDisplayed());

        Assert.assertTrue(true);
    }

    @Test(description = "Ожидание")
    @Step("Ожидание")
    public void step_03(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}