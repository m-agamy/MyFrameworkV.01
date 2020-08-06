package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "removefromcart")
	List<WebElement> removeProductBtns;
	
	@FindBy(css = "input.qty-input")
	List<WebElement> qtyTxtBoxs;
	
	@FindBy(name = "updatecart")
	WebElement updateCartBtn;

	@FindBy(css = "span.product-subtotal")
	public WebElement totalPrice;
	
	@FindBy(css = "div.no-data")
	public WebElement emptyCartMessg;
	
	@FindBy(id = "termsofservice")
	WebElement termsOfServiceBtn;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	
	public List<WebElement> removeProductBtnsList() {
		return removeProductBtns;
	}
	
	public void removeProductFromSoppingCart(Integer indx) {
		
		removeProductBtnsList().get(indx).click();
	}
	
	public List<WebElement> qtyTxtBoxList() {
		return qtyTxtBoxs;
	}
	
	public void updateCart() {
		clickBtn(updateCartBtn);
	}
	
	public void setQtyOfProduct(Integer indx, Integer qtyNo) {
		clearText(qtyTxtBoxList().get(indx));
	    qtyTxtBoxList().get(indx).sendKeys(String.valueOf(qtyNo));
	}
	
	public void openCheckoutPage() {
		
		clickBtn(termsOfServiceBtn);
		clickBtn(checkoutBtn);
	}
}
