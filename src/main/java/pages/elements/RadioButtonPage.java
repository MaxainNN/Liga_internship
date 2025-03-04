package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс для "Radio Button" элементов
 * **/
public class RadioButtonPage extends BasePage {
    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Url для страницы "Radio Button"
     * **/
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/radio-button";
    /**
     * Локатор до радио баттонов
     * **/
    public static final String RADIO_BUTTON_XPATH = "//input[@type='radio'][following-sibling::label[contains(., '%s')]]";
    public static final String RADIO_BUTTON_CLICK_XPATH = "//input[@type='radio']/following-sibling::label[contains(., '%s')]";

    /**
     * Перейти на страницу с "Radio Button"
     * **/
    public void openRadioButtonPage(){
        openUrl(URL_TEXT_BOX_PAGE);
    }

    /**
     * Радио баттон отмечен
     * @param radioButtonName название радиобаттона
     * @return true если отмечен
     * **/
    public boolean getStateRadioButton(String radioButtonName){
        return getRadioButtonState(By.xpath(String.format(RADIO_BUTTON_XPATH,radioButtonName)));
    }

    /**
     * Отметить радио баттон
     * @param radioButtonName название радиобаттона
     * **/
    public void clickRadioButton(String radioButtonName){
        setRadioButton(By.xpath(String.format(RADIO_BUTTON_CLICK_XPATH,radioButtonName)));
    }

    /**
     * Проверка - радио баттон доступен
     * @param radioButtonName название радиобаттона
     * @return true если доступен (не задисэйблен)
     * **/
    public boolean radioButtonIsEnabled(String radioButtonName){
        return isElementEnabled(By.xpath(String.format(RADIO_BUTTON_XPATH,radioButtonName)));
    }
}
