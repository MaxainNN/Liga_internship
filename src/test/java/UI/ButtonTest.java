package UI;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.elements.ButtonsPage;

import static pages.demoqa.elements.ButtonsPage.*;

/**
 * Тест на "Buttons"
 * Пример с исключенным тестом
 */
@Epic("DEMOQA")
@Feature("Buttons elements")
@Story("Тест Buttons элементов")
@Test(groups = {"broken"})
public class ButtonTest extends BaseTest {

    private ButtonsPage buttonsPage;

    @BeforeClass
    public void beforeClass(){
        buttonsPage = new ButtonsPage(driver);
    }

    @Test(description = "Открыть страницу, дважды нажать на кнопку 'Double Click Me'")
    @Step("Нажатие на кнопку 'Double Click Me'")
    public void step_01(){
        buttonsPage.openButtonsPage();
        buttonsPage.doubleClick(DOUBLE_CLICK_BTN);
        buttonsPage.waitForSeconds(10);
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
    }

    @Test(description = "Нажать правой кнопкой мыши на кнопку 'Right Click Me'")
    @Step("Нажатие на кнопку 'Right Click Me'")
    public void step_02(){
        buttonsPage.contextClick(RIGHT_CLICK_BTN);
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_RIGHT_CLICK));
    }

    @Test(description = "Нажать на кнопку 'Click Me'")
    @Step("Нажатие на кнопку 'Click Me'")
    public void step_03(){
        buttonsPage.buttonClick("Click Me");
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_RIGHT_CLICK));
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_CLICK));
    }
}