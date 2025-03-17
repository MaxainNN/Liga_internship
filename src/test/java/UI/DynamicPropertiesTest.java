package UI;

import base.BaseTest;
import constant.Item;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.elements.DynamicPropertiesPage;

import static pages.elements.DynamicPropertiesPage.*;
import static pages.elements.DynamicPropertiesPage.BTN_ENABLE_AFTER;

/**
 * Тест на "Dynamic Properties"
*/
public class DynamicPropertiesTest extends BaseTest {

    private DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeClass
    public void beforeClass(){
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }

    @Test(description = "Перейти на страницу")
    public void step_1(){
        dynamicPropertiesPage.openDynamicPage();
        Assert.assertEquals(dynamicPropertiesPage.getPageName(), Item.DYNAMIC_PROPERTIES.getName());
    }

    @Test(description = "Получить цвет кнопки 'Change Color', ожидать изменение цвета")
    public void step_2(){
        String initialColor = dynamicPropertiesPage.getColorBtn(BTN_COLOR_CHANGE);
        System.out.println(initialColor);
        dynamicPropertiesPage.waitForColorChange();
        String afterChangeColor = dynamicPropertiesPage.getColorBtn(BTN_COLOR_CHANGE);
        System.out.println(afterChangeColor);
        Assert.assertNotSame(initialColor, afterChangeColor);
    }

    @Test(description = "Обновить страницу, ожидать когда отобразиться кнопка 'Visible After 5 seconds'")
    public void step_3(){
        driver.navigate().refresh();
        //dynamicPropertiesPage.click(BTN_VISIBLE_AFTER);
        dynamicPropertiesPage.waitElementIsDisplay(BTN_VISIBLE_AFTER,10);
    }

    @Test(description = "Обновить страницу, ожидать когда кнопка 'Will enable 5 seconds' станет доступна")
    public void step_4(){
        driver.navigate().refresh();
        //dynamicPropertiesPage.click(BTN_VISIBLE_AFTER);
        //Assert.assertTrue(dynamicPropertiesPage.isElementEnabled(BTN_ENABLE_AFTER));
        dynamicPropertiesPage.waitForElementsEnabled(BTN_ENABLE_AFTER,10);
        Assert.assertTrue(dynamicPropertiesPage.isElementEnabled(BTN_ENABLE_AFTER));
    }
}
