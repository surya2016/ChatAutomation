package app.chatroom.utility;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
			ChromeOptions options = new ChromeOptions();
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_setting_values.media_stream_mic", 1);
			chromePrefs.put("profile.default_content_setting_values.media_stream_camera", 1);
			
			options.setExperimentalOption("prefs", chromePrefs);
			
			driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir")
					+PropertiesLoader.prop.getProperty("resourcePath")
					+"geckodriver");
			//driver = new FirefoxDriver();
			
			FirefoxOptions opt = new FirefoxOptions();
			
			opt.addPreference("permissions.default.microphone", 1);
			opt.addPreference("permissions.default.camera", 1);
			
			/*opt.setBinary(System.getProperty("user.dir")
					+PropertiesLoader.prop.getProperty("resourcePath")
					+"geckodriver");*/
			driver = new FirefoxDriver(opt);
		} 
		
		driver.manage().deleteAllCookies();
	}
}
