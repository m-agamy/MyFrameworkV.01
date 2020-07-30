package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase {

	public WishlistPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "removefromcart")
	public List<WebElement> removeFromCartListBtn;

	@FindBy(name = "addtocart")
	public List<WebElement> addtocartListBtn;

	@FindBy(css = "a.product-name")
	public List<WebElement> productTitleList;

	@FindBy(css = "input.button-2.update-wishlist-button")
	WebElement updatecartBtn;

	@FindBy(css = "input.button-2.wishlist-add-to-cart-button")
	WebElement addToCartBtn;

	@FindBy(css = "div.page-title")
	public WebElement shoppingCartPageTitel;

	public List<WebElement> removeFromCartList (){
		return removeFromCartListBtn;
	}

	public List<WebElement> addtocartList(){
		return addtocartListBtn;
	}

	public void updateWishlist (){

		clickBtn(updatecartBtn);
	}

	public void removeFromcart (Integer indx){

		removeFromCartList().get(indx).click();
		clickBtn(updatecartBtn);

	}
	public void addProductToCart (Integer indx){

		addtocartList().get(indx).click();
		clickBtn(addToCartBtn);

	}
}
