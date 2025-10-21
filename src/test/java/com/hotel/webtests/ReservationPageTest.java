package com.hotel.webtests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hotel.util.URLs;

public class ReservationPageTest extends BaseTest {
	@Test
	public void testReserveWithOffers() throws InterruptedException {
		driver.get(URLs.PLAN_WITHOFFERS_URL);
		reservationPage.enterCheckinDate("10/30/2025");
		reservationPage.selectStay(1);
		reservationPage.selectGuestCount(2);
		reservationPage.selectBreakfast(true);
		reservationPage.enterUserName("diana");
		reservationPage.enterContact("By email");
		reservationPage.enterEmail("diana@example.com");
		reservationPage.clickConfirm();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit Reservation']")));
		assertEquals(driver.getTitle(),
				"Confirm Reservation | HOTEL PLANISPHERE - Website for Practice Test Automation");

	}

	@Test
	public void testStayWithoutMeals() throws InterruptedException {
		driver.get(URLs.PLAN_STAYWITHOUTMEALS_URL);
		reservationPage.enterCheckinDate("10/30/2025");
		reservationPage.selectStay(1);
		reservationPage.selectGuestCount(2);
		reservationPage.selectEarlyCheckIn(true);
		reservationPage.enterUserName("diana");
		reservationPage.enterContact("By email");
		reservationPage.enterEmail("diana@example.com");
		reservationPage.clickConfirm();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit Reservation']")));
		assertEquals(driver.getTitle(),
				"Confirm Reservation | HOTEL PLANISPHERE - Website for Practice Test Automation");
		assertEquals(driver.findElement(By.cssSelector("h4#plan-name")).getText(), "Staying without meals");
		assertEquals(driver.findElement(By.xpath("//dd[@id=\"plans\"]/ul/li")).getText(), "Early check-in");
	}

}
