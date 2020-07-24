package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchUsingAutoSuggestTest extends TestBase{
	
	String productLitters="Beats Pill";
	
	SearchPage searchPageOpj;
	ProductDetailsPage detailsOpj;
	
	@Test
	public void userSearchByAutoSuggest() {
		
		searchPageOpj= new SearchPage(driver);
		detailsOpj= new ProductDetailsPage(driver);
		searchPageOpj.searchUsingAutoSuggest(productLitters);
		Assert.assertTrue(detailsOpj.productName.getText().contains(productLitters));
	}
}
