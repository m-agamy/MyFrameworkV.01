package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CompareListAddAndRemoveTest extends TestBase {

	String productLitters1="HTC One M8 Android";
	String productLitters2="HTC One Mini";
	String productLitters3="Nokia Lumia";
	String productLitters4="Apple MacBook Pro";

	SearchPage searchPageOpj;
	ProductDetailsPage detailsOpj;
	CompareListPage compareOpj;

	//search for 3 products and add it to Compare List.
	@Test(priority = 1)
	public void userAddProductsToCompareList() {

		searchPageOpj= new SearchPage(driver);
		detailsOpj= new ProductDetailsPage(driver);
		searchPageOpj.searchUsingAutoSuggest(productLitters1);
		detailsOpj.addProductToCompareList();
		searchPageOpj.searchUsingAutoSuggest(productLitters2);
		detailsOpj.addProductToCompareList();
		searchPageOpj.searchUsingAutoSuggest(productLitters3);
		detailsOpj.addProductToCompareList();
		searchPageOpj.searchUsingAutoSuggest(productLitters4);
		detailsOpj.addProductToCompareList();
	}
	//Remove product 1 and 3 from the compare list and remove all compare list content.
	@Test(priority = 2)
	public void userRemoveProductsFromeCompareList() {
		
		compareOpj= new CompareListPage(driver);
		detailsOpj.openCompareList();
		Assert.assertTrue(compareOpj.compareListPageTitle.isDisplayed());
		compareOpj.removeProductFromeCompareList(0);
		compareOpj.removeProductFromeCompareList(2);
		compareOpj.clearCompareList();
		Assert.assertTrue(compareOpj.emptyCompareListMess.getText().contains("no items"));
	}
}
