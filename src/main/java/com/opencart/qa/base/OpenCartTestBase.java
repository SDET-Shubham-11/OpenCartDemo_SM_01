package com.opencart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.opencart.qa.utilis.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCartTestBase {

	public static WebDriver driver;
	public static Properties prop;

	public OpenCartTestBase() {
		// We will firstly read the properties here
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\sdets\\eclipse-workspace\\OpenCart\\"
					+ "src\\main\\java\\com\\opencart\\qa\\config\\Config.properties");
			prop.load(ip);
			;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Now lets create an Initialization method
	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		}

		if (browserName.equals("edge")) {
			driver = WebDriverManager.edgedriver().create();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

}
