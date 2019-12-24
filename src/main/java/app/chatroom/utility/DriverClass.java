package app.chatroom.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class DriverClass {

	public static WebDriver driver;
	
	/**
	 * Static web_driver instance for initialization to be accessed across all test cases.
	 * web_drivers are initialized according to browsers configured.
	 * @param browser name
	 * @throws IOException 
	 */
	
	@Parameters("Browser")
	public DriverClass(@Optional("Chrome") String browser) throws IOException {
		
		//For Chrome
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")
					+PropertiesLoader.prop.getProperty("resourcePath")
					+"chromedriver");
			
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhinav.a.malhotra\\Desktop\\drivers\\chromedriver");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir")
					+PropertiesLoader.prop.getProperty("resourcePath")
					+"geekodriver");
			driver = new FirefoxDriver();
		} 
		
		driver.manage().deleteAllCookies();
	}
}
