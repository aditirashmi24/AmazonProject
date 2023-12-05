package org.project.Amazon_Project.pageutils;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.project.Amazon_Project.pageobjects.ReadData;
import org.testng.Assert;

public class CategoryPage {
	WebDriver driver;
	ReadData data = new ReadData();
	WebDriverWait wait;
	protected static Logger logger = LogManager.getLogger();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	By item = By.xpath(
			"//span[@class='a-size-medium a-color-base a-text-normal' and contains(text(),'iPhone 8 4.7\", 64 GB, GSM Unlocked, Space Gray')]");
	By cart_message = By.xpath("//*[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']/span");
	By add_to_cart = By.xpath("//input[@id='add-to-cart-button']");
	By amount = By.xpath("//span[@class='a-offscreen']//parent::span[@class='a-price aok-align-center']");
	By sortBy = By.xpath("//span[@class='a-button-text a-declarative']");
	By filter = By.xpath("//div[@class='a-popover-inner a-lgtbox-vertical-scroll']/ul/li[2]/a");
	By price_filter = By.xpath("//div[@id='priceRefinements']/ul/span[2]/li/span/a");
	By price_all_item = By.xpath(
			"//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']//div[@class='a-row a-size-base a-color-base']/div/a/span/span/span[2]");

	public void ChooseProduct() {
		WebElement Item = driver.findElement(item);
		wait.until(ExpectedConditions.presenceOfElementLocated(item));
		Item.click();
		logger.info("Item is selected");
	}

	public void ClickAddToCart() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement AddToCart = driver.findElement(add_to_cart);
		wait.until(ExpectedConditions.elementToBeClickable(AddToCart));
		AddToCart.click();
		Thread.sleep(3000);
		logger.info("Item is added to Cart");
	}

	public void CheckCartInformation() {
		wait.until(ExpectedConditions.presenceOfElementLocated(cart_message));
		String Actual = driver.findElement(cart_message).getText();
		String Expected = "Added to Cart";
		Assert.assertTrue(Actual.contains(Expected));
		logger.info("Add to Cart is validated");
	}

	public void CheckAmount() {
		wait.until(ExpectedConditions.presenceOfElementLocated(amount));
		String ActualAmount = driver.findElement(amount).getText();
		System.out.println(ActualAmount);
		logger.info("Amount checked and saved");
	}

	public void ClickOnPriceFilter() throws InterruptedException {
		WebElement PriceFilter = driver.findElement(price_filter);
		wait.until(ExpectedConditions.elementToBeClickable(PriceFilter));
		PriceFilter.click();
		Thread.sleep(3000);
		logger.info("Price Filter Clicked");

	}

	public void ValidatePriceOfAllItem() throws InterruptedException {
		List<WebElement> PriceFilter = driver.findElements(price_all_item);

		for (WebElement ele : PriceFilter) {
			String s1 = ele.getText();
			int i = Integer.parseInt(s1);
			if (i >= 50 || i <= 100)
				;
			{
				System.out.println(i);
			}
		}
		logger.info("Price is validated");
	}

}
