package com.hotel.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "password-confirmation")
	WebElement confirmPassword;

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "rank-premium")
	WebElement premiumRadioButton;

	@FindBy(id = "rank-normal")
	WebElement normalRadioButton;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "tel")
	WebElement telephone;

	@FindBy(id = "gender")
	WebElement gender;

	@FindBy(id = "birthday")
	WebElement dob;

	@FindBy(id = "notification")
	WebElement notification;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUpButton;

	@FindBy(xpath = "//input[@id='password']/following-sibling::div[@class='invalid-feedback' and text()='Please lengthen this text to 8 characters or more.']")
	WebElement invalidFeedback;

	@FindBy(xpath = "//input[@id='email']/following-sibling::div[@class='invalid-feedback' and text()='Email has already been taken.']")
	WebElement duplicateEmailFeedback;

	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	public boolean invalidFeedback_Email() {
		return duplicateEmailFeedback.isDisplayed();
	}

	public boolean invalidFeedback() {
		return invalidFeedback.isDisplayed();
	}

	public void fillSignUpForm(String email, String password, String confirmPassword, String name, boolean isPremium,
			String address, String telephone, String gender, String dateOfBirth, boolean notification) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(4000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.confirmPassword.sendKeys(confirmPassword);
		this.userName.sendKeys(name);
		if (isPremium && !this.premiumRadioButton.isSelected()) {
			this.premiumRadioButton.click();
		} else if (!this.normalRadioButton.isSelected()) {
			this.normalRadioButton.click();
		}
		this.address.sendKeys(address);
		this.telephone.sendKeys(telephone);
		Select genderSelect = new Select(this.gender);
		genderSelect.selectByVisibleText(gender);
		this.dob.sendKeys(dateOfBirth);
		if (notification)
			this.notification.click();
		this.signUpButton.click();
	}
}
