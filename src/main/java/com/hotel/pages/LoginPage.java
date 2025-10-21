package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id ="password")
	private WebElement password;
	
	@FindBy(id ="login-button")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String name) {
		email.clear();
		email.sendKeys(name);
	}
	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		loginBtn.click();
	}
}
