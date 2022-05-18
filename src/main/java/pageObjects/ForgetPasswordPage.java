package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPasswordPage {
	
	WebDriver driver;
	public ForgetPasswordPage (WebDriver driver) {
		this.driver = driver;
	}

	By emailField = By.id("user_email");
	By sendInstructionsBtn = By.cssSelector("[type='submit']");
	
	public WebElement getEmailField () {
		return driver.findElement(emailField);
	}
	
	public WebElement sendInstructions() {
		return driver.findElement(sendInstructionsBtn);
	}
}
