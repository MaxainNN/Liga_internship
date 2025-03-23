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
     private static final String GOOGLE_URL = "https://www.google.ru/";

    /**
     * Локатор до строки поиска на главной странице
     * Может быть - "Search"
     */
    private static final String SEARCH_TEXT_AREA = "//textarea[@title='Поиск']";

    /**
     * Локатор до кнопки "Google Search"
     * Может быть - "Google Search"
     */
    private static final String SEARCH_BUTTON = "(//input[@value='Поиск в Google'])[2]";

    /**
     * Локатор ло кнопки "Replay animation" в нижней части страницы
     */
    private static final String REPLAY_ANIMATION_BUTTON = "(//g-ripple)[1]";

    /**
     * Локатор до элемента , которому после начала анимации добавляется аттрибут
     */
    private static final String INNER_ANIMATION_ELEMENT = "(//div[@jsname='AHe6Kc'])[1]";

    /**
     * Локатор до до кнопки "Принять все" в уведомлении о cookie
     */
    private static final String ACCEPT_COOKIE_BUTTON = "//div[text()='Принять все']";

    /**
     * Локатор до текста с reCAPTCHA
     * */
    private static final String RECAPTCHA_TEXT = "(//div[contains(string(), " +
            "'подозрительный трафик')])[2]";

    /**
     * Открыть главную страницу "Google"
     */
    public void openGooglePage(){
        openUrl(GOOGLE_URL);
    }

    /**
     * Нажать на кнопку "Принять все"
     * в уведомлении о cookie
     * **/
    public void acceptCookie(){
        waitElementIsDisplay(By.xpath(ACCEPT_COOKIE_BUTTON),3);
        click(By.xpath(ACCEPT_COOKIE_BUTTON));
    }

    /**
     * Внести значение в поисковую строку и нажать на кнопку "Google Search"
     * @param value значение , которое передается в поисковую строку
     */
    public void search(String value){
        waitElementIsVisible(By.xpath(SEARCH_TEXT_AREA));
        waitElementIsDisplay(By.xpath(SEARCH_TEXT_AREA), 2);
        sendKeys(By.xpath(SEARCH_TEXT_AREA), value);
        clickEmptyArea();
        waitElementIsVisible(By.xpath(SEARCH_BUTTON));
        waitElementIsDisplay(By.xpath(SEARCH_BUTTON), 2);
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
        waitElementIsDisplay(By.xpath(REPLAY_ANIMATION_BUTTON),2);
        click(By.xpath(REPLAY_ANIMATION_BUTTON));
    }

    /**
     * Проверка - после начала анимации у внутреннего элемента
     * появляется аттрибут "style" со значением "opacity"
     * @return true если у элемента появляется такой аттрибут со значением
     */
    public boolean isAttributeAdded(){
        try {
            waitForSeconds(2);
            waitElementIsDisplay(By.xpath(INNER_ANIMATION_ELEMENT), 3);
            return getAttributeValue(By.xpath(INNER_ANIMATION_ELEMENT),"style").contains("opacity");
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Отображается сообщение с reCAPTCHA
     * @return true если отображается
     * сообщение о подозрительном трафике
     */
    public boolean isCaptchaAppeared(){
        return isElementsDisplay(By.xpath(RECAPTCHA_TEXT));
    }

}
