package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	protected static void clickBtn (WebElement btnElement) {
	
		btnElement.click();
	}
	
	protected static void setText (WebElement txtBox , String text ) {
		
		txtBox.sendKeys(text);
	}
}
