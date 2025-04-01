package pages.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор до кнопки "Checkout"
     */
    private static final String CHECKOUT_BUTTON = "//button[@name='checkout']";

    /**
     * Локатор до заголовка страницы с карточкой товара
     */
    private static final String INFORMATION_PAGE_TITLE = "//span[text()='Checkout: Your Information']";

    /**
     * Нажать на кнопку "Checkout"
     */
    public void pressCheckout(){
        click(By.xpath(CHECKOUT_BUTTON));
    }

    /**
     * Получить текст из заголовка страницы с карточкой клиента
     */
    public boolean getTextFromTitleClientInformation(){
        return isElementsDisplay(By.xpath(INFORMATION_PAGE_TITLE));
    }
}
