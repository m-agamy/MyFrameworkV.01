package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FullName")
	WebElement userName;

	@FindBy(id = "Email")
	WebElement userEmail;

	@FindBy(id = "Enquiry")
	WebElement userEnquiry;

	@FindBy(css = "div.result")
	public WebElement sucssMessage ;

	@FindBy(css = "input.button-1.contact-us-button")
	WebElement submitBtn ;

	public void userSendEnquiry(String Name, String Email, String Enquiry) {

		setText(userName, Name);
		setText(userEmail, Email);
		setText(userEnquiry, Enquiry);
		clickBtn(submitBtn);	
	}

}
