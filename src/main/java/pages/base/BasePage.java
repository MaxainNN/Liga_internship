package pages.base;

import constant.LocatorsType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static browser.Config.EXPLICIT_WAIT;

/**
 * Базовый класс для страницы. Методы , описанные в этом классе будут доступны для наследников.
*/
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Локатор до картинки в шапке (header'е) страницы
     */
    public static final By HEADER_XPATH = By.xpath("//header/a[@href='https://demoqa.com'][img[@src='/images/Toolsqa.jpg']]");

    /**
     * Локаторы для взаимодействия с чек-боксами на странице "Check Box"
     */
    public static final String CHECK_BOX_INPUT_XPATH = "//input[@type='checkbox'][following-sibling::span[text()='%s']]";
    public static final String CHECK_BOX_XPATH = CHECK_BOX_INPUT_XPATH + "/following-sibling::span[@class='rct-checkbox']";

    /**
     * Локатор до названия страницы в средней части страницы
     */
    public static final By NAME_PAGE = By.xpath("//h1[@class='text-center']");

    /**
     * Локатор для взаимодействия с кнопками
     */
    public static final String BUTTON_XPATH = "//*[@type='button' and text()='%s']";

    /**
     * Перейти по url
     * @param url ссылка в формате строки
     */
    public void openUrl(String url) {
        driver.get(url);
    }

    /**
     * Найти элемент на странице
     * @param locator путь до элемента, тип - By
     * @return element
     */
    public WebElement findElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    /**
     * Найти элементЫ на странице
     * @param locator путь до элемента, тип - By
     * @return elements
     */
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Ожидание - Элемент видимый
     * @param locator путь до элемента, тип - By
     * @param second время ожидания в секундах
     */
    public void waitElementIsVisible(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(ExpectedConditions.visibilityOf(findElement(locator)));
    }

    /**
     * Ожидание - Элемент отображается
     * @param locator путь до элемента, тип - By
     * @param second время ожидания в секундах
     */
    public void waitElementIsDisplay(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(d -> isElementDisplay(locator));
    }

    /**
     * Ожидание - Элемент доступен
     * @param locator путь до элемента, тип - By
     * @param second время ожидания в секундах
     */
    public void waitForElementsEnabled(By locator, int second){
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(d -> isElementEnabled(locator));
    }

    /**
     * Ожидание - Элемент видимый c неявным ожиданием
     * @param locator путь до элемента, тип - By
     */
    public void waitElementIsVisible(By locator) {
        waitElementIsVisible(locator, EXPLICIT_WAIT);
    }

    /**
     * Кликнуть на элемент
     * @param locator путь до элемента, тип - By
     */
    public void click(By locator) {
        findElement(locator).click();
    }

    /**
     * Дважды кликнуть на элемент
     * @param locator путь до элемента, тип - By
     */
    public void doubleClick(By locator){
        Actions actions = new Actions(driver);
        actions.doubleClick(findElement(locator)).perform();
    }

    /**
     * Кликнуть на элементе правой кнопкой
     * @param locator путь до элемента, тип - By
     */
    public void contextClick(By locator){
        Actions actions = new Actions(driver);
        actions.contextClick(findElement(locator)).perform();
    }

    /**
     * Очистить поле
     * @param locator путь до элемента, тип - By
     * **/
    public void clear(By locator) {
        findElement(locator).clear();
    }

    /**
     * Внести значение в поле
     * @param locator путь до элемента, тип - By
     * @param text текст
     */
    public void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    /**
     * Очистить значение в поле , затем внести значение
     * @param locator путь до элемента, тип - By
     * @param text текст
     */
    public void sendKeysWithClear(By locator, String text){
        clear(locator);
        sendKeys(locator,text);
    }

    /**
     * Получить текст из элемента
     * @param locator путь до элемента, тип - By
     */
    public String getText(By locator) {
        return findElement(locator).getText();
    }

    /**
     * Проверка - Элемент отображается
     * @param locator путь до элемента, тип - By
     * @return true если отображается
     */
    public boolean isElementDisplay(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception ex){
            return false;
        }
    }

    /**
     * Проверка элемент доступен
     * @return true если доступен
     */
    public boolean isElementEnabled(By locator){
        return findElement(locator).isEnabled();
    }

    /**
     * Проверка - Header отображается
     * @return true если отображается
     */
    public boolean isHeaderDisplayed() {
        return isElementDisplay(HEADER_XPATH);
    }

    /**
     * Получить количество элементов
     * @param locator путь до элемента, тип - By
     * @return element's size
     */
    public int getElementsCount(By locator) {
        return findElements(locator).size();
    }

    /**
     * Получение статуса состояния чекбокса
     * @param checkBoxName путь до элемента, тип - String
     * @return true если отмечен
     */
    public boolean getCheckBoxState(String checkBoxName){
        return findElement(By.xpath(String.format(CHECK_BOX_INPUT_XPATH,checkBoxName))).isSelected();
    }
    /**
     * Переводит чек-бокс в нужное состочние
     * @param checkBoxName - Название чек-бокса
     * @param state - нужное состочние, true если чек-бокс должен быть активным, false - если нет
     */
    public void setCheckBox(String checkBoxName, boolean state){
        //String locator = String.format(CHECK_BOX_XPATH, checkBoxName) + "/following-sibling::span[@class='rct-checkbox']";
        if (!getCheckBoxState(checkBoxName) == state){
            click(By.xpath(String.format(CHECK_BOX_XPATH,checkBoxName)));
        }
    }

    /**
     * Получение статуса состояния радиобаттона
     * @param locator путь до элемента, тип - By
     * @return true если отмечен
     */
    public boolean getRadioButtonState(By locator){
        return findElement(locator).isSelected();
    }

    /**
     * Отметить радио-баттон
     * @param locator путь до элемента, тип - By
     */
    public void setRadioButton (By locator){
        click(locator);
    }

    /**
     * Метод для построения локатора исходя из типа локатора, содержимого
     * @param textLocator текст, необходимый для построения
     * @param locatorsType тип локатора
     */
    public By locatorBuild(String textLocator, LocatorsType locatorsType) {
        By locator = null;
        switch (locatorsType) {
            case ID:
                locator = By.id(textLocator);
                break;
            case XPATH:
                locator = By.xpath(textLocator);
                break;
            case CSS:
                locator = By.cssSelector(textLocator);
                break;
            case NAME:
                locator = By.name(textLocator);
                break;
            case TAG_NAME:
                locator = By.tagName(textLocator);
                break;
            case CLASS_NAME:
                locator = By.className(textLocator);
            default:
                System.out.println("Некорректный вид селектора: " + locatorsType);
        }
        return locator;
    }

    /**
     * Метод вызывающий AssertionError
     */
    public void failure() {
        throw new AssertionError();
    }

    /**
     * Получить имя страницы
     * @return имя текущей страницы
     */
    public String getPageName(){
        return getText(NAME_PAGE);
    }

    /**
     * Нажать на кнопку
     * @param buttonName название кнопки
     */
    public void buttonClick(String buttonName){
        click(By.xpath(String.format(BUTTON_XPATH,buttonName)));
    }

    /**
     * Получить значение атрибута CSS элемента
     * @param locator путь до элемента, тип - By
     * @param attribute название атрибута
     * @return значение найденного атрибута
     */
    public String getAttributeValue(By locator, String attribute){
        return findElement(locator).getCssValue(attribute);
    }

    /**
     * Ожидание загрузки страницы
     * Проверка document.readyState = complete
     * @param driver - инстанс драйвера, который управляет браузером
     * @param timeoutInSeconds - количество секунд
     * @throws org.openqa.selenium.TimeoutException - если условие не выполнено
     */
    public void waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(timeoutInSeconds));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> pageLoadCondition = driver1 ->
                jsExecutor.executeScript
                        ("return document.readyState").toString().equals
                        ("complete");
        wait.until(pageLoadCondition);
    }

    /**
     * Ожидание в секундах (через sleep)
     * @param seconds - количество секунд
     */
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
