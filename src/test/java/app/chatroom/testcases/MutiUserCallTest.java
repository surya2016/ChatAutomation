package app.chatroom.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import app.chatroom.pages.Call;
import app.chatroom.pages.ChatRoom;
import app.chatroom.pages.HomePage;
import app.chatroom.utility.Constants;
import app.chatroom.utility.DriverClass;
import app.chatroom.utility.Log;
import app.chatroom.utility.PropertiesLoader;

public class MutiUserCallTest {

	
	WebDriver driver = null;
	HomePage homePage = null;
	ChatRoom chatRoom = null;
	Call call = null;
	
	
	//Initializes the class objects
	public void initializations() {
		homePage = new HomePage(driver);
		chatRoom = new ChatRoom(driver);
		call = new Call(driver);
	}
	
	//Before class - executes once at the start
	@Parameters("Group")
	@BeforeClass(groups = { "functional", "regression"})
	public void prerequisites(String group) throws IOException {
		
		//Initializing driver
		driver = DriverClass.driver;
		
		Constants.class_Name = this.getClass().getSimpleName().toString();
		
		initializations();
		
		//Log info to mark start of test class
		Log.startTestCase();
		Log.info(Constants.class_Name, "Start ChatRoom");
		
		//
		
		//Delete all cookies to clear the cart item, if any are left
		driver.manage().deleteAllCookies();
		//maximize the browser window
		driver.manage().window().maximize();
	}
	
	@Test(enabled = true, groups = { "functional" })
	public void multiUserCallTest()
	{
		Log.info("---------------------------Starting---------------------------");
		//Loading the URL and credentials to login page
		driver.get(PropertiesLoader.prop.getProperty("URL"));
		Log.info("Application URL loaded");
		
		WebElement chatRoomName = homePage.getChatRoom();
		
		(new WebDriverWait(driver, 250)).until(ExpectedConditions.visibilityOf(chatRoomName));
		
		chatRoomName.sendKeys(PropertiesLoader.prop.getProperty("room_name"));
		Log.info("Room name entered");
		homePage.getSubmitButton().click();
		
		Log.info("Going to Chat Room");
		
		if(ExpectedConditions.visibilityOf(chatRoom.getCamera())!=null)
		{
			chatRoom.getCamera().click();
			driver.switchTo().alert().accept();
			
		}
		
		if(ExpectedConditions.visibilityOf(chatRoom.getMicrophone())!=null)
		{
			chatRoom.getMicrophone().click();
			driver.switchTo().alert().accept();
		}
		
		chatRoom.getJoinCallButton().click();
		
		
		if((new WebDriverWait(driver, 500)).until(ExpectedConditions.invisibilityOf(call.checkLanderContainer())))
		{
			Log.info("Call Successfully joined by another user");
		}
		
	}
}
