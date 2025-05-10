package com.opencart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.OpenCartTestBase;

public class RegisterPage extends OpenCartTestBase{
	
	// WebElements
    @FindBy(id = "input-firstname")
    WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    WebElement lastNameInput;

    @FindBy(id = "input-email")
    WebElement emailInput;

    @FindBy(id = "input-telephone")
    WebElement telephoneInput;

    @FindBy(id = "input-password")
    WebElement passwordInput;

    @FindBy(id = "input-confirm")
    WebElement confirmPasswordInput;

    @FindBy(name = "agree")
    WebElement privacyPolicyCheckbox;

    @FindBy(css = "input[type='submit'][value='Continue']")
    WebElement continueButton;

    // Optional - For validation messages
    @FindBy(css = ".alert-danger")
    WebElement warningMessage;
    
    
// 2- Secondly, We need to initialize the web elements of this page here using the constructor of this class
    
    public RegisterPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    

    // 3- Actions
    public void enterFirstName(String fname) {
        firstNameInput.clear();
        firstNameInput.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lname);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterTelephone(String phone) {
        telephoneInput.clear();
        telephoneInput.sendKeys(phone);
    }

    public void enterPassword(String pwd) {
        passwordInput.clear();
        passwordInput.sendKeys(pwd);
    }

    public void enterConfirmPassword(String confirmPwd) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPwd);
    }

    public void checkPrivacyPolicy() {
        if (!privacyPolicyCheckbox.isSelected()) {
            privacyPolicyCheckbox.click();
        }
    }

    public void clickContinue() {
        continueButton.click();
    }

    
    // Example of ENCAPSULATION Below:
    public MyAccountsPage registerNewUser(String fname, String lname, String email, String phone, String pwd) {
        enterFirstName(fname);
        enterLastName(lname);
        enterEmail(email);
        enterTelephone(phone);
        enterPassword(pwd);
        enterConfirmPassword(pwd);
        checkPrivacyPolicy();
        clickContinue();
        return new MyAccountsPage();
    }

    public String getWarningMessage() {
        return warningMessage.getText();
    }
    

}
