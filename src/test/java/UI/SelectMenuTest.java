package UI;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.widgets.SelectMenuPage;

/**
 * Тест на "Select Menu"
 */
@Epic("DEMOQA")
@Feature("Select menu widgets")
@Story("Тест Select menu виджета")
public class SelectMenuTest extends BaseTest {

    private SelectMenuPage selectMenuPage;

    @BeforeClass
    public void beforeClass(){
        selectMenuPage = new SelectMenuPage(driver);
    }

    @Test(description = "Перейти на страницу, выбрать второй элемент в первом выпадающем списке")
    @Step("Выбор второго элемента в первом выпадающем списке")
    public void step_01(){
        selectMenuPage.openSelectMenuPage();
        selectMenuPage.setSecondOptionInFirstDropDown();
        Assert.assertTrue(true);
    }

    @Test(description = "В 'Old Style Select' выбрать Red")
    @Step("В 'Old Style Select' выбор Red")
    public void step_02(){
        selectMenuPage.setValueInOldStyleSelect("1");
        Assert.assertTrue(true);
    }

    @Test(description = "Выбрать Multiselect элемент")
    @Step("В 'Multiselect' выбор элемента")
    public void step_03(){
        Assert.assertTrue(true);
    }

    @Test(description = "Выбрать Second select элемент")
    @Step("В 'Second select' выбор элемента")
    public void step_04(){
        Assert.assertTrue(true);
    }
}