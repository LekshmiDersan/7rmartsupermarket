package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContact {
	public WebDriver driver;

	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//p[text()='Manage Contact']")WebElement manage;
	// @FindBy(xpath="//i[@class='fas fa-edit']")WebElement action;
	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")WebElement
	// action;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement action;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement address;
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	WebElement time;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement limit;
	//@FindBy(xpath = "//button[@name='Update']")
	//WebElement update;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageContact clickAction() {
		action.click();
		return this;
	}

	public ManageContact enterPhonenumber(String num) {
		phone.sendKeys(num);
		return this;
	}

	public ManageContact enteremailAddress(String mailid) {
		email.sendKeys(mailid);
		return this;
	}

	public ManageContact enterAddress(String Address) {
		address.sendKeys(Address);
		return this;
	}

	public ManageContact enterDeliverytime(String deliverytime) {
		time.sendKeys(deliverytime);
		return this;
	}

	public ManageContact enterDeliveryChargelimit(String chargelimit) {
		limit.sendKeys(chargelimit);
		return this;

	}

	public ManageContact clickupdate() {
		update.click();
		return this;
	}

	public boolean isalertisloaded() {
		return alert.isDisplayed();// checking assertion
	}

}
