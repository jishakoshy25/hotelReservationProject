package com.hotel.webtests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotel.dataprovider.LoginDataProvider;
import com.hotel.util.URLs;

public class LoginTest extends BaseTest{
	
	@BeforeMethod
	public void navigateToLoginPage() {
		driver.get(URLs.LOGIN_URL);
	}

	@Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void loginTest_validCredentials(String userName, String password) throws InterruptedException{	
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.titleContains("MyPage"));
		assertEquals(driver.getTitle(), "MyPage | HOTEL PLANISPHERE - Website for Practice Test Automation");
		navigationBar.clickLogout();
		Thread.sleep(3000);
	}

	@Test
	public void loginTest_invalidCredentials() {
		loginPage.enterUserName("kia@example.com");
		loginPage.enterPassword("ddf");
		loginPage.clickLoginButton();
		assertEquals(driver.findElement(By.id("email-message")).getText(), "Email or password is invalid.");
	}
}
