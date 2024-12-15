package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;
import pages.Home;

public class HomePagetest extends Base {
	public Home homepage;
	
	@Test
	public void verifylogOut() throws IOException  {
		String username=ExcelUtility.readStringData(3, 0, "Login");
		String password=ExcelUtility.readStringData(3, 1, "Login");
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		homepage=login.loginButton();

		homepage.clickAdmin();
		homepage.clickLogout();
		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket", "Logout failed");
	}
}