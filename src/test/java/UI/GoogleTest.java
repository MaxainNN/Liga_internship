package UI;

import base.BaseTest;
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
@Listeners(ChromeOnlyTransformer.class)
public class GoogleTest extends BaseTest {

    private GooglePage googlePage;

    @BeforeClass
    public void beforeClass(){
        googlePage = new GooglePage(driver);
    }

    @Test(description = "Тест Google с поиском по слову 'Наруто'")
    public void step_01(){
        googlePage.openGooglePage();
        googlePage.search("naruto");
        googlePage.clickAnimationButton();
        Assert.assertTrue(googlePage.isAttributeAdded());
        // For screenshot
        googlePage.waitForSeconds(3);
    }
}
