package nl.eskape.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Selenium2TestCase {

    protected WebDriver driver;

    @BeforeClass
    public void setUpSelenium() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void tearDownSelenium() {
        driver.close();
    }

}
