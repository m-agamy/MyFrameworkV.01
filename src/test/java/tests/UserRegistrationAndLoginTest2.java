package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class UserRegistrationAndLoginTest2 extends TestBase {

	/*String firstName= "agamy";
	String lastName= "Test11";
	String userMail= "anaagamy1333@yahoo.com";
	String userPass= "Test12345678";*/
	
	HomePage homeOpj;
	RegistrationPage registrationOpj;
	LoginPage loginOpj;
	@DataProvider(name ="UserRegistrationData")
	public Object[][] UserRegistrationData() throws IOException{
	
		String sheetName="UserRegistrationData";
		ExcelReader readerObj= new ExcelReader();
		Object excelDataAr [][]=readerObj.getExcelData(sheetName, 4);
		return excelDataAr;
	} 
	

	@Test(priority = 1,dataProvider = "UserRegistrationData")
	public void userRegistrationSuccss(String firstName,String lastName,String userMail,String userPass) {

		homeOpj= new HomePage(driver);
		homeOpj.openRegistrationPage();
		registrationOpj= new RegistrationPage(driver);
		registrationOpj.userRegistration(firstName,lastName , userMail, userPass);
		Assert.assertTrue(registrationOpj.registrationSuccss.getText().contains("registration completed"));
		registrationOpj.userLogout();
/*	registrationOpj.userLogout();
		homeOpj.openLoginpage();
		loginOpj=new LoginPage(driver);
		loginOpj.userLogin(userMail, userPass);
		Assert.assertTrue(registrationOpj.LogoutLink.getText().contains("Log out"));
		registrationOpj.userLogout();*/
	}
	//,enabled = false
	@Test(priority = 2,dataProvider = "UserRegistrationData")
	public void userLoginSuccss(String firstName,String lastName,String userMail,String userPass) {

		homeOpj.openLoginpage();
		loginOpj=new LoginPage(driver);
		loginOpj.userLogin(userMail, userPass);
		Assert.assertTrue(registrationOpj.LogoutLink.getText().contains("Log out"));
		registrationOpj.userLogout();
	}
}
