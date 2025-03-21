package pages.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;
import java.util.ArrayList;

/**
 * Класс для "Links" элементов
 * **/
public class LinksPage extends BasePage {
    public LinksPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Url для страницы "Links"
     * **/
    public static final String LINKS_PAGE_URL = "https://demoqa.com/links";
    /**
     * Локатор до ссылки "Home"
     * **/
    public static final By HOME_LINK = By.xpath("//a[text()='Home']");
    /**
     * Локатор до динамической ссылки
     * **/
    public static final By HOME_LINK_1 = By.xpath("//a[@id='dynamicLink']");
    /**
     * Локатор до изображения на главной старнице
     * **/
    public static final By BANNER_XPATH = By.xpath("//img[@class='banner-image']");
    /**
     * Локатор до строки со статус кодом
     * **/
    public static final String STATUS_XPATH = "//b[text()='%s']";
    /**
     * Локатор до ссылки с вызовом метода
     * **/
    public static final String NAME_XPATH = "//a[@id='%s']";
    public ArrayList<String> tabs;

    /**
     * Проверка - баннер "Selenium" отобразился
     * **/
    public boolean isBannerDisplay(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(d -> isElementDisplay(BANNER_XPATH));
        return isElementDisplay(BANNER_XPATH);
    }

    /**
     * Перейти на страницу с "Links"
     * **/
    public void openLinksPage(){
        openUrl(LINKS_PAGE_URL);
    }

    /**
     * Установить список вкладок браузера
     * **/
    public void set_tabs(WebDriver driver){
        tabs = new ArrayList<String> (driver.getWindowHandles());;
    }

    /**
     * Перейти по ссылке с названием
     * @param name - название ссылки
     * **/
    public void clickLink(String name){
        click(By.xpath(String.format(NAME_XPATH, name)));
    }

    /**
     * Проверка - после перехода по ссылке вызван метод со статусом
     * @param status стастус код
     * @return true если возвращается передаваемый статус код
     * **/
    public boolean isStatusDisplay(String status){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(d -> isElementDisplay(By.xpath(String.format(STATUS_XPATH, status))));
        return isElementDisplay(By.xpath(String.format(STATUS_XPATH, status)));
    }
}
