package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends PageBase {

	public myAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxtBox;

	@FindBy(id = "NewPassword")
	WebElement newPasswordTxtBox;

	@FindBy(id = "ConfirmNewPassword")
	WebElement newPasswordCheckTxtBox;
	
	@FindBy(css = "input.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(css = "div.result")
	public WebElement passwordChangeSuccss;
	
	public void openChangePasswordPage () {
		
		clickBtn(changePasswordLink);
	}
	
	public void changingUserPassword(String oldPass,String newPass) {
		
		setText(oldPasswordTxtBox, oldPass);
		setText(newPasswordTxtBox, newPass);
		setText(newPasswordCheckTxtBox, newPass);
		clickBtn(changePasswordBtn);
	}
	
	
	

}
