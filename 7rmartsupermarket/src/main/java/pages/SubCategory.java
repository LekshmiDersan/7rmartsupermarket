package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategory {
	public WebDriver driver;

	public SubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
	WebElement newsubcategory;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement selectcategory;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryname;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement browseimage;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class=alert alert-danger alert-dismissible']")
	WebElement alert;

	public SubCategory clickNewSubcategory() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, newsubcategory);
		newsubcategory.click();
		return this;

	}

	public SubCategory selectcategorydropdown() {
		PageUtility pageutility = new PageUtility();
		pageutility.elementSelectByIndex(selectcategory, 1);
		return this;
	}

	public SubCategory typesubcategoryName(String catname) {
		subcategoryname.sendKeys(catname);
		return this;
	}

	public SubCategory Clickbrowse() {
		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.sendKeysforFileUpload(browseimage, Constant.SUBCATIMG);
		return this;
	}

	public SubCategory ClicksaveButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}

	public boolean isalertisloaded() {
		return alert.isDisplayed();
	}

}
