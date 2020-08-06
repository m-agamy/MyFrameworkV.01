package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class ShoppingCartAddAndRemoveProductsTest extends TestBase {

	String productLitters1="HTC One M8 Android";
	String productLitters2="Nokia Lumia";

	SearchPage searchPageOpj;
	ProductDetailsPage detailsOpj;
	ShoppingCartPage shoppingCartOpj;

	//search for 2 products and add it to Shopping Cart.
	@Test(priority = 1)
	public void userAddProductsToShoppingCart() {

		searchPageOpj= new SearchPage(driver);
		detailsOpj= new ProductDetailsPage(driver);
		searchPageOpj.searchUsingAutoSuggest(productLitters1);
		detailsOpj.addProductToShoppingCart();
		searchPageOpj.searchUsingAutoSuggest(productLitters2);
		detailsOpj.addProductToShoppingCart();
	}
	//Remove product 1 from the Shopping Cart and change product 2 quantity to 2 then remove it;
	@Test(priority = 2)
	public void userRemoveProductsFromeShoppingCart() {

		shoppingCartOpj= new ShoppingCartPage(driver);
		detailsOpj.openShoppingCart();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/cart"));
		shoppingCartOpj.removeProductFromSoppingCart(0);
		shoppingCartOpj.updateCart();
		shoppingCartOpj.setQtyOfProduct(0, 2);
		shoppingCartOpj.updateCart();
		Assert.assertTrue(shoppingCartOpj.totalPrice.getText().contains("698.00"));
		shoppingCartOpj.removeProductFromSoppingCart(0);
		shoppingCartOpj.updateCart();
		Assert.assertTrue(shoppingCartOpj.emptyCartMessg.getText().contains("Shopping Cart is empty"));
	}
}
