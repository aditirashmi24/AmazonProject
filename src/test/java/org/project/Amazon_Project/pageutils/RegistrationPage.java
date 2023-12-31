package org.project.Amazon_Project.pageutils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage {
	WebDriver driver;
	WebDriverWait wait;
	protected static Logger logger = LogManager.getLogger();
	By name = By.xpath("//input[@id='ap_customer_name']");
	By email = By.xpath("//input[@id='ap_email']");
	By password = By.xpath("//input[@id='ap_password']");
	By check_password = By.xpath("//input[@id='ap_password_check']");
	By submit = By.xpath("//input[@id='continue']");
	By wrong_email_alert = By.xpath("//*[@id='auth-email-missing-alert']/div/div");
	By successful_alert = By.xpath("//span[@class='a-size-large']");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		logger.info("Registration Page opens");
	}

	public void EnterName(String input) {
		WebElement FirstName = driver.findElement(name);
		wait.until(ExpectedConditions.elementToBeClickable(FirstName));
		FirstName.sendKeys(input);
		logger.info("Enter Name");
	}

	public void EnterEmail(String input) {
		WebElement Email = driver.findElement(email);
		Email.sendKeys(input);
		logger.info("Enter Email");
	}

	public void EnterPassword(String input) {
		WebElement Password = driver.findElement(password);
		Password.sendKeys(input);
		WebElement PasswordCheck = driver.findElement(check_password);
		PasswordCheck.sendKeys(input);
		logger.info("Enter Password");
	}

	public void Submit() {
		WebElement Submit = driver.findElement(submit);
		Submit.click();
		logger.info("Click on submit button");
	}

	public void AuthenticationCheck(String input) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String Actual = driver.getTitle();
		String Expected = input;
		Assert.assertTrue(Actual.contains(Expected));
		logger.info("Authentication page opens");
	}
}
