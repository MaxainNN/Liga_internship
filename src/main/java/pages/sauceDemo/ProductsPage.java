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
     */
    public boolean isCartNotEmpty(){
        return isElementDisplay(By.xpath(CART_BADGE_WITH_NUMBERS));
    }

    /**
     * Количество товаров в корзине
     */
    public String getCountOfProductsInCart(){
        if (isCartNotEmpty()){
            return getText(By.xpath(CART_BADGE_WITH_NUMBERS));
        } else {
            return "[ERROR] Something went wrong. Cart is empty.";
        }
    }

}
