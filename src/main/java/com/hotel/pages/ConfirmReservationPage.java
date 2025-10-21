package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmReservationPage extends BasePage{
	
	@FindBy(xpath = "//button[text()='Submit Reservation']")
	WebElement submitBtn;
	
	@FindBy(css = "div.modal-body>p")
	WebElement confirmReservationModalText;
	
	@FindBy(css ="div.modal-dialog h5.modal-title")
	WebElement confirmReservationModalTitle;
	
	@FindBy(css = "div#success-modal button.btn-success")
	WebElement closeBtn;
	
	public ConfirmReservationPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
	
	public String getModalText() {
		return confirmReservationModalText.getText();
	}
	
	public String getModalTitle() {
		return confirmReservationModalTitle.getText();
	}
	
	public void clickCloseBtn() {
		closeBtn.click();
	}

}
