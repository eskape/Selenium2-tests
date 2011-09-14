package com.xebia.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Selenium2TestCase {
    
    /** The driver. */
    public static WebDriver driver;

    
    @BeforeClass
    public void setUpSelenium() {
        driver = new FirefoxDriver();
    }

    
    /**
     * Tear down selenium.
     */
    @AfterClass
    public static void tearDownSelenium() {
        driver.close();
    }


}
