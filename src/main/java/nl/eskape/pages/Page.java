package nl.eskape.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected String url = null;
    protected WebDriver driver;

    public Page(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
    }

    public void open() throws Exception {
        driver.get(this.url);
    }

    public void loseFocusByClickingOnTheBody() {
        driver.findElement(By.tagName("body")).click();
    }

}
