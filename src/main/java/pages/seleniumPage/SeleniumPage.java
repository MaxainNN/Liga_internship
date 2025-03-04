package pages.seleniumPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс до формы "Web form" на "Selenium.dev"
 * **/
public class SeleniumPage extends BasePage {
    public SeleniumPage(WebDriver driver) {
        super(driver);
    }

    public static final String SELENIUM_PAGE_URL = "https://www.selenium.dev/selenium/web/web-form.html";
    public static final By TEXT_INPUT_XPATH = By.xpath("//input[@name='my-text']");
    public static final By TEXT_AREA_XPATH = By.xpath("//textarea[@name='my-textarea']");
    public static final By PASSWORD_XPATH = By.xpath("//input[@name='my-password']");
    public static final By SELECT_XPATH = By.xpath("//select[@name='my-select']");
    public static final String OPTIONS_XPATH = "//option[text()='%s']";
    public static final By DATALIST_PATH = By.xpath("//input[@list='my-options']");
    public static final String DATALIST_OPTION = "//option[@value='%s']";
    public static final String CHECKBOX_PATH = "//input[@id='my-check-%s']";
    public static final String RADIO_PATH = "//input[@id='my-radio-%s']";
    public static final By SUBMIT_BUTTON = By.xpath("//button[text()='Submit']");
    public static final By SUBMIT_MESSAGE = By.xpath("//h1[text()='Form submitted']");
    public static final By SUBMIT_MESSAGE_1 = By.xpath("//p[text()='Received!']");
    public static final By DATE_PATH = By.xpath("//input[@name='my-date']");
    public static final By COLOR_PATH = By.xpath("//input[@name='my-colors']");
    public static final By SLIDER_PATH = By.xpath("//input[@name='my-range']");

    private JavascriptExecutor js = (JavascriptExecutor) driver;

    public void openSeleniumPage() {
        openUrl(SELENIUM_PAGE_URL);
    }

    public boolean selectDropdownOption(String option) {
        click(SELECT_XPATH);
        click(By.xpath(String.format(OPTIONS_XPATH, option)));
        String some = js.executeScript("return arguments[0].options[arguments[0].selectedIndex].text", findElement(SELECT_XPATH)).toString();
        return some.equals(option);
    }

    public boolean selectDatalistOption(String option) {
        sendKeys(DATALIST_PATH, option);
        String some = js.executeScript("return arguments[0].value", findElement(DATALIST_PATH)).toString();
        return some.equals(option);
    }

    public boolean checkboxState(String number){
        return findElement(By.xpath(String.format(CHECKBOX_PATH, number))).isSelected();
    }

    public void setCheckbox(String number, boolean state){
        if(checkboxState(number) != state){
            click(By.xpath(String.format(CHECKBOX_PATH, number)));
        }
    }

    public boolean radioState(String number){
        return findElement(By.xpath(String.format(RADIO_PATH, number))).isSelected();
    }

    public void setRadio(String number){
        if(radioState(number) != true){
            click(By.xpath(String.format(RADIO_PATH, number)));
        }
    }

    public boolean setAndDisplayText(String text, By locator) {
        sendKeys(locator, text);
        String some = js.executeScript("return arguments[0].value", findElement(locator)).toString();
        return some.equals(text);
    }

    public boolean setDate(String date){
        sendKeys(DATE_PATH, date);
        findElement(DATE_PATH).sendKeys(Keys.ENTER);
        String some = js.executeScript("return arguments[0].value", findElement(DATE_PATH)).toString();
        return some.equals(date);
    }

    public boolean setColor(String color){
        sendKeys(COLOR_PATH, color);
        String some = js.executeScript("return arguments[0].value", findElement(COLOR_PATH)).toString();
        return some.equals(color);
    }

    public boolean setSlider(int value){
        for (int i=5; i<value; i++){
            findElement(SLIDER_PATH).sendKeys(Keys.RIGHT);
        }
        String some = js.executeScript("return arguments[0].value", findElement(SLIDER_PATH)).toString();
        return some.equals(String.valueOf(value));
    }

    public boolean submit(){
        click(SUBMIT_BUTTON);
        return isElementDisplay(SUBMIT_MESSAGE) && isElementDisplay(SUBMIT_MESSAGE_1);
    }
}
