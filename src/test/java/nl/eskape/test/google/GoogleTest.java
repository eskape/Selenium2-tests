package nl.eskape.test.google;

import nl.eskape.pages.google.HomePage;
import nl.eskape.pages.google.models.SearchResult;
import nl.eskape.test.Selenium2TestCase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


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
        SearchResult expectedSearchResult = new SearchResult("Xebia", "www.xebia.com/",
                "\"Xebia is helping us build customized systems and all links between the software packages. But even more important, they have changed the culture in our ...");
        homePage.waitForSearchResult(0, expectedSearchResult);
    }

}
