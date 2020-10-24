package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import tests.TestBase;

public class UserRegistrationBdd extends TestBase{
	
	String firstName= "agamy";
	String lastName= "Test11";
	String userMail= "anaagamy1333@yahoo.com";
	String userPass= "Test12345678";
	HomePage homeOpj;
	RegistrationPage registrationOpj;
	LoginPage loginOpj;
	
	@Given("User openned the homepage")
	public void user_openned_the_homepage() {
		homeOpj= new HomePage(driver);
		
	   // throw new io.cucumber.java.PendingException();
	}
	
	@When("User click on registration link")
	public void user_click_on_registration_link() {
		homeOpj.openRegistrationPage();
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User enter his valid credentials")
	public void user_enter_his_valid_credentials() {
		registrationOpj= new RegistrationPage(driver);
	   // throw new io.cucumber.java.PendingException();
	}

	@When("User click on Submit")
	public void user_click_on_submit() {
		registrationOpj.userRegistration(firstName,lastName , userMail, userPass);
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("User registration completed")
	public void user_registration_completed() {
		Assert.assertTrue(registrationOpj.registrationSuccss.getText().contains("registration completed"));
		registrationOpj.userLogout();
	    //throw new io.cucumber.java.PendingException();
	}
	
	
}
