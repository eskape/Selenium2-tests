package com.xebia.test.pages.google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thoughtworks.selenium.Wait;
import com.xebia.test.pages.Page;
import com.xebia.test.pages.google.models.SearchResult;

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
        new Wait("Couldn't find search button!") {
            public boolean until() {
                return getSearchResult(index).equals(expectedSearchResult);
            }
        };
    }

    private List<WebElement> getSearchResults() {
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
