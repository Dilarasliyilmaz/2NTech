package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps", "core"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public static void beforeSuite() {

    }


    @AfterSuite
    public static void afterSuite() {

    }


}