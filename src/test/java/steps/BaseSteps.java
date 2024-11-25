package steps;

import core.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class BaseSteps {

    @When("Linke Gidilir {string}")
    public void linkeGidilir(String url) throws InterruptedException {
        Driver.driver.get(url);
        Thread.sleep(3000);
    }

    @When("{string} xpathine tıklanır")
    public void xpathineTıklanır(String xpath) throws InterruptedException {
        Thread.sleep(2000);
        Driver.driver.findElement(By.xpath(xpath)).click();
    }

    @Then("Url Kontrolü {string}")
    public void urlKontrolu(String url) {
        Assert.assertTrue(Driver.driver.getCurrentUrl().contains(url));
    }

    @Then("{string} Xpathi sayfaya geldimi kontrolü")
    public void xpathKontrol(String xpath) {
        Assert.assertTrue(Driver.driver.findElement(By.xpath(xpath)).isDisplayed());
    }

    @Then("Navbar Kontrolü")
    public void navbarKontrolu() throws InterruptedException {
        List<WebElement> elements = Driver.driver.findElements(By.xpath("(//ul[@class='elementor-widget-cmsmasters-nav-menu__container-inner'])[1]/li/a"));
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).click();
            Thread.sleep(1000);
            elements = Driver.driver.findElements(By.xpath("(//ul[@class='elementor-widget-cmsmasters-nav-menu__container-inner'])[1]/li/a"));
            Assert.assertEquals(Driver.driver.getCurrentUrl(), elements.get(i).getAttribute("href"), "expected: " + elements.get(i).getAttribute("href"));
        }
    }


    @When("{string} Xpathine {string} Değeri Doldurulur Ve Search Edilir")
    public void xpathineDeğeriDoldurulurVeSearchEdilir(String xpath, String value) throws InterruptedException {
        Thread.sleep(2000);
        Driver.driver.findElement(By.xpath(xpath)).sendKeys(value);
        Driver.driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @Then("{int} Nolu Haberin Kontrolü")
    public void noluHaberinKontrolü(int sıra) throws InterruptedException {
        List<WebElement> elements = Driver.driver.findElements(By.xpath("//article//a[@aria-label='Featured Image']"));
        String expectedUrl = elements.get(sıra + 1).getAttribute("href");
        elements.get(sıra + 1).click();
        Thread.sleep(5000);
        Assert.assertEquals(Driver.driver.getCurrentUrl(), expectedUrl);
    }

    @When("{string} Xpathine {string} Değeri Doldurulur")
    public void xpathineDeğeriDoldurulur(String xpath, String value) throws InterruptedException {
        Driver.driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    @When("{string} Xpathine {string} Dosyası Upload Edilir")
    public void xpathineDosyasıUploadEdilir(String xpath, String file) throws InterruptedException {
        WebElement uploadButton = Driver.driver.findElement(By.xpath(xpath));
        File pdfFile = new File(file);
        uploadButton.sendKeys(pdfFile.getAbsolutePath());
    }
}
