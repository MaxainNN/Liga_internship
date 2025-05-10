package utils;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.RequestPattern;
import org.openqa.selenium.devtools.v114.security.Security;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Класс для взаимодействия с Devtools
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

    public void ignoreCertificateErrors() {
        devTools.createSession();
        devTools.send(Security.setIgnoreCertificateErrors(true));
    }

    public void enableSecurity() {
        devTools.createSession();
        devTools.send(Security.enable());
    }

//    public void setInterceptionPatterns(List<String> urlPatterns) {
//        devTools.createSession();
//        devTools.send(Network.enable(Optional.empty(),
//                Optional.empty(), Optional.empty()));
//
//        List<RequestPattern> patterns = urlPatterns.stream()
//                .map(pattern -> new RequestPattern.Builder()
//                        .urlPattern(pattern)
//                        .resourceType(org.openqa.selenium.devtools.v114.network.model.ResourceType.DOCUMENT)
//                        .build())
//                .collect(Collectors.toList());
//
//        devTools.send(Network.setRequestInterception(patterns));
//    }

}