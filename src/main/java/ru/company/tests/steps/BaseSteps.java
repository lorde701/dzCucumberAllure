package ru.company.tests.steps;

//import org.junit.After;
//import org.junit.Before;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.company.tests.util.TestProperties;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Иванка on 27.10.2017.
 */
public class BaseSteps {
    protected static WebDriver driver;
    protected static String baseUrl;

    //TestProperties properties = new TestProperties();
    public static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        baseUrl = properties.getProperty("app.url");
        driver.get(baseUrl);
    }

    @After
    public static void tearDown() {
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
