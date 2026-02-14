package tests;

import base.BaseTest;
import pages.HomePage;
import pages.SearchResultsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(description = "Search for a product on Flipkart")
    public void search_iPhone15_shouldShowResults() {
        HomePage home = new HomePage(driver());
        home.handleStartupPopupsIfAny();
        home.searchFor("iPhone 15");

        SearchResultsPage results = new SearchResultsPage(driver());
        Assert.assertTrue(results.hasResults(), "Expected some search results, but none were found.");
    }
}