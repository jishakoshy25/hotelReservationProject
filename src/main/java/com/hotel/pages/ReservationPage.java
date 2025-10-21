package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReservationPage extends BasePage{
	
	@FindBy(id="date")
	WebElement checkinDate;
	
	@FindBy(xpath="//label[contains(text(),'Check-in')]")
	WebElement checkinLabel;
	
	@FindBy(xpath="//h2[text()='Reservation']")
	WebElement reservationHeading;
	
	@FindBy(id="term")
	WebElement stay;
	
	@FindBy(id="head-count")
	WebElement guestCount;
	
	@FindBy(xpath="//label[@for='breakfast']")
	WebElement breakfast;
	
	@FindBy(xpath="//label[@for='early-check-in']")
	WebElement earlyCheckin;
	
	@FindBy(xpath="//label[@for='sightseeing']")
	WebElement sightseeing;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="contact")
	WebElement contact;
	
	@FindBy(id="comment")
	WebElement specialRequest;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="submit-button")
	WebElement confirmReservation;
	
	public ReservationPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterCheckinDate(String checkin){
		checkinLabel.click();
		checkinDate.clear();
		checkinDate.sendKeys(checkin);
		reservationHeading.click();
	}

	public void selectStay(int stayDays) {
		stay.clear();
		stay.sendKeys(Integer.toString(stayDays));
	}
	
	public void selectGuestCount(int count) {
		guestCount.clear();
		guestCount.sendKeys(Integer.toString(count));
	}
	
	public void selectBreakfast(boolean breakfastIncluded)
	{
		if(breakfastIncluded && !breakfast.isSelected()) {
			breakfast.click();
		}
	}
	
	public void selectEarlyCheckIn(boolean checkInEarly)
	{
		if(checkInEarly && !earlyCheckin.isSelected()) {
			earlyCheckin.click();
		}
	}
	public void selectSightseeing(boolean sightSee)
	{
		if(sightSee && !sightseeing.isSelected()) {
			sightseeing.click();
		}
	}
	public void enterUserName(String userName) {
		username.clear();
		username.sendKeys(userName);
	}
	
	public void enterContact(String contactMethod) {
		Select contactDropdown =  new Select(contact);
		contactDropdown.selectByVisibleText(contactMethod);
	}
	
	public void enterComment(String comment) {
		specialRequest.clear();
		specialRequest.sendKeys(comment);
	}
	
	public void enterEmail(String emailAddress) {
		email.clear();
		email.sendKeys(emailAddress);
	}
	
	public void clickConfirm() {
		confirmReservation.click();
	}
}
