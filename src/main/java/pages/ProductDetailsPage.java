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

	@FindBy(linkText = "Be the first to review this product")
	public WebElement addFirstReviewLink;

	@FindBy(linkText = "Add your review")
	public WebElement addNewReviewLink;

	@FindBy(css = "div.add-to-wishlist")
	public WebElement addtoWishlistBtn;

	@FindBy(linkText = "wishlist")
	WebElement wishlistLink;

	@FindBy(css = "div.compare-products")
	WebElement addtoCompareListtBtn;

	@FindBy(linkText = "Compare products list")
	WebElement compareListLink;

	public void openEmailAfriendPage() {

		clickBtn(emailAfriendBtn);
	}

	public void openAddReviewPage() {
		try {
			clickBtn(addFirstReviewLink);

		} catch (Exception e) {
			System.out.println("Not first Review");
		}

		try {
			clickBtn(addNewReviewLink);

		} catch (Exception e) {
			System.out.println("First Review");
		}
	}

	public void addProductToWishlist() {

		clickBtn(addtoWishlistBtn);
	}

	public void openProductsWishlist() {

		clickBtn(wishlistLink);
	}

	public void addProductToCompareList() {

		clickBtn(addtoCompareListtBtn);
	}

	public void openCompareList() {

		clickBtn(compareListLink);
	}
}
