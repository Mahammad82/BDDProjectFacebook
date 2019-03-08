package com.calculator.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

public class CalculatorLibrary {

	final static Logger logger = Logger.getLogger(CalculatorLibrary.class);
	private WebDriver driver;

	/***
	 * This is contructor
	 * 
	 * @param _driver
	 */
	public CalculatorLibrary(WebDriver _driver) {

		driver = _driver;
	}

	/***
	 * This method starts IE browser
	 * 
	 * @return
	 */
	public WebDriver startIEBrowser() {
		try {
			System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			logger.info("IE browser started ...");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return driver;
	}

	/***
	 * This method starts Chrome browser
	 * 
	 * @return driver
	 */
	public WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome browser started ...");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return driver;
	}

	/***
	 * This method starts Firefox browser
	 * 
	 * @return
	 */
	public WebDriver startFirefoxBrowser() {
		try {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("Firefox browser started ...");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return driver;
	}

	/***
	 * This method swichs browsers
	 * 
	 * @param browser
	 * @return driver
	 */
	public WebDriver startBrowser(String browser) {
		switch (browser) {
		case "IE":
			driver = startIEBrowser();
			break;

		case "Chrome":
			driver = startChromeBrowser();
			break;

		case "Firefox":
			driver = startFirefoxBrowser();
			break;

		default:
			logger.info("User selected browser: '" + browser + "'" + ", Starting default browser - IE");
			driver = startIEBrowser();
			break;
		}
		return driver;
	}

	/***
	 * This method enters text for given WebElement
	 * 
	 * @param by
	 * @param userInputString
	 */
	public void enterTextField(By by, String userInputString) {
		try {
			WebElement element = driver.findElement(by);
			element.sendKeys(userInputString);
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	/***
	 * This method selects drop-down element for given drop-down option value
	 * 
	 * @param by
	 * @param optionValue
	 */
	public void selectDropDown(By by, String optionValue) {
		try {
			WebElement dropdownElem = driver.findElement(by);
			Select dropdown = new Select(dropdownElem);
			dropdown.selectByVisibleText(optionValue);
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	/***
	 * This method clicks given WebElement
	 * 
	 * @param by
	 */
	public void clickBtn(By by) {
		try {
			WebElement btn = driver.findElement(by);
			btn.click();
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	/***
	 * This method stops the current thread for given second(s)
	 * 
	 * @param inSeconds
	 */
	public void customWait(double inSeconds) {
		try {
			Thread.sleep((long) (inSeconds * 1000));
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}
}
