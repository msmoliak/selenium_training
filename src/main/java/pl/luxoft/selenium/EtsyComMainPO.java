package pl.luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EtsyComMainPO extends BasePO {
    final By SEARCH_FIELD = By.name("search_query");
    final By SEARCH_SUGGESTIONS_LIST_FIRST = By.cssSelector("#global-enhancements-search-suggestions ul div.as-first");

    PolicyModalPO policyModal;

    public EtsyComMainPO(WebDriver driver) {
        super(driver);
        policyModal = new PolicyModalPO(driver);
    }
    public EtsyComMainPO goTo() {
        driver.get("http://www.etsy.com");
        return this;
    }
public EtsyComMainPO acceptPrivacyPolicy(){
        policyModal.acceptPolicy();
        return this;
    }

    public EtsyComMainPO searchFor (String query){
        enterSearchQuery(query);
        return this;
    }
    private void enterSearchQuery(String query) {
        WebElement searchField = findElementWithWait(SEARCH_FIELD);
        searchField.clear();
        searchField.sendKeys(query);
    }
    public EtsyComMainPO pickFirstItemSuggestionsList() {
        getFirstItemInSuggestionList().click();
        return this;
    }
    private WebElement getFirstItemInSuggestionList() {
        return findElementWithWait(SEARCH_SUGGESTIONS_LIST_FIRST);
    }
}
