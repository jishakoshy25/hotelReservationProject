package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginLink;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean checkLoginLink() {
		return loginLink.isDisplayed();
	}

}
