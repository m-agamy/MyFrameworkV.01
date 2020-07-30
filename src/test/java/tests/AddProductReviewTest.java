package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductReviewPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.RegistrationPage;
import pages.SearchPage;

public class AddProductReviewTest extends TestBase {

	String firstName= "agamy";
	String lastName= "Test1";
	String userMail= "anaagamyf31dg@yahoo.com";
	String userPass= "@Test12345678";
	String productLitters="Mac";

	HomePage homeOpj;
	RegistrationPage registrationOpj;
	SearchPage searchPageOpj;
	ProductDetailsPage detailsOpj;
	AddProductReviewPage reviewPageOpj;

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
	public void userReviewProduct() {

		reviewPageOpj= new AddProductReviewPage(driver);
		detailsOpj.openAddReviewPage();
		reviewPageOpj.sendProductReview("Nice Product", "I love it");
		Assert.assertTrue(reviewPageOpj.reviewsuccssMesssage.getText().contains("successfully added"));
	}
}
