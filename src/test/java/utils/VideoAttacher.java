package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

//TODO Подумать как использовать
public class VideoAttacher implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        attachVideoIfNeeded();
    }

    private void attachVideoIfNeeded() {
//        if (BaseTest.useSelenoid && BaseTest.driver instanceof RemoteWebDriver) {
//            String sessionId = ((RemoteWebDriver) BaseTest.driver).getSessionId().toString();
//            String videoUrl = BaseTest.selenoidUrl.replace("/wd/hub", "") + "/video/" + sessionId + ".mp4";
//            Allure.addAttachment("Failure Video", "text/uri-list", videoUrl);
//        }
    }
}
