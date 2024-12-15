package testscript;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.SubCategory;
import pages.SubcategorySearch;
import utilities.ExcelUtility;

public class SubcategorySearchTest extends Base {
	public Home homepage;
	public SubcategorySearch searchsubcategory;

	@Test
	public void searchsubcategory() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();

		searchsubcategory = homepage.clickSubCategorybutton();
		String catvalue = ExcelUtility.readStringData(0, 0, "category");
		String subvalue = ExcelUtility.readStringData(0, 1, "category");
		searchsubcategory.clicksubcatsearch().clickCategoryDropdown(catvalue).subcategoryname(subvalue).clickSearch();
		

		boolean resultisloaded = searchsubcategory.isResultisLoaded();
		Assert.assertTrue(resultisloaded, Constant.ERRORMESSAGEFORNORESULT);
	}
}
