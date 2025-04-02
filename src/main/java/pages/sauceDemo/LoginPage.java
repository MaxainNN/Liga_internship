package pages.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс для страницы с логином "SauceDemo"
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Url до страницы с логином
     */
    private static final String SAUCE_DEMO_URL = "https://www.saucedemo.com/";

    /**
     * Локатор до элемента с "Credentials" для usernames
     */
    private static final String USERNAME_CREDENTIALS = "//div[@class='login_credentials']";


    /**
     * Локатор до элемента с "Credentials" для password
     */
    private static final String PASSWORD_FOR_ALL_USERS = "//div[@class='login_password']";

    /**
     * Локатор до поля "Username"
     */
    private static final String USERNAME_FIELD = "//input[@data-test='username']";

    /**
     * Локатор до поля "Password"
     */
    private static final String PASSWORD_FIELD = "//input[@data-test='password']";

    /**
     * Локатор до кнопки "Login"
     */
    private static final String LOGIN_BUTTON = "//input[@data-test='login-button']";

    /**
     * Открыть страницу с логином "SauceDemo"
     */
    public void openLoginPage(){
        openUrl(SAUCE_DEMO_URL);
    }

    /**
     * Авторизоваться с логином "standard_user"
     */
    public void authorize(){
        openLoginPage();
        isElementDisplay(By.xpath(LOGIN_BUTTON));
        sendKeys(By.xpath(USERNAME_FIELD),getLogin(1));
        sendKeys(By.xpath(PASSWORD_FIELD),getPassword());
        click(By.xpath(LOGIN_BUTTON));
    }

    /**
     * Получить логин
     * @param index индекс логина (значения от 1 до 6)
     * index is 1 = standard_user
     * @return логин под указанным индексом
     */
    public String getLogin(int index){
        String fullText = getText(By.xpath(USERNAME_CREDENTIALS));
        String[] logins = fullText.split("\n");

        if (index >= 0 && index < logins.length) {
            return logins[index].trim();
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound.");
        }
    }

    /**
     * Получить пароль
     */
    public String getPassword(){
        return getText(By.xpath(PASSWORD_FOR_ALL_USERS)).split("\n")[1];
    }

}
