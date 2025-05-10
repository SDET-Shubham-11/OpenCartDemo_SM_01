package com.opencart.qa.UnitTestScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.base.OpenCartTestBase;
import com.opencart.qa.pages.HomePage;

public class Footer_ContactUsForm extends OpenCartTestBase{
	
	
	
	HomePage homePage;
	
	public Footer_ContactUsForm()
	{
		super();
	}
	
	
	@BeforeMethod
    public void setup() {
        initialization();
        homePage = new HomePage();
    }
	
    @Test(priority = 1)
    public void fillContactUsFormFromFooter() {
        driver.findElement(By.linkText("Contact Us")).click();

        driver.findElement(By.id("input-name")).sendKeys("Shubham Test");
        driver.findElement(By.id("input-email")).sendKeys("shubham@example.com");
        driver.findElement(By.id("input-enquiry")).sendKeys("This is a test enquiry from automation test.");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement confirmation = driver.findElement(By.cssSelector("#content > p"));
        Assert.assertTrue(confirmation.getText().contains("successfully"), "Contact form not submitted properly");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

	
	

}
