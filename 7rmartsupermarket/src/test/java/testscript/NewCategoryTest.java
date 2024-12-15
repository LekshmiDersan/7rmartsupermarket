package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.NewCategory;
import utilities.ExcelUtility;

public class NewCategoryTest extends Base {
	public Home homepage;
	public NewCategory newcategory;
  @Test
  @Parameters({"categoryname"})
  public void createNewCategory(String categoryname) throws IOException {
	  String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage login = new LoginPage(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		
		newcategory=homepage.clickCategory();
		newcategory.clickNewCategory().typeCategoryName(categoryname).selectGroups().Clickbrowse().checktopradiobutton().checkleftradiobutton().clicksaveButton();
		
		boolean alertmsgisloaded = newcategory.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORNORESULT);
  }

}

