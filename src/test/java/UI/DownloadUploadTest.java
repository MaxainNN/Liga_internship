package UI;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.elements.DownloadPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static browser.Path.*;

/**
 * Тест на "Upload and Download"
 */
@Epic("DEMOQA")
@Feature("Upload and Download elements")
@Story("Тест Upload and Download элементов")
public class DownloadUploadTest extends BaseTest {

    private DownloadPage downloadPage;

    @BeforeClass
    public void beforeClass(){
        downloadPage = new DownloadPage(driver);
    }

    @AfterTest
    @Step("Удаление загруженного файла")
    public void afterTest(){
        /**
         * После выполения теста папка с загрузками очищается
         */
        Path path = Paths.get(DOWNLOAD_DIR + "sampleFile.jpeg");
        try {
            Files.delete(path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Перейти на главную страницу, загрузить файл из 'testFiles'")
    @Step("Загрузка файла из папки 'testFiles'")
    public void step_01(){
        downloadPage.openDownloadPage();
        downloadPage.uploadFile(TEST_FILES_PATH + "funny_cat.jpg");
        Assert.assertTrue(downloadPage.isMessageDisplayed());
    }

    @Test(description = "Нажать на 'Download'")
    @Step("Скачивание файла")
    public void step_02(){
        downloadPage.downloadFile();
        Assert.assertTrue(downloadPage.isFileDownloaded(DOWNLOAD_DIR + "sampleFile.jpeg"));
    }
}