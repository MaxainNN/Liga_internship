package pages.secondPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс для пустой главной страницы , после выбора категории
*/
public class SecondPage extends BasePage {

    public SecondPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор до изображения "Zero Step"
     */
    public static final By ZERO_STEP_PICTURE = By.xpath("//a/img[@src='/images/zero-step.jpeg']");

    /**
     * Локатор до текста посередине страницы
     */
    public static final By PLEASE_SELECT_AN_ITEM = By.xpath("//div[text()='Please select an item from left to start practice.']");

    /**
     * Проверка - отображается картинка на странице (Zero Step)
     * @return true если отображается
     */
    public boolean isZeroStepPictureIsDisplayed(){
        return isElementDisplay(ZERO_STEP_PICTURE);
    }

    /**
     * Проверка - надпись отображается на странице (Please select...)
     * @return true если отображается
     */
    public boolean isPleaseSelectAnItemXpathIsDisplayed(){
        return isElementDisplay(PLEASE_SELECT_AN_ITEM);
    }

    /**
     * Проверка - страница открылась
     * @return true если отображается картинка и надпись
     */
    public boolean isPageOpen(){
        if (isZeroStepPictureIsDisplayed() && isPleaseSelectAnItemXpathIsDisplayed()){
            return true;
        }
        return false;
    }
}
