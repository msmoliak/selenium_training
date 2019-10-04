package pl.luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.naming.directory.SearchResult;

public class FirstSeleniumTest extends ParentTestSelenium {

   /* public void acceptPrivacyPolicy() {
        final By PRIVACY_MODAL_WINDOW_WRAPPER = By.className("alert");
        //  final By PRIVACY_ACCEPT_BUTTON = By.cssSelector ("button.width-full");
        driver.get("http://www.etsy.com");
        driver
                .findElement(PRIVACY_MODAL_WINDOW_WRAPPER)
                .findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[2]/button")).click();
        //    driver.findElement(By.className("etsy-icon-cart")).click();
        //    Assert.assertTrue(driver.getTitle().contains("Cart"));

    }*/

  /*  @Test
    public void searchResultsPageTitleContainSearchedText() throws InterruptedException {
        String searchQuery = "leather bag";
        final By SEARCH_FIELD = By.name("search_query");
        final By SEARCH_SUGGESTIONS_LIST_FIRST = By.cssSelector("#global-enhancements-search-suggestions ul div.as-first");


    driver.get("http://www.etsy.com");

    acceptPrivacyPolicy();

    WebElement search_field = driver.findElement(SEARCH_FIELD);
    search_field.clear();
    search_field.sendKeys(searchQuery);
    WebElement firstSuggestionItem = new WebDriverWait(driver, 5).

    until(ExpectedConditions.visibilityOfElementLocated(SEARCH_SUGGESTIONS_LIST_FIRST));
            firstSuggestionItem.click(); */
//    Assert.assertTrue(driver.getTitle().

  //  contains("Leather bag"));
//}

@Test
public void searchResultsPageTableHeaderContainSearchQueryPOTest() {
        String searchQuery = "leather bag";
        EtsyComMainPO etsyCom = new EtsyComMainPO (driver);
    SearchResultsPO etsyResults = new SearchResultsPO(driver);
        etsyCom.goTo()
                .acceptPrivacyPolicy()
                .searchFor(searchQuery)
                .pickFirstItemSuggestionsList();
        String searchResultsHeader = etsyResults.getResultsHeader();
        Assert.assertTrue(searchResultsHeader.contains(searchQuery));
}

}
