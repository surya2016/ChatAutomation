package app.chatroom.common;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import app.chatroom.utility.DriverClass;
import app.chatroom.utility.TestNGListeners;

@Listeners({TestNGListeners.class})
public class BrowserOpenCloseTest {

	@Parameters("Browser")
	@BeforeTest(alwaysRun=true)
	public void browerOpen(@Optional("Chrome") String browser) throws IOException{
		
		new DriverClass(browser);
		
		//Opens the browser instance
		DriverClass.driver.get("http://www.google.com");
		DriverClass.driver.manage().window().maximize();
	}
	
	//Function to close the browser
	@AfterTest(alwaysRun = true)
	public void browserClose() {
		DriverClass.driver.quit();
	}
}
