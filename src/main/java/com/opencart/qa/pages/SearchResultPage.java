package com.opencart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.OpenCartTestBase;

public class SearchResultPage extends OpenCartTestBase{
	
	 // ========== Locators ==========

    @FindBy(css = "div.product-thumb h4 a")
    private List<WebElement> searchResultItems;

    @FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
    private WebElement noResultsMessage;

    @FindBy(css = "div.product-thumb h4 a")
    private List<WebElement> productTitles;

    
    // 2- Secondly, We need to initialize the web elements of this page here using the constructor of this class
    
    public SearchResultPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
 // ========== Actions/Methods ==========

    // 1. Check if results are displayed
    public boolean isSearchResultDisplayed() {
        return searchResultItems.size() > 0;
    }

    // 2. Check if "No results" message is displayed
    public boolean isNoResultsMessageDisplayed() {
        return noResultsMessage.isDisplayed();
    }

    // 3. Click on first product
    public ProductDetailsPage clickOnFirstProduct() {
        if (!searchResultItems.isEmpty()) {
            searchResultItems.get(0).click();
            return new ProductDetailsPage();
        } else {
            throw new RuntimeException("No search results available to click.");
        }
    }

    // 4. Fetch and return all product names
    public List<String> getAllProductNames() {
        List<String> productNames = new ArrayList<>();
        for (WebElement title : productTitles) {
            productNames.add(title.getText());
        }
        return productNames;
    }

    // 5. Check if a product with given name exists in results
    public boolean isProductPresent(String productName) {
        for (WebElement title : productTitles) {
            if (title.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    

}
