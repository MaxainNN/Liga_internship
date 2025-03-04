package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.seleniumPage.SeleniumPage;

/**
 * Тест для "Selenium Web Form"
 * **/
public class SeleniumPageTest extends BaseTest {
    private SeleniumPage seleniumPage;

    @BeforeClass
    public void beforeClass() {
        seleniumPage = new SeleniumPage(driver);
    }

    @Test
    public void step_01(){
        seleniumPage.openSeleniumPage();
        Assert.assertTrue(seleniumPage.setAndDisplayText("Калугин Максим Сергеевич", seleniumPage.TEXT_INPUT_XPATH));
        Assert.assertTrue(seleniumPage.setAndDisplayText("Калугин Максим Сергеевич", seleniumPage.TEXT_AREA_XPATH));
        Assert.assertTrue(seleniumPage.setAndDisplayText("qwerty1234", seleniumPage.PASSWORD_XPATH));
    }

    @Test
    public void step_02(){
        Assert.assertTrue(seleniumPage.selectDropdownOption("Two"));
        Assert.assertTrue(seleniumPage.selectDatalistOption("Seattle"));
    }

    @Test
    public void step_03(){
        seleniumPage.setCheckbox("1", true);
        seleniumPage.setCheckbox("2", true);
        Assert.assertTrue(seleniumPage.checkboxState("1"));
        Assert.assertTrue(seleniumPage.checkboxState("2"));
        seleniumPage.setRadio("2");
        Assert.assertTrue(seleniumPage.radioState("2"));
        Assert.assertFalse(seleniumPage.radioState("1"));
    }

    @Test
    public void step_04(){
        Assert.assertTrue(seleniumPage.setDate("11/09/2022"));
    }

    @Test
    public void step_05(){
        Assert.assertTrue(seleniumPage.setColor("#ffffff"));
    }

    @Test
    public void step_06(){
        Assert.assertTrue(seleniumPage.setSlider(10));
    }

    @Test
    public void step_07(){
        Assert.assertTrue(seleniumPage.submit());
    }
}
