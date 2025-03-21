package pages.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс для "Check Box" элементов
 * **/
public class CheckBoxPage extends BasePage {
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локатор до страницы с "Check Box" элементами
     * **/
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/checkbox";
    /**
     * Локатор до кнопки "Свернуть/развернуть"
     * **/
    public static final String BUTTON_TOGGLE = CHECK_BOX_INPUT_XPATH + "/../preceding-sibling::button[@title='Toggle']";
    /**
     * Локатор для проверки , что строки свернуты/развернуты
     * **/
    public static final String LIST_CHECKBOX_XPATH = CHECK_BOX_INPUT_XPATH + "/ancestor::li[contains(@class,'%s')]";
    /**
     * Строки развернуты
     * **/
    public static final String LIST_CHECKBOX_OPEN = "expanded";
    /**
     * Строки свернуты
     * **/
    public static final String LIST_CHECKBOX_CLOSED = "collapsed";


    /**
     * Открыть страницу с элементами "Check Box"
     * **/
    public void openCheckBoxPage(){
        openUrl(URL_TEXT_BOX_PAGE);
    }

    /**
     * Метод открытия списка чек-боксов нажатием на toggle рядом с чек-боксом для открытия списка
     * @param checkBoxName - название чек-бокса
     */
    public void openListCheckBox(String checkBoxName){
        if (!isCheckBoxDisplay(checkBoxName)){
            failure();
        }
        if (isListCheckBoxClosed(checkBoxName)){
            click(By.xpath(String.format(BUTTON_TOGGLE,checkBoxName)));
        }
    }

    /**
     * Метод открытия списка чек-боксов нажатием на toggle рядом с чек-боксом для открытия списка
     * @param checkBoxName - название чек-бокса
     */
    public void closeListCheckBox(String checkBoxName){
        if (!isCheckBoxDisplay(checkBoxName)){
            failure();
        }
        if (isListCheckBoxOpen(checkBoxName)){
            click(By.xpath(String.format(BUTTON_TOGGLE,checkBoxName)));
        }
    }


    /**
     * Проверка отображения чек-бокса на форме
     * @param checkBoxName название чек-бокса
     * @return true если отображается
     */
    public boolean isCheckBoxDisplay(String checkBoxName){
        return isElementDisplay(By.xpath(String.format(CHECK_BOX_XPATH,checkBoxName)));
    }

    /**
     * Проверка отображения списка чек-боксов под конкретным чек-боксом
     * @param checkBoxName название чек-бокса
     * @return true если отображается
     */
    public boolean isListCheckBoxOpen(String checkBoxName){
        return isElementDisplay(By.xpath(String.format(LIST_CHECKBOX_XPATH,checkBoxName,LIST_CHECKBOX_OPEN)));
    }

    /**
     * Проверка , что не отображаются внутренние чекбоксы
     * @param checkBoxName название чек-бокса
     * @return true если не отображается
     * **/
    public boolean isListCheckBoxClosed(String checkBoxName){
        return isElementDisplay(By.xpath(String.format(LIST_CHECKBOX_XPATH,checkBoxName,LIST_CHECKBOX_CLOSED)));
    }
}
