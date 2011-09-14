package nl.eskape.test.google;

import nl.eskape.pages.google.HomePage;
import nl.eskape.pages.google.models.SearchResult;
import nl.eskape.test.Selenium2TestCase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends Selenium2TestCase {

    private HomePage homePage;

    @DataProvider(name = "searchQueries")
    public static Object[][] searchQueries() {
        SearchResult educator = new SearchResult("Educator - Onderwijslogistiek - en informatiesysteem", "www.educator.eu/",
                "Educator is een softwarebedrijf die een onderwijslogistiek- en informatiesysteem levert aan onderwijs en bedrijfsleven.");
        SearchResult xebia = new SearchResult("Xebia", "www.xebia.com/",
                "\"Xebia is helping us build customized systems and all links between the software packages. But even more important, they have changed the culture in our ...");
        return new Object[][] { { "Educator", educator }, { "Xebia", xebia }, };
    }

    @BeforeClass
    public void openHomePage() throws Exception {
        homePage = new HomePage(driver, "http://www.google.nl");
        homePage.open();
    }

    @Test(dataProvider = "searchQueries")
    public void searchWithGoogle(String searchQuery, SearchResult expectedSearchResult) throws Exception {
        homePage.getSearchBox().clear();
        homePage.getSearchBox().sendKeys(searchQuery);
        homePage.getSearchBox().submit();
        // somehow we need to sleep a bit using google's submit
        Thread.sleep(200);
        homePage.waitForSearchResult(0, expectedSearchResult);
    }

}
