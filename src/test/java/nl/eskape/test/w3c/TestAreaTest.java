package nl.eskape.test.w3c;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import nl.eskape.test.Selenium2TestCase;

public class TestAreaTest extends Selenium2TestCase {
    
    @Test
    public void clearingTest() {
        driver.get("http://www.w3schools.com/tags/tryit_view.asp?filename=tryhtml_textarea");
        System.out.println(driver.findElement(By.tagName("textarea")).getText());
        driver.findElement(By.tagName("textarea")).sendKeys("testing");
        
    }
    

}
