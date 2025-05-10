package com.opencart.qa.UnitTestScenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.base.OpenCartTestBase;
import com.opencart.qa.pages.HomePage;

public class CountingMenuItemsWithHoverEffect extends OpenCartTestBase{
	
	
	
HomePage homePage;
	
	public CountingMenuItemsWithHoverEffect()
	{
		super();
	}
	
	@BeforeMethod
    public void setup() {
        initialization();
        homePage = new HomePage();
    }
	
	@Test
	public void validateTotalHeaderMenuItemsCount() {
	    Actions actions = new Actions(driver);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	    List<WebElement> mainMenuItems = driver.findElements(By.cssSelector("ul.nav.navbar-nav > li"));
	    int totalVisibleSubItems = 0;

	    System.out.println("===== HEADER MENU STRUCTURE =====");

	    for (WebElement mainMenu : mainMenuItems) {
	        // Hover over each main menu item
	        actions.moveToElement(mainMenu).pause(Duration.ofSeconds(1)).perform();

	        String mainMenuText = mainMenu.getText().trim();
	        System.out.println("Main Menu: " + mainMenuText);

	        // Count visible sub menus under this main menu (if any)
	        List<WebElement> subMenus = mainMenu.findElements(By.cssSelector("div.dropdown-menu li"));

	        // Wait briefly to let drop down appear
	        if (!subMenus.isEmpty()) {
	            try {
	                wait.until(ExpectedConditions.visibilityOfAllElements(subMenus));
	            } catch (Exception e) {
	                System.out.println("Dropdown might be hidden for: " + mainMenuText);
	            }
	        }

	        for (WebElement sub : subMenus) {
	            String subText = sub.getText().trim();
	            if (!subText.isEmpty()) {
	                System.out.println("    ↳ SubMenu: " + subText);
	                totalVisibleSubItems++;
	            }
	        }
	    }

	    int expectedTotal = 27; // Change this based on actual expected total
	    System.out.println("Total visible submenu items: " + totalVisibleSubItems);
	    Assert.assertEquals(totalVisibleSubItems, expectedTotal, "Submenu count mismatch!");
	}
	
	@AfterMethod
    public void tearDown() {
        driver.quit();
    }
	
	
	
	

}
