package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {

	@DataProvider(name = "Credentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" }, { "lekshmi", "12345" }, { "ajitha", "home" } };
		return data;

	}

	@Test(dataProvider = "Credentials")
	public void verifywithValidUserNameandValidPassword(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		login.loginButton();

		boolean homepageisloaded = login.isHomePageIsLoaded();
		Assert.assertTrue(homepageisloaded, Constant.ERRORMESSAGEFORLOGIN);

	}

	@Test
	@Parameters({ "username", "password" })
	public void verifywithValidUserNameandInvalidPassword(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		login.loginButton();

		boolean loginpageisnotloaded = login.isHomePageIsLoaded();
		Assert.assertTrue(loginpageisnotloaded, Constant.ERRORMESSAGEFORLOGIN);

	}

	@Test
	@Parameters({ "username", "password" })
	public void verifywithInvalidUserNameandValidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(ExcelUtility.readStringData(2, 0, "Login"), ExcelUtility.readStringData(2, 1, "Login"));
				login.loginButton();

		boolean loginpageisnotloaded = login.isHomePageIsLoaded();
		Assert.assertTrue(loginpageisnotloaded, Constant.ERRORMESSAGEFORLOGIN);

	}

	@Test
	@Parameters({ "username", "password" })
	public void verifywithInvalidUserNameandInvalidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(ExcelUtility.readStringData(2, 0, "Login"), ExcelUtility.readStringData(2, 1, "Login"));
				login.loginButton();

		boolean loginpageisnotloaded = login.isHomePageIsLoaded();
		Assert.assertTrue(loginpageisnotloaded, Constant.ERRORMESSAGEFORLOGIN);

	}

}