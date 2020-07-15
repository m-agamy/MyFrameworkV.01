package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a.ico-register")
	WebElement createAnAccount;
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(linkText ="My account")
	WebElement myAccountLink;
	
	public void openRegistrationPage() {
		clickBtn(createAnAccount);
	}
	
	public void openLoginpage() {
		clickBtn(LoginLink);
	}
	public void openMyAccount() {
		
		clickBtn(myAccountLink);
	}
}
