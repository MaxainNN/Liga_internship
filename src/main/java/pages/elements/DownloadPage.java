package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.io.File;
import java.time.Duration;

/**
 * Класс для "Upload and Download" элементов
 * **/
public class DownloadPage extends BasePage {
    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Url до страницы с "Upload and Download" элементами
     * **/
    public static final String DOWNLOAD_PAGE_URL = "https://demoqa.com/upload-download";
    /**
     * Локатор до кнопки "Download"
     * **/
    public static final By DOWNLOAD_BUTTON_XPATH = By.xpath("//a[@id='downloadButton']");
    /**
     * Локатор до кнопки "Choose file" (Upload)
     * **/
    public static final By UPLOAD_BUTTON_XPATH = By.xpath("//*[@id='uploadFile']");
    /**
     * Локатор до сообщения с путем загруженного файла
     * **/
    public static final By SUCCESSFUL_UPLOAD_MESSAGE_XPATH = By.xpath("//p[@id='uploadedFilePath']");

    /**
     * Открыть страницу с "Upload and Download"
     * **/
    public void openDownloadPage(){
        openUrl(DOWNLOAD_PAGE_URL);
    }

    /**
     * Проверка - сообщение с путем отобразилось
     * @return true если отобразилось
     * **/
    public boolean isMessageDisplayed() {
        return isElementDisplay(SUCCESSFUL_UPLOAD_MESSAGE_XPATH);
    }

    /**
     * Загрузить файл
     * @param filePath - путь до файла
     * **/
    public void uploadFile(String filePath){
        sendKeys(UPLOAD_BUTTON_XPATH, filePath);
    }

    /**
     * Нажать на кнопку "Download"
     * **/
    public void downloadFile(){
        click(DOWNLOAD_BUTTON_XPATH);
    }

    /**
     * Проверка - файл загрузился
     * @param filePath путь до файла
     * @return true если файл существует по указанному пути
     * **/
    public boolean isFileDownloaded(String filePath){
        File downloadedFile = new File(filePath);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> downloadedFile.exists());
        return downloadedFile.exists();
    }
}
