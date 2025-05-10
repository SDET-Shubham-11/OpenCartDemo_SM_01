package com.opencart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.OpenCartTestBase;

public class MyAccountsPage extends OpenCartTestBase{
	
	// 1-  ====== Web Elements ======
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(linkText = "Edit your account information")
    private WebElement editAccountInfoLink;

    @FindBy(linkText = "Change your password")
    private WebElement changePasswordLink;

    @FindBy(linkText = "Modify your address book entries")
    private WebElement addressBookLink;

    @FindBy(linkText = "View your order history")
    private WebElement orderHistoryLink;
    
    @FindBy(id = "logo")
    private WebElement homePageLocation;
    
    
// 2- Secondly, We need to initialize the web elements of this page here using the constructor of this class
    
    public MyAccountsPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    

    // 3-  ====== Actions ======
    public void clickLogout() {
        logoutLink.click();
    }

    public void clickEditAccountInfo() {
        editAccountInfoLink.click();
    }

    public void clickChangePassword() {
        changePasswordLink.click();
    }

    public void clickAddressBook() {
        addressBookLink.click();
    }

    public void clickOrderHistory() {
        orderHistoryLink.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public HomePage goToHomePage() {
    	homePageLocation.click();
    	return new HomePage();
    }

}
