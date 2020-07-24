package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class SendEnquiryViaContactUsTest extends TestBase {


	String Name= "agamy";
	String Email= "anaagamy1333@yahoo.com";
	String Enquiry= "This Web Site is Cool";
	String sucssMessage= "Your enquiry has been successfully sent";
	
	HomePage homePageOpj;
	ContactUsPage contactUsOpj;

	@Test
	public void userSendEnquirySuccss() {

		homePageOpj= new HomePage(driver);
		contactUsOpj= new ContactUsPage(driver);
		homePageOpj.openContactUsPage();
		contactUsOpj.userSendEnquiry(Name, Email, Enquiry);
		Assert.assertTrue(contactUsOpj.sucssMessage.getText().contains(sucssMessage));
	}
}
