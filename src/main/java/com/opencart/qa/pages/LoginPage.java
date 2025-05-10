package com.opencart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.OpenCartTestBase;

public class LoginPage extends OpenCartTestBase{
	
	// WebElements
    @FindBy(id = "input-email")
    WebElement emailInput;

    @FindBy(id = "input-password")
    WebElement passwordInput;

    @FindBy(css = "input[type='submit'][value='Login']")
    WebElement loginButton;

    @FindBy(linkText = "Forgotten Password")
    WebElement forgotPasswordLink;

    @FindBy(css = ".alert-danger") // Alert box for invalid login
    WebElement warningMessage;
    
    
    
// 2- Secondly, We need to initialize the web elements of this page here using the constructor of this class
    
    public LoginPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    

    // 3- Actions
    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    
 // Example of ENCAPSULATION Below:
    public MyAccountsPage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
        return new MyAccountsPage();
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

    public String getWarningMessage() {
        return warningMessage.getText();
    }


}
