### TestNG

<img src='../images/testng_long_title.png' alt='Testng' width='400' height='200'>

`TestNG` - фрэймворк для для тестирования Java-приложений.

### Основные аннотации:

|     Аннотация      |                                 	Описание                                 |
|:------------------:|:-------------------------------------------------------------------------:|
|       @Test	       |                        Помечает метод как тестовый                        |
|    @BeforeSuite    |                 	Запускается перед всеми тестами в Suite                  |
|    @AfterSuite	    |                   Запускается после всех тестов в Suite                   |
|    @BeforeTest	    |           Выполняется перед тестами внутри <test> в testng.xml            |
|    @AfterTest	     |           Выполняется после тестов внутри <test> в testng.xml.            |
|       @BeforeClass |                 	Запускается перед первым методом класса                  |
|    @AfterClass     |                  	Запускается после всех методов класса                   |
|   @BeforeMethod    |            	Выполняется перед каждым тестовым методом (@Test)             |
|    @AfterMethod    |            	Выполняется после каждого тестового метода (@Test)            |
|    @Parameters	    |            Позволяет передавать параметры из testng.xml в тест            |
|   @DataProvider    |          	Возвращает данные для параметризованных тестов                  |
|    @Listeners	     | Подключает кастомные listeners (например, для логирования или скриншотов) |

### Для управления тестов используется `testng.xml`:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="MyTestSuite" verbose="1">

    <listeners>
        <listener class-name="UI.GoogleTest" />
        <listener class-name="UI.MainPageTest" />
    </listeners>

    <test name="DemoQATests" preserve-order="true">
        <parameter name="browser" value="chrome" />
        <classes>
            <class name="UI.DynamicPropertiesTest" />
            <class name="UI.DownloadUploadTest" />
        </classes>
    </test>

    <test name="GoogleTests">
        <classes>
            <class name="UI.GoogleTest" />
        </classes>
    </test>
</suite>
```

|        Тэг         |                 Описание                 |
|:------------------:|:----------------------------------------:|
|       suite        |           контейнер для тестов           |
|        test        |   группа тестов (может быть несколько)   |
| classes / packages | указывает, какие классы/пакеты запускать |
|     parameter      |        передает параметры в тесты        |
|     listeners      |      подключает listeners                |


### Подключение `testng.xml` в `Maven`:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0-M7</version>
            <configuration>
                <suiteXmlFiles>
                    <suiteXmlFile>src/test/resources/testng.xml</suiteXmlFile>
                </suiteXmlFiles>
                <properties>
                    <property>
                        <name>listener</name>
                        <value>com.example.MyTestListener,com.example.MyReportListener</value>
                    </property>
                </properties>
            </configuration>
        </plugin>
    </plugins>
</build>

```

Указать можно в 
`<suiteXmlFiles><suiteXmlFile>{путь_до_testng.xml}</suiteXmlFile></suiteXmlFiles>`
или в 
`<property><name>listener</name><value>{название_листенера}</value></property>`

### Пример теста с параметрами и `DataProvider` :

```java
import org.testng.annotations.*;

public class ExampleTest {
    // Тест , имеет group = smoke и приоритет = 1
    @Test(priority = 1, groups = "smoke")
    public void testLogin() {
        System.out.println("Smoke test");
    }

    // Тест с данными
    @Test(dataProvider = "users")
    public void testUsers(String username, String password) {
        System.out.println("User: " + username + ", Pass: " + password);
    }

    // Данные
    @DataProvider(name = "users")
    public Object[][] userData() {
        return new Object[][] {
            {"user1", "pass1"},
            {"user2", "pass2"}
        };
    }

    // Тест с параметрами из testng.xml
    @Parameters({"browser"})
    @Test
    public void testBrowser(String browser) {
        System.out.println("Browser: " + browser);
    }
}
```

[Официальная документация](https://testng.org/)