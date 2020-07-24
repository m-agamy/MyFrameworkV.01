package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;

	@FindBy(css = "input.button-1.search-box-button")
	WebElement SearchBtn;

	@FindBy(css = "div.product-item")
	WebElement productItem;

	@FindBy(id = "ui-id-1")
	List <WebElement> productList;

	public void searchForProduct(String fullProductName) {

		setText(searchTxtBox, fullProductName);
		clickBtn(SearchBtn);
	}

	public void searchUsingAutoSuggest(String productLitters) {

		setText(searchTxtBox, productLitters);
		productList.get(0).click();
	}

	public void openProductDetalisPage() {

		clickBtn(productItem);
	}

}
