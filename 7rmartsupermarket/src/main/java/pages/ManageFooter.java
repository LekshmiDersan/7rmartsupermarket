package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooter {
	public WebDriver driver;

	public ManageFooter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")WebElement editbutton;
	@FindBy(xpath="//textarea[@id='content']")WebElement addressfield;
	@FindBy(xpath="//input[@id='email']")WebElement mailidfield;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenum;
	@FindBy(xpath="//button[@name='Update']")WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public ManageFooter clickeditButton() {
		 editbutton.click();
		return this;
	}
	public ManageFooter enterAddress(String address) {
		addressfield.sendKeys(address);
		return this;
	}
	public ManageFooter enterMailId(String id) {
		 mailidfield.sendKeys(id);
		return this;
	}
	public ManageFooter enterPhoneNumber(String number) {
		phonenum.sendKeys(number);
		return this;
	}
	public ManageFooter clickUpdateButton() {
		mailidfield.click();
		return this;
	}
	public boolean isalertisLoaded() {
		return alert.isDisplayed();
	}
	
		
		
	

}
