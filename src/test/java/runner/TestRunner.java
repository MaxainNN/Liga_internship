package runner;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Тест раннер для jar файла
 */
public class TestRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();

        List<String> suites = new ArrayList<>();
        suites.add("src/test/resources/testng.xml");

        testNG.setTestSuites(suites);
        testNG.addListener(new TestListenerAdapter());
        testNG.run();
    }
}
