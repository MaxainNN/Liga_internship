package pages.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс для "Broken Links - Images" элементов
 * **/
public class BrokenLinks extends BasePage {
    public BrokenLinks(WebDriver driver) {
        super(driver);
    }

    /**
     * Url до страницы с "Broken Links - Images" элементами
     * **/
    private static final String BROKEN_LINKS_URL = "https://demoqa.com/broken";
    /**
     * Локатор ло изображения "Valid image"
     * **/
    public static final By LOADED_IMAGE = By.xpath("//img[@src='/images/Toolsqa.jpg']");
    /**
     * Докатор до изображения , которое не загрузилось (Broken image)
     * **/
    public static final By NOT_LOADED_IMAGE = By.xpath("//img[@src='/images/Toolsqa_1.jpg']");

    /**
     * Открыть страницу с "Broken Links - Images"
     * **/
    public void openBrokenLinks() {
        openUrl(BROKEN_LINKS_URL);
    }

    /**
     * Проверка - изображение загрузилось
     * @param locator пусть до элемента
     * @return true если загрузилось
     * **/
    public boolean isImageLoaded(By locator){
        return (Boolean) ((JavascriptExecutor)driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != " +
                        "'undefined' && arguments[0].naturalWidth > 0", findElement(locator));
    }
}
