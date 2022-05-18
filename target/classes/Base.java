package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException {
	String filePath = "C:\\Users\\adnan\\Documents\\QA\\eclipse-workspace\\E2EPFramework\\src\\main\\java\\resources\\data.properties";
	FileInputStream dataFile = new FileInputStream(filePath);
	prop = new Properties();
	prop.load(dataFile);
	String browserName = prop.getProperty("browser");
	
	
		if (browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\adnan\\Documents\\QA\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\adnan\\Documents\\QA\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver", "C:\\Users\\adnan\\Documents\\QA\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize(); 
		
		return driver;
	}
	
	public String getScreenshotPath (String testName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-uuuu_HH-mm-ss");
		LocalDateTime date = LocalDateTime.now();
		String timestamp = dtf.format(date);
		System.out.println(timestamp);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\" + testName + "_" + timestamp + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
		
	
}