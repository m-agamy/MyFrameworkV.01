package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class WishlistAddAndRemoveTest extends TestBase{

	String productLitters1="HTC One M8 Android";
	String productLitters2="HTC One Mini";
	String productLitters3="Nokia Lumia";

	SearchPage searchPageOpj;
	ProductDetailsPage detailsOpj;
	WishlistPage WishlistPageOpj;
	//search for products and add it to the wish list.
	@Test(priority = 1)
	public void userAddProductsToWishlist() {

		searchPageOpj= new SearchPage(driver);
		detailsOpj= new ProductDetailsPage(driver);
		searchPageOpj.searchUsingAutoSuggest(productLitters1);
		detailsOpj.addProductToWishlist();
		searchPageOpj.searchUsingAutoSuggest(productLitters2);
		detailsOpj.addProductToWishlist();
		searchPageOpj.searchUsingAutoSuggest(productLitters3);
		detailsOpj.addProductToWishlist();
	}
	//Remove product 1 and 3 from the wish list and add product 2 the Shopping cart.
	@Test(priority = 2)
	public void userRemoveFromWishlistAndAddToCart() {

		WishlistPageOpj =new WishlistPage(driver);
		detailsOpj.openProductsWishlist();
		WishlistPageOpj.removeFromcart(0);
		WishlistPageOpj.removeFromcart(1);
		Assert.assertTrue(WishlistPageOpj.productTitleList.get(0).isDisplayed());
		WishlistPageOpj.addProductToCart(0);
		Assert.assertTrue(WishlistPageOpj.shoppingCartPageTitel.isDisplayed());
	}
}