package app.chatroom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Call {

	public Call(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@class='sc-jhAzac gOEbWJ']")   
	private WebElement landerContainer;
	
	public WebElement checkLanderContainer()
	{
		return landerContainer;
	}
}
