package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div.page-title")
	public WebElement orderInfoPageTitle; // To Assert it
	
	@FindBy(linkText = "Print")
	WebElement printOrderInfoLink;
	
	@FindBy(linkText = "PDF Invoice")
	WebElement downloadPdfLink;
	
	public void openPrintOrderInfoPage() {
	clickBtn(printOrderInfoLink);	
	}
	
	public void downloadPdfInvoice() {
		clickBtn(downloadPdfLink);
	}
	
	

}
