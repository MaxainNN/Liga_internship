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
import pages.demoqa.elements.CheckBoxPage;

/**
 * Тест на "Check Box"
 */
@Epic("DEMOQA")
@Feature("Check Box elements")
@Story("Тест Check Box элементов")
public class CheckBoxTest extends BaseTest {

    private CheckBoxPage checkBoxPage;

    @BeforeClass
    public void beforeClass(){
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test(description = "Перейти на страницу")
    @Step("Открытие страницы")
    public void step_01(){
        checkBoxPage.openCheckBoxPage();
        Assert.assertEquals(checkBoxPage.getPageName(), Item.CHECK_BOX.getName());
    }

    @Test(description = "Развернуть чекбосы 'Home', отметить чекбокс 'Desktop'")
    @Step("Отмечание чекбоксов 'Home', 'Desktop'")
    public void step_02(){
        checkBoxPage.openListCheckBox("Home");
        checkBoxPage.setCheckBox("Desktop",true);
        Assert.assertTrue(checkBoxPage.getCheckBoxState("Desktop"));
    }
}