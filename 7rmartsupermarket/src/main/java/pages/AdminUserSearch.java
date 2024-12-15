package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUserSearch {
	public WebDriver driver;

	public AdminUserSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='un']")
	WebElement usernamefield;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement usertypefield;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchbutton;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement alert;
	

	public AdminUserSearch typeusernamesearchtext1(String adminusername1) {
		usernamefield.sendKeys(adminusername1);
		return this;
	}

	public AdminUserSearch usertypedropdown() {
		PageUtility pageutility = new PageUtility();
		pageutility.elementSelectByIndex(usertypefield, 1);
		return this;
	}

	public AdminUserSearch clicksearchbutton() {
		searchbutton.click();
		return this;
	}

	public boolean isResultisLoaded() {
		return alert.isDisplayed();
	}

} 