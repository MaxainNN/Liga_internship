package UI;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.elements.DynamicPropertiesPage;

/**
 * Тест на "Select Menu"
 * **/
public class SelectMenuTest extends BaseTest {
    private DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeClass
    public void beforeClass(){
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }

    @Test(description = "Перейти на страницу, ")
    public void step_1(){
        dynamicPropertiesPage.openUrl("https://demoqa.com/select-menu");
        /*Select select = new Select(dynamicPropertiesPage.findElement(By.id("oldSelectMenu")));
        select.selectByVisibleText("Green");
        select.getFirstSelectedOption().getText();
        //String defaultItem = option.getText();*/
        String textItem = "Group 1, option 2";
        dynamicPropertiesPage.sendKeys(By.id("react-select-2-input"),textItem);
        dynamicPropertiesPage.waitElementIsDisplay(By.xpath("//div[normalize-space(@class)='css-26l3qy-menu']"),5);
        dynamicPropertiesPage.click(By.xpath("//div[normalize-space(@class)='css-26l3qy-menu']//div[text()='"+ textItem +"']"));
    }
}
