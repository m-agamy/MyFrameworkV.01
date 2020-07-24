package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	Select currencyList;

	@FindBy(css = "a.ico-register")
	WebElement createAnAccount;
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(linkText ="My account")
	WebElement myAccountLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id = "customerCurrency")
	WebElement CurrencyDropList;
	
	public void openRegistrationPage() {
		clickBtn(createAnAccount);
	}
	
	public void openLoginpage() {
		clickBtn(LoginLink);
	}
	public void openMyAccount() {
		
		clickBtn(myAccountLink);
	}
	
	public void openContactUsPage() {
		
		clickBtn(contactUsLink);
	}
	
	public void currencyChainge(String currencyValue) {
		
		currencyList= new Select(CurrencyDropList);
		currencyList.selectByVisibleText(currencyValue);
	}
}
