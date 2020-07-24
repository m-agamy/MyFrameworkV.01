package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailAFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.RegistrationPage;
import pages.SearchPage;

public class EmailProductToFriendTest extends TestBase {


	String firstName= "agamy";
	String lastName= "Test11";
	String userMail= "anaagamy1f13@yahoo.com";
	String userPass= "@Test12345678";
	String productLitters="Beats Pill";
	String friendEmail= "dragamy1333@yahoo.com";
	String userMessage= "Hi Chick this";

	HomePage homeOpj;
	RegistrationPage registrationOpj;
	SearchPage searchPageOpj;
	ProductDetailsPage detailsOpj;
	EmailAFriendPage emailAFriendOpj;


	@Test(priority = 1)
	public void UserRegistrationSuccss() {

		homeOpj= new HomePage(driver);
		homeOpj.openRegistrationPage();
		registrationOpj= new RegistrationPage(driver);
		registrationOpj.userRegistration(firstName,lastName , userMail, userPass);
		Assert.assertTrue(registrationOpj.registrationSuccss.getText().contains("registration completed"));
	}

	@Test(priority = 2)
	public void userSearchByAutoSuggest() {

		searchPageOpj= new SearchPage(driver);
		detailsOpj= new ProductDetailsPage(driver);
		searchPageOpj.searchUsingAutoSuggest(productLitters);
		Assert.assertTrue(detailsOpj.productName.getText().contains(productLitters));
	}

	@Test(priority = 3)
	public void userEmailProductToFriend() {

		emailAFriendOpj=new EmailAFriendPage(driver);
		detailsOpj.openEmailAfriendPage();
		emailAFriendOpj.sendEmailToFriend(friendEmail, userMessage);
		Assert.assertTrue(emailAFriendOpj.succssMessage.getText().contains("Your message has been sent"));
	}
}
