package pages.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

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
     * @param index индекс для логина пользователя.
     * Если значение 1 , логин - "standard_user".
     * Валидные значения от 1 до 6
     * @return xpath к указанному пользвателю
     */
    private String userNameCredentials(int index){
        return String.format("//div[@class='login_credentials']/text()[%s]", index);
    }

    /**
     * Локатор до элемента с "Credentials" для password
     */
    private static final String PASSWORD_FOR_ALL_USERS = "//div[@class='login_password']/text()";

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
        sendKeys(By.xpath(USERNAME_FIELD),getText(By.xpath(userNameCredentials(1))));
        sendKeys(By.xpath(PASSWORD_FIELD),getText(By.xpath(PASSWORD_FOR_ALL_USERS)));
        click(By.xpath(LOGIN_BUTTON));
    }

    /**
     * TODO
     * Error
     * "//div[@class='login_credentials']/text()[1]" is: [object Text]. It should be an element.
     * **/
    public String printLogin(){
        return this.getText(By.xpath(userNameCredentials(1)));
    }
}
