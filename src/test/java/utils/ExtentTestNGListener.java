package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static browser.Path.SCREENSHOT_DIR;

/**
 * Кастомный листенер для генерации отчета
 * **/
public class ExtentTestNGListener implements ITestListener {

    private ExtentReports extent = new ExtentReports();
    private ExtentTest test;

    public ExtentTestNGListener() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/TestsReport.html");
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setTheme(Theme.DARK);
        extent.attachReporter(spark);
        extent.setSystemInfo("OS","Windows");
        extent.setSystemInfo("Browser Type","Chrome");
        extent.setSystemInfo("Browser Version","133.0.6943.141");
    }

    @Override
    public void onTestStart(ITestResult result) {
        String className = result.getTestClass().getRealClass().getSimpleName();
        String testName = result.getMethod().getMethodName();
        String testDescription = result.getMethod().getDescription();

        test = extent.createTest(className + "_" + testName, testDescription);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");

        WebDriver driver = ((BaseTest) result.getInstance()).driver;

        String screenshotPath = takeScreenshot(driver,
                result.getMethod().getMethodName());

        if (screenshotPath != null) {
            try {
                String relativePath = "screenshots/" + new File(screenshotPath).getName();
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed");

        Throwable throwable = result.getThrowable();
        if (throwable != null) {
            test.fail("<pre>" + throwable.toString() + "</pre>");

            for (StackTraceElement element : throwable.getStackTrace()) {
                test.fail("<pre>" + element.toString() + "</pre>");
            }
        }

        WebDriver driver = ((BaseTest) result.getInstance()).driver;
        String screenshotPath = takeScreenshot(driver,
                result.getMethod().getMethodName());

        if (screenshotPath != null) {
            try {
                String relativePath = "screenshots/" + new File(screenshotPath).getName();
                test.fail("Screenshot of the failure",
                        MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    /**
     * Метод для создания скриншота
     * @param driver экземпляр WebDriver
     * @param testName Имя теста
     * @return Путь к сохраненному скриншоту
     * **/
    private String takeScreenshot(WebDriver driver, String testName){
        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("dd-MM-yy_HH_mm_ss").format(new Date());
            String filename = testName + "_" + timestamp + ".png";
            File directory = new File(SCREENSHOT_DIR);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            File destinationFile = new File(directory, filename);

            try {
                FileUtils.copyFile(screenshot, destinationFile);
                return destinationFile.getAbsolutePath();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
