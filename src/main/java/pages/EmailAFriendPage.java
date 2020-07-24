package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAFriendPage extends PageBase {

	public EmailAFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement userMessageTxt;
	
	@FindBy(css = "input.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn;
	
	@FindBy(css = "div.result")
	public WebElement succssMessage;
	
	public void sendEmailToFriend(String friendEmail, String userMessage ) {
		
		setText(friendEmailTxt, friendEmail);
		setText(userMessageTxt, userMessage);
		clickBtn(sendEmailBtn);
	}
	

}
