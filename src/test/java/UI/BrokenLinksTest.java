package UI;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.elements.BrokenLinksPage;

import java.time.Duration;

/**
 * Тест на "Broken Links - Images"
 */
@Epic("DEMOQA")
@Feature("Broken links elements")
@Story("Тест broken links элементов")
public class BrokenLinksTest extends BaseTest {

    private BrokenLinksPage brokenLinks;

    @BeforeClass
    public void beforeClass() {
        brokenLinks = new BrokenLinksPage(driver);
    }

    @Test(description = "Перейти на страницу, дождаться , когда одно из изображений загрузиться")
    @Step("Ожидание загрузки изображения")
    public void step_01(){
        brokenLinks.openBrokenLinks();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d ->
                brokenLinks.isImageLoaded(brokenLinks.LOADED_IMAGE));
        Assert.assertTrue(brokenLinks.isImageLoaded(brokenLinks.LOADED_IMAGE));
        Assert.assertFalse(brokenLinks.isImageLoaded(brokenLinks.NOT_LOADED_IMAGE));
    }
}