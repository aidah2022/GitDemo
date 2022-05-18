package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	WebDriver driver;
	public static Logger logger = LogManager.getLogger(LoginTest.class.getName());
	
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
	
	@Test(dataProvider="loginData")
	public void login(String email, String password) {
		LandingPage l = new LandingPage(driver);
		l.dismissPopup().click();
		LoginPage log = l.clickLogin();
		logger.info("Logging in with e-mail: " + email);
		log.emailInput().sendKeys(email);
		log.passwordInput().sendKeys(password);
		Assert.assertEquals(email, "aidah1803@gmail.com");
		log.clickLoginBtn();
		logger.info("Login successful with: " + email);
	}
	
	@DataProvider
	public Object[][] loginData(){
		Object[][] loginInfo = new Object [2][2];
		loginInfo[0][0] = "aidah1803@gmail.com";
		loginInfo[0][1] = "UnforgettableApps123!";
		loginInfo[1][0] = "komora.aida@gmail.com";
		loginInfo[1][1] = "NewPassword456*";
		
		return loginInfo;
	}
}
