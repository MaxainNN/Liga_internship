package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.google.GooglePage;

/**
 * Тест на страницу поиска "Google"
*/
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
        Assert.assertTrue(googlePage.isCaptchaAppeared());
        //googlePage.clickAnimationButton();
        //Assert.assertTrue(googlePage.isAttributeAdded());
        // For screenshot
        //googlePage.waitForSeconds(3);
    }
}
