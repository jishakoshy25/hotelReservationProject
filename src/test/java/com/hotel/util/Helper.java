package com.hotel.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
/**
 * Helper class for common functionalities that need to be shared across test classes
 */
public class Helper {
	public static void switchTab(WebDriver driver, String mainTab) {
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equalsIgnoreCase(mainTab)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}

	public static Alert isAlertPresent(WebDriver driver) {
		Alert alert = null;
		try {
			alert = driver.switchTo().alert();
		} catch (NoAlertPresentException exception) {
			exception.printStackTrace();
		}
		return alert;
	}
}
