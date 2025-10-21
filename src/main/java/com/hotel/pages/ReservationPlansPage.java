package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ReservationPlansPage extends BasePage{
	
	@FindBy(xpath = "//h5[@class='card-title' and text()='Plan with special offers']/following-sibling::a[text()='Reserve room']")
	WebElement reserveRoom_withOffers;

	@FindBy(xpath = "//h5[@class='card-title' and text()='Staying without meals']/following-sibling::a[text()='Reserve room']")
	WebElement reserveRoom_withoutMeals;

	@FindBy(xpath = "//h5[@class='card-title' and text()='Business trip']/following-sibling::a[text()='Reserve room']")
	WebElement reserveRoom_businessTrip;

	@FindBy(xpath = "//h5[@class='card-title' and text()='With beauty salon']/following-sibling::a[text()='Reserve room']")
	WebElement reserveRoom_beautySalon;

	@FindBy(xpath = "//h5[@class='card-title' and text()='With private onsen']/following-sibling::a[text()='Reserve room']")
	WebElement reserveRoom_privateOnsen;

	@FindBy(xpath = "//h5[@class='card-title' and text()='For honeymoon']/following-sibling::a[text()='Reserve room']")
	WebElement reserveRoom_honeymoon;

	@FindBy(xpath = "//h5[@class='card-title' and text()='With complimentary ticket']/following-sibling::a[text()='Reserve room']")
	WebElement reserveRoom_complimentaryTicket;
	
	public ReservationPlansPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickReserve_withOffers() {
		reserveRoom_withOffers.click();
	}
	
	public void clickReserve_withoutMeals() {
		Actions actions = new Actions(driver);
		actions.moveToElement(reserveRoom_withoutMeals);
		actions.perform();
		reserveRoom_withoutMeals.click();
	}
	public void clickReserve_businessTrip() {
		Actions actions = new Actions(driver);
		actions.moveToElement(reserveRoom_businessTrip);
		actions.perform();
		reserveRoom_businessTrip.click();
	}
	public void clickReserve_beautySalon() {
		reserveRoom_beautySalon.click();
	}
	public void clickReserve_privateOnsen() {
		reserveRoom_privateOnsen.click();
	}
	public void clickReserve_honeymoon() {
		reserveRoom_honeymoon.click();
	}
	public void clickReserve_complimentaryTicket() {
		reserveRoom_complimentaryTicket.click();
	}
}
