package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input.button-1.register-button")
	WebElement registerBtn;

	@FindBy(css = "input.button-1.checkout-as-guest-button")
	WebElement checkoutAsGuestBtn;

	@FindBy(css = "div.page-title")
	public WebElement checkoutPageTitle;

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstNameTxtBox;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastNameTxtBox;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxtBox;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryDropList;

	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxtBox;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address1TxtBox;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipCodeTxtBox;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxtBox;

	@FindBy(css = "input.button-1.new-address-next-step-button")
	WebElement continueBillingAddressBtn;

	@FindBy(id = "shippingoption_1")
	WebElement nextDayshippingMethodRdoBtn;

	@FindBy(css = "input.button-1.shipping-method-next-step-button")
	WebElement continueShippingMethodBtn;

	@FindBy(id = "paymentmethod_0")
	WebElement moneyOrderPaymentRdoBtn;

	@FindBy(id = "paymentmethod_1")
	WebElement creditCardPaymentRdoBtn;

	@FindBy(css = "input.button-1.payment-method-next-step-button")
	WebElement continuePaymentMethodBtn;

	@FindBy(css = "input.button-1.payment-info-next-step-button")
	WebElement continuePaymentInfoBtn;

	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	WebElement continueConfirmOrderBtn;

	@FindBy(css = "div.title")
	public WebElement successMessage; //Your order has been successfully processed!

	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;

	@FindBy(css = "input.button-1.order-completed-continue-button")
	WebElement continueOrderCompletedBtn;


	public void registerdUserCheckout(String country, String city, String address, String zipCode, String phoneNum ) {

		Select countryLit = new Select(countryDropList);
		countryLit.selectByVisibleText(country);
		setText(cityTxtBox, city);
		setText(address1TxtBox, address);
		setText(zipCodeTxtBox, zipCode);
		setText(phoneNumberTxtBox, phoneNum);
		clickBtn(continueBillingAddressBtn);
		clickBtn(nextDayshippingMethodRdoBtn);
		clickBtn(continueShippingMethodBtn);
		clickBtn(continuePaymentMethodBtn);
		clickBtn(continuePaymentInfoBtn);
		clickBtn(continueConfirmOrderBtn);
	}
	
	public void guestUserCheckout(
	String firstName  ,String lastName  ,String email  ,String country, String city, String address, String zipCode, String phoneNum ) {
		
		setText(firstNameTxtBox, firstName);
		setText(lastNameTxtBox, lastName);
		setText(emailTxtBox, email);
		Select countryLit = new Select(countryDropList);
		countryLit.selectByVisibleText(country);
		setText(cityTxtBox, city);
		setText(address1TxtBox, address);
		setText(zipCodeTxtBox, zipCode);
		setText(phoneNumberTxtBox, phoneNum);
		clickBtn(continueBillingAddressBtn);
		clickBtn(nextDayshippingMethodRdoBtn);
		clickBtn(continueShippingMethodBtn);
		clickBtn(continuePaymentMethodBtn);
		clickBtn(continuePaymentInfoBtn);
		clickBtn(continueConfirmOrderBtn);
	}


	public void openOrderDetailsLink() {
		clickBtn(orderDetailsLink);
	}

	public void confirmOrder() {
		clickBtn(continueOrderCompletedBtn);
	}

	public void openRegistrationPage() {
		clickBtn(registerBtn);
	}
	
	public void openGuestCheckoutPage() {
		clickBtn(checkoutAsGuestBtn);
	}
}