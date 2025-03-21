package UI;

import base.BaseTest;
import constant.CategoryCards;
import constant.Item;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.main.MainPage;
import pages.demoqa.secondPage.LeftPanel;
import pages.demoqa.secondPage.SecondPage;
import pages.demoqa.elements.TextBoxPage;

/**
 * Тест на "Text Box"
*/
public class TextBox extends BaseTest {
    private MainPage mainPage;
    private TextBoxPage textBoxPage;
    private SecondPage secondPage;
    private LeftPanel leftPanel;

    private String fullName = "Kalugin Maxim";
    private String email = "test@test.ru";
    private String curAddr = "Курск";
    private String permAddr = "Москва";

    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(driver);
        leftPanel = new LeftPanel(driver);
    }

    @Test(description = "Перейти на главную страницу, Нажать на 'Elements', Нажать на 'Text Box'")
    public void step_01() {
        mainPage.openMainPage();
        secondPage = mainPage.openCategoryCards(CategoryCards.ELEMENTS);
        Assert.assertTrue(leftPanel.isLeftPanelDisplayed());
        Assert.assertTrue(leftPanel.isBlockOpen(CategoryCards.ELEMENTS));
        textBoxPage = leftPanel.openTextBoxPage();
        Assert.assertEquals(textBoxPage.getPageName(), Item.TEXT_BOX.getName());
    }

    @Test(description = "Заполнить поля на странице значениями, нажать 'Submit'")
    public void step_02() {
        textBoxPage.setFullName(fullName);
        textBoxPage.setEmail(email);
        textBoxPage.setCurrentAddress(curAddr);
        textBoxPage.setPermanentAddress(permAddr);
        textBoxPage.clickSubmit();
        // Можно использовать метод ниже
        //textBoxPage.setAllFieldAndSubmit(fullName,email,curAddr,permAddr);
        Assert.assertEquals(textBoxPage.getOutputName(), "Name:" + fullName);
        Assert.assertEquals(textBoxPage.getOutputEmail(), "Email:" + email);
        Assert.assertEquals(textBoxPage.getOutputCurAddr(), "Current Address :" + curAddr);
        Assert.assertEquals(textBoxPage.getOutputPermAddr(), "Permananet Address :" + permAddr);
    }
}
