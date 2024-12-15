package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.SubCategory;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	public Home homepage;
	public SubCategory newsubcategory;

	@Test
	@Parameters({ "subcatname" })
	public void createNewSubCategory(String subcategoryname) throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		
		 newsubcategory=homepage.clickSubCategory();
		
		newsubcategory.clickNewSubcategory().selectcategorydropdown().typesubcategoryName(subcategoryname).Clickbrowse().ClicksaveButton();
		boolean alertmsgisloaded = newsubcategory.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORNORESULT);

	}
}