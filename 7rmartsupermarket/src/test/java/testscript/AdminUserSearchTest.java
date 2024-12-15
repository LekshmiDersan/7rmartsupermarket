package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUser;
import pages.AdminUserSearch;
import pages.Home;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserSearchTest extends Base {
	public Home homepage;
	public AdminUser adminuser;
	public AdminUserSearch usersearch;

	@Test
	@Parameters({ "adminusername1" })
	public void searchAdminUser(String adminusername1) throws IOException {

		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		
		adminuser = homepage.clickAdminUser();
		usersearch = homepage.clickAdminUserSearch();
		usersearch.typeusernamesearchtext1(adminusername1).usertypedropdown().clicksearchbutton();

		boolean alertmsgisloaded = usersearch.isResultisLoaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORNORESULT);
	}
}
