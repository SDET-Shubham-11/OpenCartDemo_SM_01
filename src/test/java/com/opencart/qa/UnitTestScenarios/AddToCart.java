package com.opencart.qa.UnitTestScenarios;


import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.qa.base.OpenCartTestBase;
import com.opencart.qa.pages.HomePage;
import com.opencart.qa.pages.LoginPage;
import com.opencart.qa.pages.MyAccountsPage;
import com.opencart.qa.pages.ProductDetailsPage;
import com.opencart.qa.pages.RegisterPage;
import com.opencart.qa.pages.SearchResultPage;
import com.opencart.qa.pages.ShoppingCartPage;
import com.opencart.qa.utilis.ExcelUtil;


public class AddToCart extends OpenCartTestBase {

	AddToCart addingToCart;
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddToCart.class);

	HomePage homePage;
	LoginPage loginPage;
	RegisterPage registerPage;
	MyAccountsPage myAccountsPage;
	SearchResultPage searchResultPage;
	ProductDetailsPage productDetailsPage;
	ShoppingCartPage cartPage;

	// 1- Firstly I will create a constructor here and use the super keyword to
	// "call the super class constructor here i.e. the code to read the properties."
	public AddToCart() {
		super();
	}

	@BeforeMethod
	public void setup() {
		// 2- Secondly, I will call the "Initialization" method from our Test Base class
		// here
		initialization();
		// 3- Thirdly, we need to create the Objects of the Elements page class here,
		// so that we can access all the actions and methods defined in the Elements
		// page class
		addingToCart = new AddToCart();
	}

	@DataProvider(name = "Order1")
	public Object[][] getValidOrderData() {
		Object[][] data = ExcelUtil.getTestData("ValidOrderData");

		System.out.println("========= Excel Data Loaded =========");
		logger.info("========= Excel Data Loaded =========");
		
		
		 
		for (Object[] row : data) {
			System.out.print("Row: ");
			for (Object cell : row) {
				System.out.print(cell + " | ");
			}
			System.out.println();
		}
		System.out.println("=====================================");

		return data;
	}

	@Test(dataProvider = "Order1")
	public void validateSuccessfulPurchaseFlow(String email, String password, String productName, String quantity,
			String firstName, String lastName, String address, String city, String postcode, String countryName,
			String regionName) {

// 1. Login
		homePage = new HomePage();
		homePage.clickOnMyAccount();
		registerPage = homePage.clickRegister();
		registerPage.registerNewUser(firstName, lastName, email, city, postcode);
		System.out.println("User Registration successful");
		logger.info("User Registration successful");
		
		 

		loginPage = homePage.clickLogin();
		myAccountsPage = loginPage.login(email, password);
		System.out.println("User Successfully logged in");
		logger.info("User Successfully logged in");
		
		 
// Assert.assertTrue(myAccountsPage.getMyAccountHeading().contains("My Account"));

// 2. Search Product
// write web element for home page it is pending
		homePage = myAccountsPage.goToHomePage();
		searchResultPage = homePage.searchProduct(productName);
		Assert.assertTrue(searchResultPage.isSearchResultDisplayed());
		System.out.println("Search results are successfully displayed");
		logger.info("Search results are successfully displayed");
		
		 
		Assert.assertTrue(searchResultPage.isProductPresent(productName));
		System.out.println("My 1st product is -->" + productName);
		logger.info("My 1st product is added");
	

// 3. Click First Product → Add to Cart
		productDetailsPage = searchResultPage.clickOnFirstProduct();
		System.out.println("Clicked on 1st product");
		logger.info("Clicked on 1st product");
		
		 
		productDetailsPage.setQuantity(quantity);
		productDetailsPage.clickAddToCart();
		Assert.assertTrue(productDetailsPage.isSuccessMessageDisplayed());
		System.out.println("Product is successfully added to the cart");
		logger.info("Product is successfully added to the cart");
		
		 

	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
