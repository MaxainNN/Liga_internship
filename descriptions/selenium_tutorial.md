# Selenium

From load_test_template project


### Пример теста 

```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Убрать WBM
        // Настройка WebDriver с помощью WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearch() {
        // Открываем Google
        driver.get("https://www.google.com");

        // Находим поле поиска и вводим "java"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("java");
        searchBox.submit();

        // Ждем, пока страница загрузится (можно использовать явные ожидания, если нужно)
        try {
            Thread.sleep(2000); // Просто для примера, лучше использовать WebDriverWait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проверяем, что заголовок страницы содержит слово "java"
        String pageTitle = driver.getTitle();
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Assert.assertTrue(pageTitle.toLowerCase().contains("java"), "Заголовок страницы не содержит 'java'");
    }

    @AfterMethod
    public void tearDown() {
        // Закрываем браузер
        if (driver != null) {
            driver.quit();
        }
    }
}
```
### Примеры взаимодействия с Selenium API

```java
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='userName']"));
        userNameInput.sendKeys("Max");
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        emailElement.sendKeys("BlindFoxKingdom@yandex.com");
        WebElement currentAddressElement = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        currentAddressElement.sendKeys("Krukova Street 16 appartment 82");
        WebElement permanentAddressElement = driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]"));
        permanentAddressElement.sendKeys("New York");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",button);
        button.click();
        WebElement userNameOutput = driver.findElement(By.xpath("//p[@id='name']"));
        WebElement userEmailOutput = driver.findElement(By.xpath("//p[@id='email']"));
        WebElement userCurAddOutput = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement userPerAddOutput = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String name = userNameOutput.getText();
        String email = userEmailOutput.getText();
        String curAdd = userCurAddOutput.getText();
        String perADd = userPerAddOutput.getText();
        System.out.println(name + "\n " + email + "\n " + curAdd + "\n " + perADd);


    }
}
```

https://testengineer.ru/selenium-webdriver-java-cheat-sheet/

### Page Object Model

### Пример структуры Page Object Model