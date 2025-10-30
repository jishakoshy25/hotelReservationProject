package com.hotel.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Class that creates Driver instance
 */
public class DriverSetUp {

	@SuppressWarnings("serial")
	public static WebDriver getDriver() {
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
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.manage().window().maximize();
		return driver;
	}

}
