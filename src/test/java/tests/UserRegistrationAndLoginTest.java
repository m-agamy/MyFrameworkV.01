package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class UserRegistrationAndLoginTest extends TestBase {
	
	String firstName= "agamy";
	String lastName= "Test11";
	String userMail= "anaagamy1333@yahoo.com";
	String userPass= "@Test12345678";
	
	HomePage homeOpj;
	RegistrationPage registrationOpj;
	LoginPage loginOpj;
	@Test(priority = 1)
public void registrationSuccss() {
		
	homeOpj= new HomePage(driver);
	homeOpj.openRegistrationPage();
	registrationOpj= new RegistrationPage(driver);
	registrationOpj.userRegistration(firstName,lastName , userMail, userPass);
	Assert.assertTrue(registrationOpj.registrationSuccss.getText().contains("registration completed"));
}
	@Test(priority = 2)
	public void logoutSuccss() {
		
		registrationOpj.userLogout();
	}
	
	@Test(priority = 3)
	public void loginSuccss() {
		
		homeOpj.openLoginpage();
		loginOpj=new LoginPage(driver);
		loginOpj.userLogin(userMail, userPass);
		Assert.assertTrue(registrationOpj.LogoutLink.getText().contains("Log out"));
	}
}
