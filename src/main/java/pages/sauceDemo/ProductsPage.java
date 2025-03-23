package pages.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор до заголовка страницы "Products"
     */
    private static final String PRODUCTS_TITLE = "//span[text()='Products']";

    /**
     * Проверка - отображается заголовок "Products"
     * @return true если отображается
     * */
    public boolean isProductsPageOpen(){
        return isElementDisplay(By.xpath(PRODUCTS_TITLE));
    }
}
