package com.hotel.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Class that creates Driver instance
 */
public class DriverSetUp {
	protected WebDriver driver;
	
	@SuppressWarnings("serial")
	public void initDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--guest");
			options.addArguments("--disable-infobars");
			options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {
				{
					put("reduce-security-for-testing", true);
				}
			});
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options =  new FirefoxOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--guest");
			options.addArguments("--disable-infobars");
			driver = new FirefoxDriver(options);
		}
		driver.manage().window().maximize();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
