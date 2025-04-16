package UI;

import base.BaseTest;
import constant.Item;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.elements.DynamicPropertiesPage;

import static pages.demoqa.elements.DynamicPropertiesPage.*;
import static pages.demoqa.elements.DynamicPropertiesPage.BTN_ENABLE_AFTER;

/**
 * Тест на "Dynamic Properties"
 */
@Epic("DEMOQA")
@Feature("Dynamic properties elements")
@Story("Тест Dynamic properties элементов")
public class DynamicPropertiesTest extends BaseTest {

    private DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeClass
    public void beforeClass(){
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }

    @Test(description = "Перейти на страницу")
    @Step("Открытие страницы")
    public void step_01(){
        dynamicPropertiesPage.openDynamicPage();
        Assert.assertEquals(dynamicPropertiesPage.getPageName(), Item.DYNAMIC_PROPERTIES.getName());
    }

    @Test(description = "Получить цвет кнопки 'Change Color', ожидать изменение цвета")
    @Step("Ожидание изменение цвета кнопки")
    public void step_02(){
        String initialColor = dynamicPropertiesPage.getColorBtn(BTN_COLOR_CHANGE);
        System.out.println("[INFO] Initial color: " + initialColor);
        dynamicPropertiesPage.waitForColorChange();
        String afterChangeColor = dynamicPropertiesPage.getColorBtn(BTN_COLOR_CHANGE);
        System.out.println("[INFO] Color after change" + afterChangeColor);
        Assert.assertNotSame(initialColor, afterChangeColor);
    }

    @Test(description = "Обновить страницу, ожидать когда отобразиться кнопка 'Visible After 5 seconds'")
    @Step("Ожидание отображения кнопки")
    public void step_03(){
        driver.navigate().refresh();
        dynamicPropertiesPage.waitElementIsDisplay(BTN_VISIBLE_AFTER,10);
    }

    @Test(description = "Обновить страницу, ожидать когда кнопка 'Will enable 5 seconds' станет доступна")
    @Step("Ожидание доступности кнопки")
    public void step_04(){
        driver.navigate().refresh();
        dynamicPropertiesPage.waitForElementsEnabled(BTN_ENABLE_AFTER,10);
        Assert.assertTrue(dynamicPropertiesPage.isElementEnabled(BTN_ENABLE_AFTER));
    }
}