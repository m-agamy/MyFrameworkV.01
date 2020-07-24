package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchForProductTest extends TestBase {

	String fullProductName="Beats Pill 2.0 Wireless Speaker";
	SearchPage searchPageOpj;
	ProductDetailsPage detailsOpj;

	@Test
	public void UserSearchForProduct () {

		searchPageOpj= new SearchPage(driver);
		detailsOpj= new ProductDetailsPage(driver);
		searchPageOpj.searchForProduct(fullProductName);
		searchPageOpj.openProductDetalisPage();
		Assert.assertTrue(detailsOpj.productName.getText().contains(fullProductName));
	}
}
