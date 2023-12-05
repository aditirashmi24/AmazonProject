package org.project.Amazon_Project.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	protected static Logger logger = LogManager.getLogger();
	int browserCount = 0;

	@BeforeClass
	public void openBrowser() throws IOException {
		String path = System.getProperty("user.dir") + "\\resources\\testdata\\testdata.properties";
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		String edgePath = System.getProperty("user.dir") + prop.getProperty("edriverpath");
		driver = new EdgeDriver();
		System.setProperty("webdriver.edge.driver", edgePath);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		browserCount++;

	}

	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

}
