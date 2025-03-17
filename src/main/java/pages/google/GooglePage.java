package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

/**
 * Класс для страницы "Google"
 */
public class GooglePage extends BasePage {

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    /**
     * Url для главной страницы "Google"
     */
    public static final String GOOGLE_URL = "https://www.google.ru/";

    /**
     * Локатор до строки поиска на главной странице
     * Может быть - "Search"
     */
    public static final String SEARCH_TEXT_AREA = "//textarea[@title='Поиск']";

    /**
     * Локатор до кнопки "Google Search"
     * Может быть - "Google Search"
     */
    public static final String SEARCH_BUTTON = "(//input[@value='Поиск в Google'])[2]";

    /**
     * Локатор ло кнопки "Replay animation" в нижней части страницы
     */
    public static final String REPLAY_ANIMATION_BUTTON = "(//g-ripple)[1]";

    /**
     * Локатор до элемента , которому после начала анимации добавляется аттрибут
     */
    public static final String INNER_ANIMATION_ELEMENT = "(//div[@jsname='AHe6Kc'])[1]";

    /**
     * Открыть главную страницу "Google"
     */
    public void openGooglePage(){
        openUrl(GOOGLE_URL);
    }

    /**
     * Внести значение в поисковую строку и нажать на кнопку "Google Search"
     * @param value значение , которое передается в поисковую строку
     */
    public void search(String value){
        waitForSeconds(2);
        sendKeys(By.xpath(SEARCH_TEXT_AREA), value);
        clickEmptyArea();
        waitForSeconds(2);
        click(By.xpath(SEARCH_BUTTON));
    }

    /**
     * Нажать на пустое место на странице
     */
    public void clickEmptyArea(){
        actions.moveByOffset(0, 0).click().build().perform();
    }

    /**
     * Нажать на кнопку "Replay animation"
     */
    public void clickAnimationButton(){
        waitElementIsVisible(By.xpath(REPLAY_ANIMATION_BUTTON));
        click(By.xpath(REPLAY_ANIMATION_BUTTON));
    }

    /**
     * Проверка - после начала анимации у внутреннего элемента
     * появляется аттрибут "style" со значением "opacity"
     * @return true если у элемента появляется такой аттрибут со значением
     */
    public boolean isAttributeAdded(){
        return getAttributeValue(By.xpath(INNER_ANIMATION_ELEMENT),"style").contains("opacity");
    }

}
