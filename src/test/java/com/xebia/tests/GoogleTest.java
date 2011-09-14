package com.xebia.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xebia.test.pages.google.HomePage;
import com.xebia.test.pages.google.models.SearchResult;

public class GoogleTest extends Selenium2TestCase {

    private HomePage homePage;

    @BeforeClass
    public void openHomePage() throws Exception {
        homePage = new HomePage(driver, "http://www.google.nl");
        homePage.open();
    }

    @Test
    public void findEducatorWithGoogle() throws Exception {
        homePage.getSearchBox().clear();
        homePage.getSearchBox().sendKeys("educator");
        homePage.clickSearchButton();
        SearchResult expectedSearchResult = new SearchResult("Educator - Onderwijslogistiek - en informatiesysteem", "www.educator.eu/",
                "Educator is een softwarebedrijf die een onderwijslogistiek- en informatiesysteem levert aan onderwijs en bedrijfsleven.");
        homePage.waitForSearchResult(0, expectedSearchResult);
    }

    @Test
    public void findXebiaWithGoogle() throws Exception {
        homePage.getSearchBox().clear();
        homePage.getSearchBox().sendKeys("Xebia");
        homePage.clickSearchButton();
        SearchResult expectedSearchResult = new SearchResult("Educator - Onderwijslogistiek - en informatiesysteem", "www.educator.eu/",
                "Educator is een softwarebedrijf die een onderwijslogistiek- en informatiesysteem levert aan onderwijs en bedrijfsleven.");
        homePage.waitForSearchResult(0, expectedSearchResult);
    }

}
