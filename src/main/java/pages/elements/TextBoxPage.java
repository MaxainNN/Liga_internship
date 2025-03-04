package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс для "Text Box" элементов
 * **/
public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Url для страницы с "Text Box" элементами
     * **/
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/text-box";
    /**
     * Локатор для полей с атрибутом - "placeholder" (Значения в полях установлено по умолчанию)
     * **/
    public static final String INPUT_XPATH = "//*[@placeholder='%s']";
    /**
     * Локатор до текстового поля "Permanent Address"
     * **/
    public static final String PERMANENT_ADDRESS = "//textarea[@id='permanentAddress']";
    /**
     * Локатор до кнокпки "Submit"
     * **/
    public static final String SUBMIT = "//button[@id='submit']";
    /**
     * Локатор до поля с выведенными значениями , после нажатия "Submit"
     * **/
    public static final String OUTPUT_XPATH = "//div[@id='output']//p[@id='%s']";

    /**
     * Placeholder для поля "Full name"
     * **/
    public static final String FULL_NAME = "Full Name";
    /**
     * Placeholder для поля "Email"
     * **/
    public static final String EMAIL = "name@example.com";
    /**
     * Placeholder для поля "Current Address"
     * **/
    public static final String CURRENT_ADDRESS = "Current Address";

    /**
     * Открыть страницу с элементами "Text Box"
     * **/
    public TextBoxPage openTextBoxPage(){
        openUrl(URL_TEXT_BOX_PAGE);
        return new TextBoxPage(driver);
    }

    /**
     * Внести значение в поле "Full name"
     * @param text текст
     * **/
    public void setFullName(String text) {
        String locator = String.format(INPUT_XPATH, FULL_NAME);
        sendKeys(By.xpath(locator), text);
    }

    /**
     * Внести значение в поле "Email"
     * @param email текст
     * **/
    public void setEmail(String email) {
        String locator = String.format(INPUT_XPATH, EMAIL);
        sendKeys(By.xpath(locator), email);
    }

    /**
     * Внести значение в поле "Current Address"
     * @param address текст
     * **/
    public void setCurrentAddress(String address) {
        String locator = String.format(INPUT_XPATH, CURRENT_ADDRESS);
        sendKeys(By.xpath(locator), address);
    }

    /**
     * Внести значение в поле "Permanent Address"
     * @param address текст
     * **/
    public void setPermanentAddress(String address) {
        sendKeys(By.xpath(PERMANENT_ADDRESS), address);
    }

    /**
     * Заполнить все поля значениями , нажать "Submit"
     * @param fullName текст для поля "Full Name"
     * @param email текст для поля "Email"
     * @param curAddr текст для поля "Current Address"
     * @param permAddr текст для поля "Permanent Address"
     * **/
    public void setAllFieldAndSubmit(String fullName, String email, String curAddr, String permAddr) {
        setFullName(fullName);
        setEmail(email);
        setCurrentAddress(curAddr);
        setPermanentAddress(permAddr);
        clickSubmit();
    }

    /**
     * Нажать на кнопку "Submit"
     * **/
    public void clickSubmit() {
        click(By.xpath(SUBMIT));
    }

    /**
     * Получить текст из поля с выведенными значенями для "Name"
     * @return текст из поля "Name"
     * **/
    public String getOutputName() {
        String locator = String.format(OUTPUT_XPATH, "name");
        return getText(By.xpath(locator));
    }

    /**
     * Получить текст из поля с выведенными значенями для "Email"
     * @return текст из поля "Email"
     * **/
    public String getOutputEmail() {
        String locator = String.format(OUTPUT_XPATH, "email");
        return getText(By.xpath(locator));
    }

    /**
     * Получить текст из поля с выведенными значенями для "Current Address"
     * @return текст из поля "Current Address"
     * **/
    public String getOutputCurAddr() {
        String locator = String.format(OUTPUT_XPATH, "currentAddress");
        return getText(By.xpath(locator));
    }

    /**
     * Получить текст из поля с выведенными значенями для "Permanent Address"
     * @return текст из поля "Permanent Address"
     * **/
    public String getOutputPermAddr() {
        String locator = String.format(OUTPUT_XPATH, "permanentAddress");
        return getText(By.xpath(locator));
    }
}
