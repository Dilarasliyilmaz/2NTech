package core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver driver;

    @Before
    public static void before(Scenario s) {

        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public static void after(Scenario s) {
        driver.quit();
    }
}
