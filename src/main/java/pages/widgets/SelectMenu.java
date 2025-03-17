package pages.widgets;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс для "Select Menu" виджетов
*/
public class SelectMenu extends BasePage {

    public SelectMenu(WebDriver driver) {
        super(driver);
    }

    /**
     * Url до страницы "Select Menu"
     */
    public static final String URL_SELECT_MENU_PAGE = "https://demoqa.com/select-menu";

    /**
     * Перейти на страницу "Select Menu"
     */
    public void openSelectMenuPage(){
        openUrl(URL_SELECT_MENU_PAGE);
    }
}
