package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "gender-male")
	WebElement customerGenderRbtn;

	@FindBy(id = "FirstName")
	WebElement FNameTxtBox;

	@FindBy(id = "LastName")
	WebElement LNameTxtBox;

	@FindBy(id = "Email")
	WebElement EmailTxtBox;

	@FindBy(id = "Password")
	WebElement PasswordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement PasswordCheckTxtBox;

	@FindBy(id = "register-button")
	WebElement registerBtn;

	@FindBy(css = "div.result")
	public WebElement registrationSuccss;

	@FindBy(linkText = "Log out")
	public WebElement LogoutLink;

	@FindBy(name = "register-continue")
	WebElement continueBtn;

	public void userRegistration(String firstName ,String lastName ,String customerEmail, String customerPassword ) {

		clickBtn (customerGenderRbtn);
		setText (FNameTxtBox , firstName);
		setText (LNameTxtBox , lastName);
		setText (EmailTxtBox , customerEmail);
		setText (PasswordTxtBox , customerPassword);
		setText (PasswordCheckTxtBox , customerPassword);
		clickBtn (registerBtn);

	}
	public void userLogout() {
		clickBtn(LogoutLink);
	}

	public void continueAfterRegistration() {
		clickBtn(continueBtn);
	}
}
