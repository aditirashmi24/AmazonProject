package org.project.Amazon_Project.pageutils;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.project.Amazon_Project.pageobjects.ReadData;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	protected static Logger logger = LogManager.getLogger();
	ReadData data = new ReadData();
	By my_account = By.xpath("//a[@id='nav-link-accountList']");
	By register = By.xpath("//a[@id='createAccountSubmit']");
	By search = By.id("twotabsearchtextbox");
	By search_result = By.xpath("//span[@class='a-color-state a-text-bold']");
	By dress_category = By.xpath("//img[@alt='Dresses']");
	By cart = By.xpath("//a[@id='nav-cart']");

	public HomePage(WebDriver driver) {
		// this.driver = null ;
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}

	public void OpenHomePage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		logger.info("Amazon Page opens");
	}

	public WebElement OpenMyAccount() {
		WebElement myAccount = driver.findElement(my_account);
		wait.until(ExpectedConditions.elementToBeClickable(myAccount));
		return myAccount;
	}

	public void OpenRegistration() {
		WebElement registration = driver.findElement(register);
		wait.until(ExpectedConditions.elementToBeClickable(registration));
		registration.click();
		logger.info("Registration page opens");
	}

	public void ClickOnSearch() {
		wait.until(ExpectedConditions.presenceOfElementLocated(search));
		WebElement Search = driver.findElement(search);
		Search.click();
		logger.info("search button clicked");
	}

	public void SearchFor(String input) {
		wait.until(ExpectedConditions.presenceOfElementLocated(search));
		WebElement Search = driver.findElement(search);
		Search.sendKeys(input);
		Search.submit();
		logger.info("Item is searched");
	}

	public void NotificationCheck() throws IOException {
		wait.until(ExpectedConditions.presenceOfElementLocated(search_result));
		String Expected = data.GetItemName();
		String Actual = driver.findElement(search_result).getText();
		Assert.assertTrue(Actual.contains(Expected));
		logger.info("Searched Item is validated");
	}

}
