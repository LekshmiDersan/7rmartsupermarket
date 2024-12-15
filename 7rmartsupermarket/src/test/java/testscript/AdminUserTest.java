package testscript;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AdminUser;
import pages.Home;
import pages.LoginPage;
import utilities.ExcelUtility;

import java.io.IOException;

import org.testng.Assert;
import constants.Constant;

public class AdminUserTest extends Base {
	public Home homepage;
	public AdminUser adminuser;

	@Test
	@Parameters({"adminusername","adminpassword"})
	public void addAdminUser(String adminusername,String adminpassword) throws IOException
	{

		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		  
		adminuser = homepage.clickAdminUser();
		adminuser.creatreNewUser();
		adminuser.creatreNewUser().newusername(adminusername).newpassword(adminpassword).usertypeDropdown().save();

		boolean alertmsgisloaded = adminuser.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);
	}
}
