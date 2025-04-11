package UI;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("UI: Sanity")
@Feature("Главная страница testengineer.ru")
@Story("Тесты на https://testengineer.ru/")
public class AllureReportTest extends BaseTest {

    @Test(description = "Открыть главную страницу сайта")
    @Description("Открыть главную страницу сайта")
    @Severity(CRITICAL)
    @Owner("Максим Калугин")
    public void step_01(){
        driver.get("https://testengineer.ru/");
        Assert.assertTrue(true);
    }
}
