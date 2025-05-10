package com.opencart.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.qa.base.OpenCartTestBase;

public class HomePage extends OpenCartTestBase {
	
	// 1- Firstly, We need to define the Page Factory/object repository of this page here
	
	@FindBy(xpath = "(//span[normalize-space()='My Account'])[1]") // No id/name, so using stable XPath
    WebElement myAccountDropdown;

    @FindBy(linkText = "Login") // Link text is unique and visible
    WebElement loginLink;

    @FindBy(linkText = "Register") // Same as above
    WebElement registerLink;

    @FindBy(css = "form#form-currency button.dropdown-toggle") // Clean CSS for dropdown
    WebElement currencyDropdown;

    @FindBy(name = "search") // Name is unique here
    WebElement searchInput;

    @FindBy(xpath = "//i[@class=\"fa fa-search\"]") // CSS is more readable here than XPath
    WebElement searchButton;
    
    @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong/text()")
    private WebElement checkoutButton;
    
    
    
    
 // 2- Secondly, We need to initialize the web elements of this page here using the constructor of this class
    
    public HomePage()
    {
    	PageFactory.initElements(driver, this);
    }
		
    
    
 // 3- Thirdly, We need to define all the actions to be performed on this page here 
    
    public void clickOnMyAccount() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountDropdown)).click();
    }

    public LoginPage clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
        return new LoginPage();
    }

    public RegisterPage clickRegister() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
        return new RegisterPage();
    }

    public void selectCurrency(String currencyCode) {
        currencyDropdown.click();
        WebElement currencyOption = driver.findElement(By.name(currencyCode));
        currencyOption.click();
    }

    public SearchResultPage searchProduct(String productName) {
        searchInput.clear();
        searchInput.sendKeys(productName);
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        searchButton.click();
        return new SearchResultPage();
    }

    public void clickOnFeaturedProduct(String productName) {
        WebElement product = driver.findElement(
            By.xpath("//div[@class='product-thumb']//a[text()='" + productName + "']")
        );
        product.click();
       
        
    }
    
   
    	
    
    
    // public ShoppingCartPage clickCheckoutButton() {
    //     checkoutButton.click();
    //     return new ShoppingCartPage();
    // }
    
    
    //	public ShoppingCartPage goToCheckoutPage() {
    //    	cartButton.click();
    //    	return new ShoppingCartPage();
		
   

}
    
