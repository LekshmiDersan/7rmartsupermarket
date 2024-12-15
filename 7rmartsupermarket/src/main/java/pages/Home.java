package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	public WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admindropdown;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "//body[@class='login-page']")
	WebElement loginpage;
	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[1]")
	WebElement adminusers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement adminusersearch;
	@FindBy(xpath="//p[text()='Category']")WebElement category;
	@FindBy(xpath="//p[text()='Sub Category']")WebElement subcategory;
	@FindBy(xpath = "//p[text()='Sub Category']")
	WebElement subcategoryclick;
	@FindBy(xpath = "//p[text()='Manage News']")WebElement managenews;
	@FindBy(xpath="//p[text()='Manage Contact']")WebElement manage;
	@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[10]")WebElement footertext;
	
	public void clickAdmin() {
		admindropdown.click();
	}

	public void clickLogout() {
		logout.click();
	}
	public AdminUser clickAdminUser() {
		adminusers.click();
		return new AdminUser(driver); 
	}
	public AdminUserSearch  clickAdminUserSearch() {
		adminusersearch.click();
		return new AdminUserSearch(driver);
	}

public NewCategory clickCategory() {
	category.click();
	return new NewCategory(driver);
}
public SubCategory clickSubCategory()
{
	subcategory.click();
	return new SubCategory(driver);
}
public SubcategorySearch clickSubCategorybutton()
{
	subcategoryclick.click();
	return new SubcategorySearch(driver);
}
public ManageNews clickManageNews()
{
	managenews.click();
	return new ManageNews(driver);
}
public ManageContact clickManageContact()
{
	manage.click();
	return new ManageContact(driver);
}
public ManageFooter clickManageFooter()
{
	footertext.click();
	return new ManageFooter(driver);
}
}