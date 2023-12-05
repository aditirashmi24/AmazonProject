package org.project.Amazon_Project.pageobjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	WebDriver driver;
	Actions action;

	public ActionClass(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
	}

	public void scrollUp() {
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	}

	public void scrollDown() {
		action.keyUp(Keys.CONTROL).sendKeys(Keys.END).perform();
	}

	public void DoubleClick(WebElement input) {
		action.doubleClick(input).perform();
	}

	public void ImplicitWait(int n) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(n));
	}

}
