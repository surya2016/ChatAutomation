package app.chatroom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	/**
	 * Page Object Model is a design pattern to create Object Repository for web UI elements. Under this model, for each web page in the application, there should be corresponding page class. 
	 * This Page class will find the WebElements of that web page and also contains Page methods which perform operations on those WebElements.
	 * Name of these methods should be given as per the task they are performing, i.e., if a loader is waiting for the payment gateway to appear, POM method name can be waitForPaymentScreenDisplay().
	 * 
	 * Advantages of POM
	 * Page Object Pattern says operations and flows in the UI should be separated from verification. This concept makes our code cleaner and easy to understand.
	 * The Second benefit is the object repository is independent of test cases, so we can use the same object repository for a different purpose with different tools. For example, we can integrate POM with TestNG/JUnit for functional Testing and at the same time with JBehave/Cucumber for acceptance testing.
	 * Code becomes less and optimized because of the reusable page methods in the POM classes.
	 * Methods get more realistic names which can be easily mapped with the operation happening in UI. i.e. if after clicking on the button we land on the home page, the method name will be like 'gotoHomePage()'.
	 * @param driver
	 */
	
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
