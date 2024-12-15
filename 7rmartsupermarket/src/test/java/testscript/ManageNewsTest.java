package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.ManageNews;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	public Home homepage;
	public  ManageNews managenews;

	@Test
	public void enterTheNews() throws IOException
	{
		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
  
		managenews=homepage.clickManageNews();
		String heading = ExcelUtility.readStringData(0, 0, "news");
		managenews.clicknewNews().enternews(heading).clicksavebutton();
		
		boolean mandatoryfield =managenews.isalertisloaded();
		Assert.assertTrue(mandatoryfield, Constant.ERRORMESSAGEFORMANDATORYFIELD);
}
}
