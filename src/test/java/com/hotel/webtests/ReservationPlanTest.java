package com.hotel.webtests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotel.util.Helper;
import com.hotel.util.URLs;

public class ReservationPlanTest extends BaseTest{
	String mainTab;
	
	@BeforeMethod
	public void navigate() {
		driver.get(URLs.PLANS_URL);
		mainTab = driver.getWindowHandle();
	}

	@Test
	public void testReserveWithOffers() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.titleContains("Plans"));
		reservePage.clickReserve_withOffers();
		Helper.switchTab(driver, mainTab);
		assertTrue(driver.getTitle().contains("Reservation"));
		assertTrue(driver.getCurrentUrl().contains("reserve.html?plan-id=0"));
		assertEquals(driver.findElement(By.cssSelector("h4#plan-name")).getText(), "Plan with special offers");
	}

	@Test
	public void testReserveWithoutMeals() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.titleContains("Plans"));
		reservePage.clickReserve_withoutMeals();
		Helper.switchTab(driver, mainTab);
		assertTrue(driver.getTitle().contains("Reservation"));
		assertTrue(driver.getCurrentUrl().contains("reserve.html?plan-id=4"));
		assertEquals(driver.findElement(By.cssSelector("h4#plan-name")).getText(), "Staying without meals");
	}

	@Test
	public void testReserveBusinessTrip() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.titleContains("Plans"));
		reservePage.clickReserve_businessTrip();
		Helper.switchTab(driver, mainTab);
		assertTrue(driver.getTitle().contains("Reservation"));
		assertTrue(driver.getCurrentUrl().contains("reserve.html?plan-id=5"));
		assertEquals(driver.findElement(By.cssSelector("h4#plan-name")).getText(), "Business trip");
	}

	@AfterMethod
	public void closeTabs() throws Exception {
		driver.close();
		driver.switchTo().window(mainTab);
	}
}
