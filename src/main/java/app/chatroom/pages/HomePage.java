package app.chatroom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@class='create-room-form-input']")
	private WebElement chatRoom;
	
	@FindBy(xpath=".//*[@type='submit']")
	private WebElement submitButton;
	
	public WebElement getChatRoom()
	{
		return chatRoom;
	}
	
	public WebElement getSubmitButton()
	{
		return submitButton;
	}
}
