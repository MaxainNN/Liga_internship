package pages.sauceDemo;

import org.openqa.selenium.*;
import pages.base.BasePage;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    /**
     * Локатор до заголовка страницы "Products"
     */
    private static final String PRODUCTS_TITLE = "//span[text()='Products']";


    /**
     * Локатор до кнопок "Add to Cart"
     * @param product название товара
     * Валидные значения : Sauce Labs Backpack ,
     *                     Sauce Labs Bike Light ,
     *                     Sauce Labs Bolt T-Shirt ,
     *                     Sauce Labs Fleece Jacket ,
     *                     Sauce Labs Onesie ,
     *                     Test.allTheThings() T-Shirt (Red)
     * @return готовый xpath до кнопки "Add to Cart" указанного товара
     */
    private String addToCartButtons(String product){
        return String.format("//div[@class='inventory_item'][.//div[text()='%s']]//button", product);
    }

    /**
     * Локатор элемента - "Кружок рядом с корзиной с количеством товаров в корзине"
     */
    private static final String CART_BADGE_WITH_NUMBERS = "//span[@class='shopping_cart_badge']";

    /**
     * Локатор до корзины
     */
    private static final String CART_LINK = "//a[@class='shopping_cart_link']";

    /**
     * Проверка - отображается заголовок "Products"
     * @return true если отображается
     */
    public boolean isProductsPageOpen(){
        return isElementDisplay(By.xpath(PRODUCTS_TITLE));
    }

    /**
     * Нажать на кнопку "Add to Cart"
     * @param product название товара
     */
    public void clickAddToCart(String product){
        click(By.xpath(addToCartButtons(product)));
    }

    /**
     * Проверка - корзина не пустая
     * @return true если отображается плашка с количестовом товаров в корзине
     */
    public boolean isCartNotEmpty(){
        return isElementDisplay(By.xpath(CART_BADGE_WITH_NUMBERS));
    }

    /**
     * Количество товаров в корзине
     * @return количество товаров в корзине
     * Тип - String
     */
    public String getCountOfProductsInCart(){
        js.executeScript("window.scrollTo(0, 0)");
        waitForSeconds(3);
        if (isCartNotEmpty()){
            return getText(By.xpath(CART_BADGE_WITH_NUMBERS));
        } else {
            return "[ERROR] Something went wrong. Cart is empty.";
        }
    }

    /**
     * Нажать "OK" в Alert окне "Change your password"
     * На данной странице не работает т.к. окно вызывается "Google Chrome",
     * а не JavaScript Alert.
     */
    public void handleAlert(){
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("[INFO] Alert text: " + alertText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("[INFO] Alert not found!");
        }
    }

    /**
     * Нажать на корзину (Открыть)
     */
    public void openCart(){
        click(By.xpath(CART_LINK));
    }

}
