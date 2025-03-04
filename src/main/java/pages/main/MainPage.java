package pages.main;

import constant.CategoryCards;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.secondPage.SecondPage;

/**
 * Класс для главной страницы.
 * **/
public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Url-адрес при перехода на главную страницу
     * **/
    public static final String MAIN_PAGE = "https://demoqa.com/";
    /**
     * Локатор до баннера в верхней части страницы
     * **/
    public static final By HOME_BANNER = By.xpath("//div[@class='home-banner'][a[@href='https://www.toolsqa.com/selenium-training/'][img[contains(@src,'WB.svg')]]]");

    /**
     * Локаторы для взаимодействия с категориями
     * **/
    public static final  By CATEGORY_CARDS_XPATH = By.xpath("//h5[contains(text(),'')]");
    public static final String CATEGORY_CARD_XPATH = "//h5[text()='%s']";

    /**
     * Открыть главную страницу
     * **/
    public void openMainPage(){
        openUrl(MAIN_PAGE);
    }

    /**
     * Открыть категорию
     * @param nameCards - название категории
     * @return
     * **/
    public SecondPage openCategoryCards(CategoryCards nameCards){
        By locator = By.xpath(String.format(CATEGORY_CARD_XPATH,nameCards.getName()));
        click(locator);
        return new SecondPage(driver);
    }

    /**
     * Получить количество категорий
     * @return количество найденных категорий
     * **/
    public int getCategoryCount(){
        return getElementsCount(CATEGORY_CARDS_XPATH);
    }
}
