package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public WebDriver driver;

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		// code for click save button.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit Wait
		wait.until(ExpectedConditions.elementToBeClickable(element)); // explicit Wait
	}

}
