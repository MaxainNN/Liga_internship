package UI;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.elements.LinksPage;

/**
 * Тест на "Links"
*/
@Epic("DEMOQA")
@Feature("Links elements")
@Story("Тест Links элементов")
public class LinksTest extends BaseTest {

    private LinksPage linksPage;

    @BeforeClass
    public void beforeClass(){
        linksPage = new LinksPage(driver);
    }

    @Test(description = "Перейти на страницу , перейти по 1-ой ссылке, закрыть новою вкладку")
    @Step("Переход по первой ссылке, закрытие новой вкладки")
    public void step_01(){
        linksPage.openLinksPage();
        linksPage.click(linksPage.HOME_LINK);
        linksPage.set_tabs(driver);
        driver.switchTo().window(linksPage.tabs.get(1));
        Assert.assertTrue(linksPage.isBannerDisplay());
        driver.close();
        driver.switchTo().window(linksPage.tabs.get(0));
    }

    @Test(description = "Перейти по 2-ой ссылке, закрыть новою вкладку")
    @Step("Переход по второй ссылке, закрытие новой вкладки")
    public void step_02(){
        linksPage.click(linksPage.HOME_LINK_1);
        linksPage.set_tabs(driver);
        driver.switchTo().window(linksPage.tabs.get(1));
        Assert.assertTrue(linksPage.isBannerDisplay());
        driver.close();
        driver.switchTo().window(linksPage.tabs.get(0));
    }

    @Test(description = "Перейти по ссылкам с вызовом методов со статус кодом")
    @Step("Переход по ссылкам с получение статус кодов")
    public void step_03(){
        linksPage.waitForSeconds(3);
        linksPage.clickLink("created");
        Assert.assertTrue(linksPage.isStatusDisplay("201"));
        linksPage.clickLink("no-content");
        Assert.assertTrue(linksPage.isStatusDisplay("204"));
        linksPage.clickLink("moved");
        Assert.assertTrue(linksPage.isStatusDisplay("301"));
        linksPage.clickLink("bad-request");
        Assert.assertTrue(linksPage.isStatusDisplay("400"));
        linksPage.clickLink("unauthorized");
        Assert.assertTrue(linksPage.isStatusDisplay("401"));
        linksPage.clickLink("forbidden");
        Assert.assertTrue(linksPage.isStatusDisplay("403"));
        linksPage.clickLink("invalid-url");
        Assert.assertTrue(linksPage.isStatusDisplay("404"));
    }
}