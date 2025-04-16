package UI;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.google.GooglePage;
import utils.ChromeOnlyTransformer;

/**
 * Тест на страницу поиска "Google"
 * Тест запускается только в Chrome браузере
 */
@Epic("GOOGLE")
@Feature("Google search")
@Story("Тест поиска Google")
@Listeners(ChromeOnlyTransformer.class)
public class GoogleTest extends BaseTest {

    private GooglePage googlePage;

    @BeforeClass
    public void beforeClass(){
        googlePage = new GooglePage(driver);
    }

    @Test(description = "Тест Google с поиском по слову 'Наруто'")
    @Step("Ввод в поисковую строку слова - 'naruto', поиск, нажатие на кнопку с анимацией")
    public void step_01(){
        googlePage.openGooglePage();
        googlePage.search("naruto");
        googlePage.clickAnimationButton();
        Assert.assertTrue(googlePage.isAttributeAdded());
        // For screenshot
        googlePage.waitForSeconds(3);
    }
}