package com.opencart.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.qa.base.OpenCartTestBase;

public class ProductDetailsPage extends OpenCartTestBase{
	
	// ========== Locators ==========

    @FindBy(css = "div.col-sm-4 h1") 
    private WebElement productName;

    @FindBy(xpath = "//ul[@class='list-unstyled']//li//h2")
    private WebElement productPrice;

    @FindBy(id = "input-quantity")
    private WebElement quantityInput;

    @FindBy(id = "button-cart")
    private WebElement addToCartButton;

    @FindBy(css = "div.alert-success")
    private WebElement successMessage;

    @FindBy(css = "div#tab-description")
    private WebElement productDescription;
    
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[4]/a/span")
    WebElement cartButton;
    
    
// 2- Secondly, We need to initialize the web elements of this page here using the constructor of this class
    
    public ProductDetailsPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
 // ========== Action Methods ==========

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getProductDescription() {
        return productDescription.getText();
    }

    public void setQuantity(String quantity) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(quantityInput));
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public ShoppingCartPage clickAddToCart() {
        addToCartButton.click();
        return new ShoppingCartPage();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }
    
    public ShoppingCartPage goToCartPage() {
    	cartButton.click();
    	return new ShoppingCartPage();
    }
    
    
    

}
