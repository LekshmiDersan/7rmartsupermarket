package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.ManageContact;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	public Home homepage;
	public ManageContact managecontact;

	@Test
	public void updatecontactinformation() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		
		managecontact = homepage.clickManageContact();
		String number = ExcelUtility.readIntegerCellValue(0, 0, "Contact");
		String email = ExcelUtility.readStringData(1, 0, "Contact");
		String address = ExcelUtility.readStringData(2, 0, "Contact");
		String time = ExcelUtility.readIntegerCellValue(3, 0, "Contact");
		String limit = ExcelUtility.readIntegerCellValue(4, 0, "Contact");

		managecontact.clickAction();
		
		managecontact.enterPhonenumber(number).enteremailAddress(email).enterAddress(address)
				.enterDeliverytime(time).enterDeliveryChargelimit(limit).clickupdate();
		boolean alertmsgisloaded = managecontact.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORNORESULT);
	}
}
