package UI;

import base.BaseTest;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.awaitility.Awaitility.await;

/**
 * Тест на "TestEnginner.ru"
 * Для теста не реализован PageObject
 */
@Epic("TESTENGINEER")
@Feature("Главная страница testengineer.ru")
@Story("Тесты на https://testengineer.ru/")
public class AllureReportTest extends BaseTest {

    @Test(description = "Открыть главную страницу сайта")
    @Description("Открыть главную страницу сайта")
    @Severity(CRITICAL)
    @Owner("Максим Калугин")
    public void step_01(){
        step("Переход на главную страницу" , () -> {
            driver.get("https://testengineer.ru/");
        });
        Assert.assertTrue(true);
    }

    @Test(description = "Отправка формы с фейковыми данными")
    @Description("Проверка отправки формы с сгенерированными данными через JavaFaker")
    @Severity(NORMAL)
    @Owner("Максим Калугин")
    public void step_02(){
        Faker faker = new Faker(new Locale("ru"));
        String userName = faker.name().fullName();
        String password = faker.internet().password();

        WebElement signInButton = driver.findElement(By.xpath(
                "//span[text()='Войти / Зарегистрироваться']/ancestor::a"));
        signInButton.click();

        WebElement usernameInputField = driver.findElement(By.xpath(
                "(//input[@class='td-login-input' and @name='login_email'])[1]"));
        WebElement passwordInputField = driver.findElement(By.xpath(
                "(//input[@class='td-login-input' and @name='login_pass'])[1]"));
        WebElement signUpButtonInSignInForm = driver.findElement(By.xpath(
                "(//input[@type='button' and @name='login_button'])[1]"));

        step("Заполнение формы регистрации", () -> {
            usernameInputField.sendKeys(userName);
            passwordInputField.sendKeys(password);
            signUpButtonInSignInForm.click();
        });

        WebElement errorSignInMessage = driver.findElement(By.xpath(
                "(//div[@class='td_display_err'])[1]"));

        step("Получение сообщения об ошибке", () -> {
            String errorMessage = errorSignInMessage.getText();
            Assert.assertEquals(errorMessage,"Неверное имя пользователя или пароль!");
        });
    }

    @Test(description = "Выход из формы авторизации")
    @Description("Выход из формы авторизации")
    @Severity(NORMAL)
    @Owner("Максим Калугин")
    public void step_03(){
        WebElement closeButtonInSingInForm = driver.findElement(By.xpath(
                "//button[@title='Close (Esc)']"));

        step("Выход из формы регистрации", closeButtonInSingInForm::click);

        // TODO add working await test and assert
//        step("Ожидание появления баннера", () -> {
//            await().atMost(10, TimeUnit.SECONDS).until(() ->
//                    driver.findElement(By.id("promo-banner")).isDisplayed()
//            );
//        });
    }
}