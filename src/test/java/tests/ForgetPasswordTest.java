package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.ForgetPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ForgetPasswordTest extends Base {
	
	WebDriver driver;
	public static Logger logger = LogManager.getLogger(ForgetPasswordTest.class.getName());
	
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
	public void resetPass() {
		LandingPage l = new LandingPage(driver);
		l.dismissPopup().click();
		LoginPage log = l.clickLogin();
		ForgetPasswordPage fPass =log.forgotPassLink();
		logger.info("Forgot password link works");
		fPass.getEmailField().sendKeys("aida");
		fPass.sendInstructions().click();
		System.out.println("Change to ForgetPassword by X");
		
	}
	
}
