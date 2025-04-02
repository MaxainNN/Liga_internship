package pages.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс для "Buttons" элементов
 */
public class ButtonsPage extends BasePage {

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Url для страницы "Buttons"
     */
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/buttons";

    /**
     * Локатор до кнопки "Double Click Me"
     */
    public static final By DOUBLE_CLICK_BTN = By.id("doubleClickBtn");

    /**
     * Локатор до кнопки "Right Click Me"
     */
    public static final By RIGHT_CLICK_BTN = By.id("rightClickBtn");

    /**
     * Текст сообщения , если была нажата кнопка "Double Click Me"
     */
    public static final String MESSAGE_DOUBLE_CLICK = "You have done a double click";

    /**
     * Текст сообщения , если была нажата кнопка "Right Click Me"
     */
    public static final String MESSAGE_RIGHT_CLICK = "You have done a right click";

    /**
     * Текст сообщения , если была нажата кнопка "Click Me"
     */
    public static final String MESSAGE_CLICK = "You have done a dynamic click";

    /**
     * Открыть страницу с "Buttons"
     */
    public void openButtonsPage(){
        openUrl(URL_TEXT_BOX_PAGE);
    }

    /**
     * Проверка - Сообщение отобразилось
     * @param message текст сообщения
     * @return true если отобразилось
     */
    public boolean isMessageDisplay(String message){
        String xpath = "//*[text()='" + message + "']";
        return isElementDisplay(By.xpath(xpath));
    }
}
