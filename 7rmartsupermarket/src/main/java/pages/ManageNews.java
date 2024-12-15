package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews {
	public WebDriver driver;
	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement newnews;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")WebElement enternews;
	@FindBy(xpath = "//button[@name='create']")WebElement savebutton;
	@FindBy(xpath ="//selection[@class='content']")WebElement editpage;
	
	
	
	public  ManageNews clicknewNews() {
		newnews.click();
		return this;
	}
	public  ManageNews enternews(String headline) {
		 enternews.sendKeys(headline);
		return this;
	}
	
	public  ManageNews clicksavebutton() {
		savebutton.click();
		return this;
	}
		
		public boolean isalertisloaded() {
			return editpage.isDisplayed();
}
	
}
