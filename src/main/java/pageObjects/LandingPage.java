package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By dismissBtn=By.xpath("//button[text()='NO THANKS']");
	By loginLink=By.cssSelector("a[href*='sign_in']");
	By courseHeader = By.cssSelector("div[class='text-center'] h2");
	By navBar = By.className("navbar-collapse");
	
	public WebElement dismissPopup() {
		return driver.findElement(dismissBtn);
	}
	
	public LoginPage clickLogin() {
		driver.findElement(loginLink).click();
		return new LoginPage(driver);
	}
	
	public WebElement getCourseHeader() {
		return driver.findElement(courseHeader);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
}
