package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.sauceDemo.LoginPage;
import pages.sauceDemo.ProductsPage;

/**
 * Тест на "SauceDemo"
 */
public class SauceDemoTest extends BaseTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeClass
    public void beforeClass(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test(description = "Авторизация на главной странице")
    public void step_01(){
        loginPage.authorize();
        Assert.assertTrue(productsPage.isProductsPageOpen());
    }

    @Test(description = "Нажать на кнопку 'Add to cart' у первого элемента.")
    public void step_02(){
        productsPage.clickAddToCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getCountOfProductsInCart(), "1");
    }

    // Расписать до покупки
}
