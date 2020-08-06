package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class GuestUserCheckoutTest extends TestBase {
	String productLitters1="HTC One M8 Android";
	String productLitters2="Nokia Lumia";
	String firstName= "agamy";
	String lastName= "Test11";
	String email= "anaagamy21@yahoo.com";
	String country= "Albania";
	String city= "berat";
	String address= "25 main St";
	String zipCode= "12345";
	String phoneNum= "0255448877";

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
	public void gestUserCanChechoutProduct() {

		shoppingCartOpj.openCheckoutPage();
		CheckoutOpj= new CheckoutPage(driver);
		Assert.assertTrue(CheckoutOpj.checkoutPageTitle.isDisplayed());
		CheckoutOpj.openGuestCheckoutPage();
		CheckoutOpj.guestUserCheckout(firstName, lastName, email, country, city, address, zipCode, phoneNum);
		Assert.assertTrue(CheckoutOpj.successMessage.isDisplayed());
		CheckoutOpj.openOrderDetailsLink();
		OrderDetailsOpj= new OrderDetailsPage(driver);
		Assert.assertTrue(OrderDetailsOpj.orderInfoPageTitle.isDisplayed());
		OrderDetailsOpj.downloadPdfInvoice();
		OrderDetailsOpj.openPrintOrderInfoPage();
	}
}
