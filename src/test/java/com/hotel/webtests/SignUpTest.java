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

public class SignUpTest extends BaseTest{

	@BeforeMethod
	public void navigateToSignUpPage() {
		driver.get(URLs.SIGNUP_URL);
	}

	@Test
	public void testSignUp() {
		signUpPage.fillSignUpForm("aaron@example.com", "pass1234", "pass1234", "Aaron", false, "Pennsylvania",
				"12224461234", "female", "19-07-1987", false);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Logout']"))));
		assertEquals(driver.getTitle(), "MyPage | HOTEL PLANISPHERE - Website for Practice Test Automation");
		assertEquals(myPage.getEmailText(), "aaron@example.com");
		assertEquals(myPage.getUserNameText(), "Aaron");
		assertEquals(myPage.getRankText(), "Normal");
		assertEquals(myPage.getAddressText(), "Pennsylvania");
		assertEquals(myPage.getTelephoneText(), "12224461234");
		assertEquals(myPage.getGenderText(), "female");
		assertEquals(myPage.getDobText(), "July 19, 1987");
		assertEquals(myPage.getNotificationText(), "not received");
		navigationBar.clickLogout();
	}

	@Test
	public void testSignUp_PasswordValidationError() throws InterruptedException {
		signUpPage.fillSignUpForm("aaron1@example.com", "pass12", "pass12", "Aaron", false, "Pennsylvania",
				"12224461234", "female", "19-07-1987", false);
		assertTrue(signUpPage.invalidFeedback());
	}

	@Test
	public void testSignUp_EmailValidationError() throws InterruptedException {
		signUpPage.fillSignUpForm("aaron@example.com", "pass12", "pass12", "Aaron", false, "Pennsylvania",
				"12224461234", "female", "19-07-1987", false);
		assertTrue(signUpPage.invalidFeedback_Email());
	}
}
