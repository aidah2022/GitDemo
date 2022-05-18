package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By email=By.id("user_email");
	By password = By.id("user_password");
	By login = By.name("commit");
	By forgotPass = By.cssSelector("a[href*='password']");
	
	public WebElement emailInput () {
		return driver.findElement(email);
	}
	
	public WebElement passwordInput() {
		return driver.findElement(password);
	}
	
	public WebElement clickLoginBtn() {
		return driver.findElement(login);
		
	}
	
	public ForgetPasswordPage forgotPassLink(){
		driver.findElement(forgotPass).click();
		return new ForgetPasswordPage(driver);
	}
}
