package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.RegistrationPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class RegisterdUserCheckoutProductTest extends TestBase {

	String productLitters1="HTC One M8 Android";
	String productLitters2="Nokia Lumia";
	String firstName= "agamy";
	String lastName= "Test11";
	String userMail= "anaagamy23@yahoo.com";
	String userPass= "@Test12345678";
	String country= "Albania";
	String city= "berat";
	String address= "25 main St";
	String zipCode= "12345";
	String phoneNum= "0255448877";

	RegistrationPage registrationOpj;
	SearchPage searchPageOpj;
	ProductDetailsPage detailsOpj;
	ShoppingCartPage shoppingCartOpj;
	CheckoutPage CheckoutOpj;
	OrderDetailsPage OrderDetailsOpj;

	//search for 2 products and add it to Shopping Cart.
	@Test(priority = 1)
	public void userAddProductsToShoppingCart() {

		searchPageOpj= new SearchPage(driver);
		detailsOpj= new ProductDetailsPage(driver);
		searchPageOpj.searchUsingAutoSuggest(productLitters1);
		detailsOpj.addProductToShoppingCart();
		searchPageOpj.searchUsingAutoSuggest(productLitters2);
		detailsOpj.addProductToShoppingCart();
		shoppingCartOpj= new ShoppingCartPage(driver);
		detailsOpj.openShoppingCart();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/cart"));
	}

	@Test(priority = 2)
	public void registerUserCanChechoutProduct() {

		shoppingCartOpj.openCheckoutPage();
		CheckoutOpj= new CheckoutPage(driver);
		CheckoutOpj.openRegistrationPage();
		registrationOpj= new RegistrationPage(driver);
		registrationOpj.userRegistration(firstName,lastName , userMail, userPass);
		Assert.assertTrue(registrationOpj.registrationSuccss.getText().contains("registration completed"));
		registrationOpj.continueAfterRegistration();
		shoppingCartOpj.openCheckoutPage();
		Assert.assertTrue(CheckoutOpj.checkoutPageTitle.isDisplayed());
		CheckoutOpj.registerdUserCheckout(country, city, address, zipCode, phoneNum);
		Assert.assertTrue(CheckoutOpj.successMessage.isDisplayed());
		CheckoutOpj.openOrderDetailsLink();
		OrderDetailsOpj= new OrderDetailsPage(driver);
		Assert.assertTrue(OrderDetailsOpj.orderInfoPageTitle.isDisplayed());
		OrderDetailsOpj.downloadPdfInvoice();
		OrderDetailsOpj.openPrintOrderInfoPage();
	}

	@Test(priority = 3)
	public void userLogoutSuccss() {

		registrationOpj.userLogout();
	}
}
