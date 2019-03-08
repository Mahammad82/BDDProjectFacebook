package com.calculator.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.calculator.library.Base;

public class CalculatorTest extends Base {

	final static Logger logger = Logger.getLogger(CalculatorTest.class);
	String URL = "http://adam.goucher.ca/parkcalc/";

	@Test(enabled = true)
	public void calculatorTest1() {

		try {
			logger.info("First test is running...");
			// Go to website
			driver.get(URL);
			String title = driver.getTitle();
			logger.info(title);
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	@Test(enabled = true)
	public void calculatorTest2() {
		try {
			logger.info("Second test is running...");
			driver.get(URL);
			// Choose a lot
			library.selectDropDown(By.id("Lot"), "Short-Term Parking");
			// Choose entry date and time
			driver.findElement(By.id("EntryTime")).clear();
			library.enterTextField(By.id("EntryTime"), "09:00");
			library.clickBtn(By.name("EntryTimeAMPM"));
			driver.findElement(By.id("EntryDate")).clear();
			library.enterTextField(By.id("EntryDate"), "09/05/2018");
			// Choose leaving date and time
			driver.findElement(By.id("ExitTime")).clear();
			library.enterTextField(By.id("ExitTime"), "10:00");
			library.clickBtn(By.name("ExitTimeAMPM"));
			driver.findElement(By.id("ExitDate")).clear();
			library.enterTextField(By.id("ExitDate"), "09/05/2018");
			// Click on 'Submit' button
			library.clickBtn(By.name("Submit"));
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	@Test(enabled = true)
	public void calculatorTest3() {
		try {
			logger.info("Third test is running...");
			driver.get(URL);
			library.selectDropDown(By.id("Lot"), "Economy Parking");
			driver.findElement(By.id("EntryTime")).clear();
			library.enterTextField(By.id("EntryTime"), "02:00");
			library.clickBtn(By.xpath("//input[@name='EntryTimeAMPM'and@value='PM']"));
			driver.findElement(By.id("EntryDate")).clear();
			library.enterTextField(By.id("EntryDate"), "09/10/2018");
			driver.findElement(By.id("ExitTime")).clear();
			library.enterTextField(By.id("ExitTime"), "07:00");
			library.clickBtn(By.xpath("//input[@name='ExitTimeAMPM'and@value='PM']"));
			driver.findElement(By.id("ExitDate")).clear();
			library.enterTextField(By.id("ExitDate"), "09/10/2018");
			library.clickBtn(By.name("Submit"));
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	@Test(enabled = true)
	public void calculatorTest4() {
		try {
			logger.info("Fourth test is running...");
			driver.get(URL);
			library.selectDropDown(By.id("Lot"), "Long-Term Surface Parking");
			driver.findElement(By.id("EntryTime")).clear();
			library.enterTextField(By.id("EntryTime"), "10:00");
			library.clickBtn(By.name("EntryTimeAMPM"));
			driver.findElement(By.id("EntryDate")).clear();
			library.enterTextField(By.id("EntryDate"), "09/15/2018");
			driver.findElement(By.id("ExitTime")).clear();
			library.enterTextField(By.id("ExitTime"), "10:00");
			library.clickBtn(By.xpath("//input[@name='ExitTimeAMPM'and@value='PM']"));
			driver.findElement(By.id("ExitDate")).clear();
			library.enterTextField(By.id("ExitDate"), "09/20/2018");
			library.clickBtn(By.name("Submit"));
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	@Test(enabled = true)
	public void calculatorTest5() {
		try {
			logger.info("Fifth test is running...");
			driver.get(URL);
			library.selectDropDown(By.id("Lot"), "Long-Term Garage Parking");
			driver.findElement(By.id("EntryTime")).clear();
			library.enterTextField(By.id("EntryTime"), "10:00");
			library.clickBtn(By.name("EntryTimeAMPM"));
			driver.findElement(By.id("EntryDate")).clear();
			library.enterTextField(By.id("EntryDate"), "12/25/2018");
			driver.findElement(By.id("ExitTime")).clear();
			library.enterTextField(By.id("ExitTime"), "01:00");
			library.clickBtn(By.xpath("//input[@name='ExitTimeAMPM'and@value='PM']"));
			driver.findElement(By.id("ExitDate")).clear();
			library.enterTextField(By.id("ExitDate"), "05/01/2019");
			library.clickBtn(By.name("Submit"));
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	@Test(enabled = true)
	public void calculatorTest6() {
		try {
			logger.info("Sixth test is running...");
			logger.info("This test is negative test");
			driver.get(URL);
			library.selectDropDown(By.id("Lot"), "Valet Parking");
			driver.findElement(By.id("EntryTime")).clear();
			library.enterTextField(By.id("EntryTime"), "10:00");
			library.clickBtn(By.xpath("//input[@name='EntryTimeAMPM'and@value='PM']"));
			driver.findElement(By.id("EntryDate")).clear();
			library.enterTextField(By.id("EntryDate"), "10/01/2018");
			driver.findElement(By.id("ExitTime")).clear();
			library.enterTextField(By.id("ExitTime"), "01:00");
			library.clickBtn(By.name("ExitTimeAMPM"));
			driver.findElement(By.id("ExitDate")).clear();
			library.enterTextField(By.id("ExitDate"), "10/01/2018");
			library.clickBtn(By.name("Submit"));
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}
}
