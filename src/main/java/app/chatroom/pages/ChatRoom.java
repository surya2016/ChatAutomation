package app.chatroom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatRoom {
	
	public ChatRoom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//span[text()='Allow camera access']")
	private WebElement camera;
	
	@FindBy(xpath=".//span[text()='Allow microphone access']")
	private WebElement microphone;
	
	@FindBy(xpath=".//*[@class='sc-iwsKbI sc-jKJlTe hsPRMM']")
	private WebElement joinCallButton;
	
	
	public WebElement getCamera()
	{
		return camera;
	}
	
	public WebElement getMicrophone()
	{
		return microphone;
	}
	
	public WebElement getJoinCallButton()
	{
		return joinCallButton;
	}
}
