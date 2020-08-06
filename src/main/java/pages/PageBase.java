package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver;
	public Select select;
	public Actions action;

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

	protected static void clearText (WebElement txtBox) {

		txtBox.clear();
	}

}
