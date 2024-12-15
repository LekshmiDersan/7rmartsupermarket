package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.ManageFooter;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	public Home homepage;
	public ManageFooter editfooter;
  @Test
  public void editfootertext() throws IOException {
	  String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		editfooter=homepage.clickManageFooter();
		 String address = ExcelUtility.readStringData(0, 0, "footer");
			String id= ExcelUtility.readStringData(1, 0, "footer");
		String phone=ExcelUtility.readIntegerCellValue(2, 0, "footer");
		editfooter.clickeditButton().enterAddress(address).enterMailId(id).enterPhoneNumber(phone).clickUpdateButton();
		
		boolean alertmsgisloaded = editfooter.isalertisLoaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORNORESULT);
  }
}
