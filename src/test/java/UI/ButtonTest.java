package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.elements.ButtonsPage;

import static pages.elements.ButtonsPage.*;

/**
 * Тест на "Buttons"
 * **/
public class ButtonTest extends BaseTest {
    private ButtonsPage buttonsPage;

    @BeforeClass
    public void beforeClass(){
        buttonsPage = new ButtonsPage(driver);
    }

    @Test(description = "Открыть страницу, дважды нажать на кнопку 'Double Click Me'")
    public void step_01(){
        buttonsPage.openButtonsPage();
        buttonsPage.doubleClick(DOUBLE_CLICK_BTN);
        buttonsPage.waitForSeconds(6);
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
    }

    @Test(description = "Нажать правой кнопкой мыши на кнопку 'Right Click Me'")
    public void step_02(){
        buttonsPage.contextClick(RIGHT_CLICK_BTN);
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_RIGHT_CLICK));
    }

    @Test(description = "Нажать на кнопку 'Click Me'")
    public void step_03(){
        buttonsPage.buttonClick("Click Me");
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_RIGHT_CLICK));
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_CLICK));
    }
}
