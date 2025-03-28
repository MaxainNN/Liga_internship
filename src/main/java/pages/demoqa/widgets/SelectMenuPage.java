package pages.demoqa.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс для "Select Menu" виджетов
*/
public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Url до страницы "Select Menu"
     */
    private static final String URL_SELECT_MENU_PAGE = "https://demoqa.com/select-menu";

    /**
     * Второе значение в выпадающем списке
     */
    private static final String DROPDOWN_SECOND_OPTION = "Group 1, option 2";

    /**
     * Локатор до первого выпадающего списка (Select Value)
     */
    private static final String FIRST_DROPDOWN = "//input[@id='react-select-2-input']";

    /**
     * Локатор до Old Style Select Menu
     */
    private static final String OLD_STYLE_MENU_SELECT = "//select[@id='oldSelectMenu']";

    /**
     * Локатор до вариантов в выпадающем списке
     * в Old Style Select Menu
     * @param number порядковый номер варианта
     * Валидные значения : 1-10
     */
    private String oldSelectOption(String number){
        return String.format("//select[@id='oldSelectMenu']/option[%s]", number);
    }

    /**
     * Перейти на страницу "Select Menu"
     */
    public void openSelectMenuPage(){
        openUrl(URL_SELECT_MENU_PAGE);
    }

    /**
     * Выбрать в первом выпадаюшем списке второе значение (внести)
     */
    public void setSecondOptionInFirstDropDown(){
        sendKeys(By.xpath(FIRST_DROPDOWN), DROPDOWN_SECOND_OPTION);
    }

    /**
     * Выбрать в Old Style Select Menu значение
     * @param number порядковый номер варианта
     */
    public void setValueInOldStyleSelect(String number){
        click(By.xpath(OLD_STYLE_MENU_SELECT));
        click(By.xpath(oldSelectOption("1")));
    }
}
