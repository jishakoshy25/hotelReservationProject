package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPage extends BasePage{
	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "rank")
	WebElement rank;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "tel")
	WebElement telephone;

	@FindBy(id = "gender")
	WebElement gender;

	@FindBy(id = "birthday")
	WebElement dateOfBirth;

	@FindBy(id = "notification")
	WebElement notification;
	
	@FindBy(xpath = "//div[@id='navbarNav']//a[@class='nav-link' and text()='Reserve']")
	WebElement reserveLink;

	public MyPage(WebDriver driver) {
		super(driver);
	}

	public String getEmailText() {
		return email.getText();
	}

	public String getUserNameText() {
		return userName.getText();
	}

	public String getRankText() {
		return rank.getText();
	}

	public String getAddressText() {
		return address.getText();
	}

	public String getTelephoneText() {
		return telephone.getText();
	}

	public String getGenderText() {
		return gender.getText();
	}

	public String getDobText() {
		return dateOfBirth.getText();
	}

	public String getNotificationText() {
		return notification.getText();
	}
	
	public void clickReserveLink() {
		reserveLink.click();
	}
}
