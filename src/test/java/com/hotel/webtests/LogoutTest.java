package com.hotel.webtests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotel.util.URLs;

public class LogoutTest extends BaseTest{

	@BeforeMethod
	public void navigatetoURL() {
		driver.get(URLs.LOGIN_URL);
	}

	@Test
	public void logoutTest() {
		loginPage.enterUserName("diana@example.com");
		loginPage.enterPassword("pass1234");
		loginPage.clickLoginButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Logout']"))));
		assertEquals(driver.getTitle(), "MyPage | HOTEL PLANISPHERE - Website for Practice Test Automation");
		driver.findElement(By.xpath("//button[text()='Logout']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(3000));
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Login']"))));
		assertEquals(driver.getTitle(), "HOTEL PLANISPHERE - Website for Practice Test Automation");
		assertTrue(homepage.checkLoginLink());
		
	}
}
