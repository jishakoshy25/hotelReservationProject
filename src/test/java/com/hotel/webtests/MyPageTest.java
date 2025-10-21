package com.hotel.webtests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotel.util.URLs;

public class MyPageTest extends BaseTest{

	@BeforeMethod
	public void navigateToURL() {
		driver.get(URLs.LOGIN_URL);
	}

	@Test
	public void testMyPage() {
		loginPage.enterUserName("diana@example.com");
		loginPage.enterPassword("pass1234");
		loginPage.clickLoginButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Logout']"))));
		assertEquals(driver.getTitle(), "MyPage | HOTEL PLANISPHERE - Website for Practice Test Automation");
		
		assertEquals(myPage.getEmailText(), "diana@example.com");
		assertEquals(myPage.getUserNameText(),"Diana Johansson");
		assertEquals(myPage.getRankText(), "Normal");
		assertEquals(myPage.getAddressText(), "Redmond, Washington");
		assertEquals(myPage.getTelephoneText(), "not answered");
		assertEquals(myPage.getGenderText(), "female");
		assertEquals(myPage.getDobText(), "April 1, 2000");
		assertEquals(myPage.getNotificationText(), "not received");
	}
}
