package utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Класс- трансформер аннотаций
 * Устанавливает enabled = false
 * если браузер не Chrome
 */
public class ChromeOnlyTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        String browser = System.getProperty("browser", "chrome");
        if (!"chrome".equalsIgnoreCase(browser)) {
            annotation.setEnabled(false);
        }
    }
}
