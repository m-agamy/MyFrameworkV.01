package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase{

	public AddProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;

	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxt;

	@FindBy(id = "addproductrating_3")
	WebElement ratingRadBtn;

	@FindBy(css = "input.button-1.write-product-review-button")
	WebElement submitReviewBtn;

	@FindBy(css = "div.result")
	public WebElement reviewsuccssMesssage;
	
	public void sendProductReview(String reviewTitle, String review ) {
		
		setText(reviewTitleTxt, reviewTitle);
		setText(reviewTxt, review);
		clickBtn(ratingRadBtn);
		clickBtn(submitReviewBtn);
	}

}
