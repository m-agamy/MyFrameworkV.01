package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div.product-name")
	public WebElement productName;
	
	@FindBy(css = "div.product-price")
	public WebElement productPrice;
	
	@FindBy(css = "input.button-2.email-a-friend-button")
	WebElement emailAfriendBtn;
	
	public void openEmailAfriendPage() {
		
		clickBtn(emailAfriendBtn);
	}
	
	
}
