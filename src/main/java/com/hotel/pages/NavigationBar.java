package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends BasePage{
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeLink;
	
	@FindBy(xpath ="//a[text()='Reserve']")
	WebElement reserveLink;
	
	@FindBy(xpath ="//a[text()='Mypage']")
	WebElement myPage;
	
	@FindBy(xpath="//button[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement login;
	
	public NavigationBar(WebDriver driver) {
		super(driver);
	}
	
	public void clickHome() {
		homeLink.click();
	}
	
	public void clickReserve() {
		reserveLink.click();
	}
	
	public void clickMyPage() {
		myPage.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public void clickLogin() {
		login.click();
	}
}
