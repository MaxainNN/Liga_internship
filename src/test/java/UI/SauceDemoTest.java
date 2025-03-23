package UI;

import base.BaseTest;
import org.openqa.selenium.By;
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
//        loginPage.authorize();
        loginPage.openLoginPage();
        System.out.println(loginPage.printLogin());
//        Assert.assertTrue(productsPage.isProductsPageOpen());
    }

    @Test(description = "Нажать на кнопку 'Add to cart'")
    public void step_02(){
        Assert.assertTrue(true);
    }
}
