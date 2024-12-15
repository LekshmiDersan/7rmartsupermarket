package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubcategorySearch {
	public WebDriver driver;

	public SubcategorySearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement subcatsearch;
	@FindBy(xpath = "//select[@id='un']")
	WebElement categorydropdown;
	@FindBy(xpath = "//input[@placeholder='Sub Category']")
	WebElement subcat;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement search;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement alert;

	public SubcategorySearch clicksubcatsearch() {
		subcatsearch.click();
		return this;
	}

	public SubcategorySearch clickCategoryDropdown(String text) {
		Select select = new Select(categorydropdown);
		select.selectByVisibleText(text);
		return this;
	}

	public SubcategorySearch subcategoryname(String name) {
		subcat.click();
		return this;
	}

	public SubcategorySearch clickSearch() {
		search.click();
		return this;
	}

	public boolean isResultisLoaded() {
		return alert.isDisplayed();
	}

}
