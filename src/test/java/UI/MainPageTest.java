package UI;

import base.BaseTest;
import constant.CategoryCards;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.main.MainPage;
import pages.demoqa.secondPage.LeftPanel;
import pages.demoqa.secondPage.SecondPage;
import pages.demoqa.elements.CheckBoxPage;

/**
 * Тест для главной страницы
 */
@Epic("DEMOQA")
@Feature("Main page actions")
@Story("Тест открытия вкладок с главной страницы")
public class MainPageTest extends BaseTest {

    private MainPage mainPage;
    private SecondPage secondPage;
    private LeftPanel leftPanel;
    private CheckBoxPage checkBoxPage;

    @BeforeClass
    public void beforeClass(){
        mainPage = new MainPage(driver);
        leftPanel = new LeftPanel(driver);
    }

    @Test(description = "Переход на главную страницу")
    @Step("Открытие главной страницы")
    public void step_01(){
        mainPage.openMainPage();
        Assert.assertTrue(mainPage.isElementDisplay(MainPage.HOME_BANNER));
        Assert.assertEquals(mainPage.getCategoryCount(),6);
    }

    @Test(description = "Открытие категории 'Elements'")
    @Step("Открытие категории 'Elements'")
    public void step_02(){
        secondPage = mainPage.openCategoryCards(CategoryCards.ELEMENTS);
        Assert.assertTrue(leftPanel.isLeftPanelDisplayed());
        Assert.assertTrue(leftPanel.isBlockOpen(CategoryCards.ELEMENTS));
    }

    @Test(description = "Выбор подкатегории 'Check Box'" +
            "Отмечание чек-бокса 'Home'")
    @Step("Выбор подкатегории 'Check Box' и отмечание чек-бокса 'Home'")
    public void step_03(){
        checkBoxPage = leftPanel.openCheckBoxPage();
        checkBoxPage.getCheckBoxState("Home");
        checkBoxPage.setCheckBox("Home",true);
        Assert.assertTrue(checkBoxPage.isMessageDisplayed());
    }
}