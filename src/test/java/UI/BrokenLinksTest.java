package UI;

import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.elements.BrokenLinks;

import java.time.Duration;

/**
 * Тест на "Broken Links - Images"
*/
public class BrokenLinksTest extends BaseTest {
    private BrokenLinks brokenLinks;

    @BeforeClass
    public void beforeClass() {
        brokenLinks = new BrokenLinks(driver);
    }

    @Test(description = "Перейти на страницу, дождаться , когда одно из изображений загрузиться")
    public void step_01(){
        brokenLinks.openBrokenLinks();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(d -> brokenLinks.isImageLoaded(brokenLinks.LOADED_IMAGE));
        Assert.assertTrue(brokenLinks.isImageLoaded(brokenLinks.LOADED_IMAGE));
        Assert.assertFalse(brokenLinks.isImageLoaded(brokenLinks.NOT_LOADED_IMAGE));
    }
}
