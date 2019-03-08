package com.calculator.library;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;

public class Base {

	final static Logger logger = Logger.getLogger(Base.class);
	public WebDriver driver;
	public CalculatorLibrary library;
	private static PropertiesManager property;
	private static String browser;

	@BeforeClass
	public void beforeAllTests() {
		logger.info("Reading property file...");
		property = new PropertiesManager("src/test/resources/configs/config.properties");
		browser = property.readProperty("browserType");
	}

	@AfterClass
	public void afterAllTests() {
		logger.info("After all tests completed..");
	}

	@BeforeMethod
	public void beforeEachTest() {
		logger.info("Before each test started...");
		library = new CalculatorLibrary(driver);
		driver = library.startBrowser(browser);
	}

	@AfterMethod
	public void afterEachTest() {
		logger.info("After each test completed...");
		logger.info("Waiting for 5 seconds...");
		library.customWait(5);
		if (driver != null) {
			driver.quit();
		}
	}

}
