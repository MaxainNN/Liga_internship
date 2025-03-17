package pages.sauceDemo;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Url до страницы с логином
     */
    public static final String SAUCE_DEMO_URL = "https://www.saucedemo.com/";

    /**
     * Локатор до элемента с "Credentials" для usernames
     * @param index индекс для логина пользователя.
     * Если значение 1 , логин - "standard_user".
     * Валидные значения от 1 до 6
     * @return xpath к указанному пользвателю
     */
    public String userNameCredentials(int index){
        return String.format("//div[@class='login_credentials']/text()[%s]", index);
    }

    /**
     * Локатор до элемента с "Credentials" для password
     */
    public static final String passWordForAllUsers = "//div[@class='login_password']/text()";

    /**
     * Открыть страницу с логином "SauceDemo"
     */
    public void openLoginPage(){
        openUrl(SAUCE_DEMO_URL);
    }

    /**
     * Авторизоваться с логином "standard_user"
     **/
    public void authorize(){
        openLoginPage();

    }
}
