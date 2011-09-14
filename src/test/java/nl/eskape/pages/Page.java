package nl.eskape.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected String url = null;
    protected WebDriver driver;

    public Page(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public void open() throws Exception {
        driver.get(this.url);
    }

    public void loseFocusByClickingOnTheBody() {
        driver.findElement(By.xpath("//body")).click();
    }

}
