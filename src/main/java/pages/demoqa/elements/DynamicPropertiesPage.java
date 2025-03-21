package pages.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

/**
 * Класс для "Dynamic Properties" элементов
 * **/
public class DynamicPropertiesPage extends BasePage {
    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Url до страницы "Dynamic Properties"
     * **/
    public static final String URL_DYNAMIC_PAGE = "https://demoqa.com/dynamic-properties";
    /**
     * Локатор до кнопки "Will enable 5 seconds"
     * **/
    public static final By BTN_ENABLE_AFTER = By.id("enableAfter");
    /**
     * Локатор до кнопки "Color Change"
     * **/
    public static final By BTN_COLOR_CHANGE = By.id("colorChange");
    /**
     * Локатор до кнопки "Visible After 5 seconds"
     * **/
    public static final By BTN_VISIBLE_AFTER = By.id("visibleAfter");

    /**
     * Перейти на страницу с "Dynamic Properties"
     * **/
    public void openDynamicPage(){
        openUrl(URL_DYNAMIC_PAGE);
    }

    /**
     * Нажать на кнопку "Will enable 5 seconds" через 6 секунд
     * **/
    public void clickBtnEnableAfter(){
        waitForElementsEnabled(BTN_ENABLE_AFTER,6);
        click(BTN_ENABLE_AFTER);
    }

    /**
     * Нажать на кнопку "Visible After 5 seconds" через 6 секунд
     * **/
    public void clickBtnVisibleAfter(){
        waitElementIsVisible(BTN_VISIBLE_AFTER,6);
        click(BTN_VISIBLE_AFTER);
    }

    /**
     * Ожидание изменения цвета через 6 секунд
     * **/
    public void waitForColorChange(){
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(d -> isColorChange(BTN_COLOR_CHANGE,"rgba(220, 53, 69, 1)"));
    }

    /**
     * Получить атрибут "color" (Цвет)
     * @param xpathBtn путь до кнопки
     * @return значения атрибута color
     * **/
    public String getColorBtn(By xpathBtn){
        return getAttributeValue(xpathBtn,"color");
    }

    /**
     * Проверка - цвет изменен
     * @param xpathBtn путь до кнопки
     * @param color цвет
     * @return true если изменен
     * **/
    public boolean isColorChange(By xpathBtn,String color){
        return getColorBtn(xpathBtn).equals(color);
    }
}
