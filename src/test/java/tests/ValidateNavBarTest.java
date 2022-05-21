package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavBarTest extends Base {

	WebDriver driver;
	public static Logger logger = LogManager.getLogger(ValidateNavBarTest.class.getName());
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		logger.info("---------------------------");
		logger.info("Driver is initialized");
	}
	
	@AfterMethod
	public void closeBrowsers() {
		driver.close();
		logger.info("Driver closed");
	}
	
	@Test
	public void titleAssert() {
		LandingPage l = new LandingPage(driver);
		l.dismissPopup().click();
		Assert.assertTrue(l.getNavBar().isDisplayed());
		logger.info("Nav bar displayed");
		System.out.println("Change to NavBar by Y");
	}
	
}
