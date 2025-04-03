package utils;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.security.Security;

/**
 * Класс для взаимодействия с Devtools (?)
 */
public class DevtoolsHandler {

    private final ChromeDriver driver;
    private final DevTools devTools;

    public DevtoolsHandler(ChromeDriver driver) {
        this.driver = driver;
        this.devTools = driver.getDevTools();
    }

    public void disableSecurity(){
        devTools.createSession();
        devTools.send(Security.disable());
    }

}
