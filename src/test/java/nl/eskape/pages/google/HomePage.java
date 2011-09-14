package nl.eskape.pages.google;

import java.util.List;

import nl.eskape.pages.Page;
import nl.eskape.pages.google.models.SearchResult;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thoughtworks.selenium.Wait;

public class HomePage extends Page {

    public HomePage(WebDriver driver, String url) {
        super(driver, url);
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.name("q"));
    }

    public SearchResult getSearchResult(int index) {
        WebElement webElement = getSearchResults().get(index);
        String title = webElement.findElement(By.tagName("h3")).getText();
        String url = webElement.findElement(By.tagName("cite")).getText();
        String description = webElement.findElement(By.className("st")).getText();
        return new SearchResult(title, url, description);
    }

    public void clickSearchButton() {
        waitForSearchButton();
        getSearchButton().click();
    }

    public void waitForSearchResult(final int index, final SearchResult expectedSearchResult) {
        new Wait(String.format("Couldn't find search result [%d]", index)) {
            public boolean until() {
                return getSearchResult(index).equals(expectedSearchResult);
            }
        };
    }

    private List<WebElement> getSearchResults() {
        new Wait("Couldn't find search result!") {
            public boolean until() {
                return driver.findElement(By.id("rso")).isDisplayed();
            }
        };
        return driver.findElement(By.id("rso")).findElements(By.tagName("li"));
    }

    private WebElement getSearchButton() {
        return driver.findElement(By.name("btnG"));
    }

    private void waitForSearchButton() {
        new Wait("Couldn't find search button!") {
            public boolean until() {
                return getSearchButton().isDisplayed();
            }
        };
    }

}
