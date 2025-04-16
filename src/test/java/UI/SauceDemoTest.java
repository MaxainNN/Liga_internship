package UI;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.sauceDemo.CartPage;
import pages.sauceDemo.LoginPage;
import pages.sauceDemo.ProductsPage;

/**
 * Тест на "SauceDemo"
 */
@Epic("SAUCE_DEMO")
@Feature("Buy Sauce demo product")
@Story("Тест логина и покупки первого товара")
public class SauceDemoTest extends BaseTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    @BeforeClass
    public void beforeClass(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(description = "Авторизация на главной странице")
    @Step("Авторизация на главной странице")
    public void step_01(){
        loginPage.authorize();
        Assert.assertTrue(productsPage.isProductsPageOpen());
    }

    @Test(description = "Нажать на кнопку 'Add to cart' у первого элемента.")
    @Step("Нажатие на кнопку 'Add to cart' у первого элемента.")
    public void step_02(){
        productsPage.clickAddToCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getCountOfProductsInCart(), "1");
    }

    @Test(description = "Открыть корзину , нажать 'Checkout'", enabled = false)
    @Step("Открытие корзины , нажатие 'Checkout")
    public void step_03(){
        productsPage.openCart();
        cartPage.pressCheckout();
        Assert.assertTrue(cartPage.getTextFromTitleClientInformation());
    }
}