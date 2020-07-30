package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareListPage extends PageBase {

	public CompareListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div.page-title")
	public WebElement compareListPageTitle;
	
	@FindBy(css = "div.no-data")
	public WebElement emptyCompareListMess;

	@FindBy(css = "a.clear-list")
	WebElement clearListBtn;

	@FindBy(css = "input.button-2.remove-button")
	List<WebElement> removeProductBtns;


	public List<WebElement> removeBtnsList() {
		return removeProductBtns;
	}

	public void removeProductFromeCompareList(Integer indx) {

		removeBtnsList().get(indx).click();
	}
	public void clearCompareList() {

		clickBtn(clearListBtn);
	}
}
