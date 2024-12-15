   package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")
	WebElement home;

	public LoginPage enterUserNamePasswordField(String usernamefield,String passwordfield) {
		username.sendKeys(usernamefield);
		password.sendKeys(passwordfield);
		return this;
	}

	public Home loginButton() {
			submit.click();
			return new 	Home(driver);
	}

	public boolean isHomePageIsLoaded() {
		return home.isDisplayed();
	}

}
