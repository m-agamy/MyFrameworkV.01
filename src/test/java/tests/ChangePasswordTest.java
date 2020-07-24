package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.myAccountPage;

public class ChangePasswordTest extends TestBase {

	String firstName= "agamy";
	String lastName= "Test11";
	String userMail= "anaagamy5533@yahoo.com";
	String userPass= "@Test12345678";
	String newPass= "@Test11111111";

	RegistrationPage registrationOpj;
	myAccountPage myAccountPageOpj;
	HomePage homeOpj;
	LoginPage loginOpj;


	@Test(priority = 1)
	public void userRegistrationSuccss() {

		homeOpj= new HomePage(driver);
		homeOpj.openRegistrationPage();
		registrationOpj= new RegistrationPage(driver);
		registrationOpj.userRegistration(firstName,lastName , userMail, userPass);
		Assert.assertTrue(registrationOpj.registrationSuccss.getText().contains("registration completed"));
	}

	@Test(priority = 2)
	public void userChangePasswordSuccss() {
		myAccountPageOpj= new myAccountPage(driver);
		homeOpj.openMyAccount();
		myAccountPageOpj.openChangePasswordPage();
		myAccountPageOpj.changingUserPassword(userPass, newPass);
		Assert.assertTrue(myAccountPageOpj.passwordChangeSuccss.getText().contains("Password was changed"));	
	}

	@Test(priority = 3)
	public void userLogoutSuccss() {

		registrationOpj.userLogout();
	}

	@Test(priority = 4)
	public void userLoginSuccss() {

		homeOpj.openLoginpage();
		loginOpj=new LoginPage(driver);
		loginOpj.userLogin(userMail, newPass);
		Assert.assertTrue(registrationOpj.LogoutLink.getText().contains("Log out"));
	}
}

