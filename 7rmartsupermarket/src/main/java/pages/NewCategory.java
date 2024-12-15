package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class NewCategory {
	public WebDriver driver;

	public NewCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement add;

	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryfield;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement groups;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement browse;
	@FindBy(xpath = "//input[@name='top_menu']")
	WebElement radiotopbutton;
	@FindBy(xpath = "(//input[@value='no'])[2]")
	WebElement radioleftbutton;
	//@FindBy(xpath = "//button[text()='Save']")	WebElement savebutton;
	//@FindBy(xpath = "//button[type='submit']")WebElement savebutton;
	@FindBy(xpath="//div[text()='Save']")WebElement savebutton;
	@FindBy(xpath = "//input[@class=alert alert-danger alert-dismissible']")
	WebElement alert;

	public NewCategory clickNewCategory() {
		add.click();
		return this;
	}

	public NewCategory typeCategoryName(String name) {
		categoryfield.sendKeys(name);
		return this;
	}

	public NewCategory selectGroups() {
		groups.click();
		return this;
	}

	public NewCategory Clickbrowse() {
		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.sendKeysforFileUpload(browse, Constant.CATIMG);
		return this;
	}
	public NewCategory checktopradiobutton() {
		radiotopbutton.click();
		return this;
	}

	public NewCategory checkleftradiobutton() {
		radioleftbutton.click();
		return this;
	}

	public NewCategory clicksaveButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}

	public boolean isalertisloaded() {
		return alert.isDisplayed();
	}

}
