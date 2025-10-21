package com.hotel.webtests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotel.util.Helper;
import com.hotel.util.URLs;

public class ReservationTest extends BaseTest {
	String mainTab;

	@BeforeMethod
	public void navigatetoURL() {
		driver.get(URLs.LOGIN_URL);
		mainTab = driver.getWindowHandle();
	}

	@Test
	public void reservationSucess() throws InterruptedException {
		loginPage.enterUserName("diana@example.com");
		loginPage.enterPassword("pass1234");
		loginPage.clickLoginButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(4000));
		wait.until(ExpectedConditions.titleContains("MyPage"));
		navigationBar.clickReserve();
		wait.until(ExpectedConditions.urlContains("/plans.html"));
		reservePage.clickReserve_withOffers();
		Helper.switchTab(driver, mainTab);
		reservationPage.enterCheckinDate("11/30/2025");
		reservationPage.selectStay(1);
		reservationPage.selectGuestCount(2);
		reservationPage.selectEarlyCheckIn(true);
		reservationPage.enterUserName("diana");
		reservationPage.enterContact("By email");
		reservationPage.enterEmail("diana@example.com");
		reservationPage.clickConfirm();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit Reservation']")));
		confirmPage.clickSubmitBtn();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-body>p")));
		assertEquals(confirmPage.getModalText(), "We look forward to visiting you.");
		assertEquals(confirmPage.getModalTitle(), "Thank you for reserving.");
		confirmPage.clickCloseBtn();
	}

}
