package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUser {
	public WebDriver driver;

	public AdminUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	
	public AdminUser creatreNewUser() {
		newbutton.click();
		return this;
	}

	public AdminUser newusername(String newusernamefield) {
		usernamefield.sendKeys(newusernamefield);
		return this;

	}

	public AdminUser newpassword(String newpasswordfield) {
		passwordfield.sendKeys(newpasswordfield);
		return this;

	}

	public AdminUser usertypeDropdown() {
		PageUtility pageutility = new PageUtility();
		pageutility.elementSelectByIndex(usertype, 3);
		return this;
	}
	

	public AdminUser save() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}

	public boolean isalertisloaded() {
		return alert.isDisplayed();// checking assertion
	}
}
