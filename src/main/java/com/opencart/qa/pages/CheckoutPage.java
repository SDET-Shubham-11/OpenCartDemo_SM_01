package com.opencart.qa.pages;

import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencart.qa.base.OpenCartTestBase;

public class CheckoutPage extends OpenCartTestBase{
	
	// ========== Locators ==========

    @FindBy(css = "div#content h1")
    private WebElement checkoutHeading;

    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-payment-address-1")
    private WebElement address1Input;

    @FindBy(id = "input-payment-city")
    private WebElement cityInput;

    @FindBy(id = "input-payment-postcode")
    private WebElement postcodeInput;

    @FindBy(id = "input-payment-country")
    private WebElement countryDropdown;

    @FindBy(id = "input-payment-zone")
    private WebElement regionDropdown;
    
    @FindBy(xpath = "//*[@id=\"input-payment-telephone\"]")
    private WebElement telephoneNo;
    
    @FindBy(xpath = "//*[@id=\"input-payment-email\"]")
    private WebElement emailId;

    @FindBy(id = "button-guest")
    private WebElement continueBillingBtn;

    @FindBy(id = "button-shipping-method")
    private WebElement continueShippingBtn;

    @FindBy(name = "agree")
    private WebElement termsCheckbox;

    @FindBy(id = "button-payment-method")
    private WebElement continuePaymentBtn;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderBtn;

    @FindBy(css = "div#content h1")
    private WebElement orderConfirmationMsg;
    
    @FindBy(xpath = "//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")
    private WebElement guestCheckout;
    
    @FindBy(xpath = "//*[@id=\"button-account\"]")
    private WebElement guestCheckoutbtmsubmit;

    
    
// 2- Secondly, We need to initialize the web elements of this page here using the constructor of this class
    
    public CheckoutPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
 // ========== Actions ==========

    public String getCheckoutHeading() {
        return checkoutHeading.getText();
    }

    public void guestCheckout() {
        guestCheckout.click();
        guestCheckoutbtmsubmit.click();
    }
    
    
    
    public void enterBillingDetails(String firstName, String lastName, String address, String city, String postcode, String Email) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        
        telephoneNo.clear();
        telephoneNo.sendKeys(postcode);
        
        emailId.clear();
        emailId.sendKeys(Email);
        
        // telephoneNo.clear();
        // telephoneNo.sendKeys(postcode);

        address1Input.clear();
        address1Input.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);
        
        
    }

    public void selectCountry(String countryName) {
        new Select(countryDropdown).selectByVisibleText(countryName);
    }

    public void selectRegion(String regionName) {
        new Select(regionDropdown).selectByVisibleText(regionName);
    }

    public void clickContinueBilling() {
        continueBillingBtn.click();
    }

    public void clickContinueShipping() {
        continueShippingBtn.click();
    }

    public void agreeToTerms() {
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }
    }

    public void clickContinuePayment() {
        continuePaymentBtn.click();
    }

   // public OrderSuccessPage clickConfirmOrder() {
   //    confirmOrderBtn.click();
   //   return new OrderSuccessPage();
   // }

    public String getOrderConfirmationMessage() {
        return orderConfirmationMsg.getText();
    }

    public boolean isOrderConfirmed(String expectedMessage) {
        return getOrderConfirmationMessage().equalsIgnoreCase(expectedMessage);
    }
    
    
    
    public void waitForCaptchaInput() {
        System.out.println("=================================================");
        System.out.println("    🚧 CAPTCHA BLOCK DETECTED 🚧");
        System.out.println("    Please enter Captcha manually on browser.");
        System.out.println("    Then press ENTER here to continue...");
        System.out.println("=================================================");
        try (Scanner scanner = new Scanner(System.in)) {
			scanner.nextLine();
		}
    }
    
    
}
