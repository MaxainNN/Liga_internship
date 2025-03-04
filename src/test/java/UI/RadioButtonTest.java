package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.secondPage.LeftPanel;
import pages.elements.RadioButtonPage;

/**
 * Тест на "Radio Button"
 * **/
public class RadioButtonTest extends BaseTest {
    private LeftPanel leftPanel;
    private RadioButtonPage radioButtonPage;

    @BeforeClass
    public void beforeClass() {
        leftPanel = new LeftPanel(driver);
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
