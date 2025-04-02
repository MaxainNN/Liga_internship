package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.secondPage.LeftPanel;
import pages.demoqa.elements.RadioButtonPage;

/**
 * Тест на "Radio Button"
 */
public class RadioButtonTest extends BaseTest {

    private RadioButtonPage radioButtonPage;

    @BeforeClass
    public void beforeClass() {
        radioButtonPage = new RadioButtonPage(driver);
    }

    @Test(description = "Перейти на страницу, отметить радиобаттон 'Yes'")
    public void step_01() {
        radioButtonPage.openRadioButtonPage();
        radioButtonPage.clickRadioButton("Yes");
        Assert.assertTrue(radioButtonPage.getStateRadioButton("Yes"));
    }

    @Test(description = "Перейти на страницу, отметить радиобаттон 'Impressive'")
    public void step_02() {
        radioButtonPage.openRadioButtonPage();
        radioButtonPage.clickRadioButton("Impressive");
        Assert.assertFalse(radioButtonPage.getStateRadioButton("Yes"));
        Assert.assertTrue(radioButtonPage.getStateRadioButton("Impressive"));
        Assert.assertFalse(radioButtonPage.radioButtonIsEnabled("No"));
    }
}
