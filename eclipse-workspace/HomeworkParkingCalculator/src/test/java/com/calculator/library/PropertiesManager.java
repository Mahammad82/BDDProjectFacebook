package com.calculator.library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.testng.log4testng.Logger;

public class PropertiesManager {

	final static Logger logger = Logger.getLogger(Properties.class);
	private String propertiesFile;
	private Properties prop;
	private OutputStream output;
	private InputStream input;

	public PropertiesManager(String propertiesFilePath) {

		propertiesFile = propertiesFilePath;
		prop = new Properties();
	}

	public String readProperty(String key) {
		String value = null;

		try {
			input = new FileInputStream(propertiesFile);
			prop.load(input);
			value = prop.getProperty(key);
		} catch (Exception e) {
			logger.error("Error: ", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (Exception e) {
					logger.error("Error: ", e);
				}
			}
		}
		return value;
	}

	public void setProperty(String key, String value) {
		try {
			output = new FileOutputStream(propertiesFile);
			prop.setProperty(key, value);
			prop.store(output, null);
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	/*public static void main(String[] args) {
		PropertiesManager propManager = new PropertiesManager("src/test/resources/configs/config.properties");
		propManager.setProperty("browserType", "Chrome");
		propManager.setProperty("isDemoMode", "false");
		propManager.setProperty("isRemoteTest", "false");
		String propertyValue = propManager.readProperty("browserType");
		String demo = propManager.readProperty("isDemoMode");
		logger.info("value is: " + propertyValue);
		logger.info("demo is: " + demo);
	}*/

}
