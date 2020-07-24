package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

	String productLitters="Beats Pill";
	String currencyValue= "Euro";
	String currencySign="€";
	SearchPage searchPageOpj;
	HomePage homeOpj;
	ProductDetailsPage detailsOpj;

	@Test(priority = 1)
	public void userSearchByAutoSuggest() {
		try {
			searchPageOpj= new SearchPage(driver);
			detailsOpj= new ProductDetailsPage(driver);
			searchPageOpj.searchUsingAutoSuggest(productLitters);
			Assert.assertTrue(detailsOpj.productName.getText().contains(productLitters));
		} catch (Exception e) {
			System.out.println(" Error  " + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void userChangeCurrency() {

		homeOpj= new HomePage(driver);
		homeOpj.currencyChainge(currencyValue);
		Assert.assertTrue(detailsOpj.productPrice.getText().contains(currencySign));
	}
}
