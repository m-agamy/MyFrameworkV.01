package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase  {

	HomePage homePageOpj;

	@Test
	public void UserSelectCellPhonesFromeElectronicsHoverMenu() {

		homePageOpj= new HomePage(driver);
		homePageOpj.selectCellPhonesHoverMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("cell-phones"));
	}
}
