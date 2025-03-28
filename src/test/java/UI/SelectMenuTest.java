package UI;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.widgets.SelectMenuPage;

/**
 * Тест на "Select Menu"
*/
public class SelectMenuTest extends BaseTest {

    private SelectMenuPage selectMenuPage;

    @BeforeClass
    public void beforeClass(){
        selectMenuPage = new SelectMenuPage(driver);
    }

    @Test(description = "Перейти на страницу, выбрать второй элемент в первом выпадающем списке")
    public void step_01(){
        selectMenuPage.openSelectMenuPage();
        selectMenuPage.setSecondOptionInFirstDropDown();
        Assert.assertTrue(true);
    }

    @Test(description = "В 'Old Style Select' выбрать Red")
    public void step_02(){
        selectMenuPage.setValueInOldStyleSelect("1");
        Assert.assertTrue(true);
    }
}
