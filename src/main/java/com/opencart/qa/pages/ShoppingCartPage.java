package com.opencart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.OpenCartTestBase;

public class ShoppingCartPage extends OpenCartTestBase{
	
	// ========== Locators ==========

    @FindBy(xpath = "//div[@id='content']//h1")
    private WebElement shoppingCartTitle;

    @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[2]/a")
    private WebElement productName;

    @FindBy(css = "input[name*='quantity']")
    private WebElement quantityInput;

    @FindBy(css = "button[data-original-title='Update']")
    private WebElement updateButton;

    @FindBy(css = "button[data-original-title='Remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//div[@id='content']//div[contains(@class,'alert-success')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
    private WebElement emptyCartMessage;
    
    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
    private WebElement proceedChcekoutButton;
    
    
  
    
// 2- Secondly, We need to initialize the web elements of this page here using the constructor of this class
    
    public ShoppingCartPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    
 // ========== Action Methods ==========

    public String getCartTitle() {
        return shoppingCartTitle.getText();
    }

    public String getProductName() {
        return productName.getText();
    }
    

    public void updateProductQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
        updateButton.click();
    }

    public void removeProductFromCart() {
        removeButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    public boolean isCartEmptyMessageDisplayed() {
        return emptyCartMessage.isDisplayed();
    }

    public String getEmptyCartMessageText() {
        return emptyCartMessage.getText();
    }
    
    public CheckoutPage proceedToCheckout() {
       proceedChcekoutButton.click();
       return new CheckoutPage();
        
    }
}
