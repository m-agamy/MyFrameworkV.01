package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginpageTest extends TestBase {
	
	WebElement emailTextBox= driver.findElement(By.id("Email"));
	WebElement passwordTextBox= driver.findElement(By.id("Password"));
	WebElement loginBtn= driver.findElement(By.id("login-button"));
	WebElement successMessage= driver.findElement(By.cssSelector("div.text"));
	WebElement errorMessage= driver.findElement(By.cssSelector("div.text"));
	WebElement validationErrorMessage= driver.findElement(By.cssSelector("div.validation.message"));
	

	@Test
	public void testLoginFormPresent() {
		
		Assert.assertTrue(emailTextBox.isDisplayed());
		Assert.assertTrue(passwordTextBox.isDisplayed());
		Assert.assertTrue(loginBtn.isDisplayed());
	
	}
	@Test
	public void userCanLoginWithValidcredentials() {
		
		emailTextBox.sendKeys("login@codility.com");
		passwordTextBox.sendKeys("password");
		loginBtn.click();
		Assert.assertTrue(successMessage.getText().contains("By creating an"));
	}
	@Test
	public void userCannotLoginWithInvalidcredentials() {
		
		emailTextBox.sendKeys("unknown@codility.com");
		passwordTextBox.sendKeys("password");
		loginBtn.click();
		Assert.assertTrue(errorMessage.getText().contains("You shall not pass"));
	}
	@Test
	public void loginWithInvalidEmailForm() {
		
		emailTextBox.sendKeys("logincodility");
		passwordTextBox.sendKeys("password");
		loginBtn.click();
		Assert.assertTrue(validationErrorMessage.getText().contains("Enter a valid email "));
	}
	@Test
	public void cannotloginWithEmptyEmailForm() {
		
		passwordTextBox.sendKeys("password");
		loginBtn.click();
		Assert.assertTrue(validationErrorMessage.getText().contains("Email is required"));
	}
	@Test
	public void cannotloginWithEmptyPasswordForm() {
		
		emailTextBox.sendKeys("login@codility.com");
		loginBtn.click();
		Assert.assertTrue(validationErrorMessage.getText().contains("Password is required"));
	}
	
}