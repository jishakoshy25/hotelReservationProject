package com.hotel.webtests;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.hotel.pages.ConfirmReservationPage;
import com.hotel.pages.HomePage;
import com.hotel.pages.LoginPage;
import com.hotel.pages.MyPage;
import com.hotel.pages.NavigationBar;
import com.hotel.pages.ReservationPage;
import com.hotel.pages.ReservationPlansPage;
import com.hotel.pages.SignUpPage;
import com.hotel.util.DriverSetUp;

/**
 * BaseTest class is the parent class for all test classes. It supports the DRY
 * (Don't Repeat Yourself) principle by reducing redundancy and encouraging
 * reusable, maintainable code. WebDriver and Page Object classes need not be
 * instantiated in the individual test classes again.
 */

public abstract class BaseTest{
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected NavigationBar navigationBar;
	protected HomePage homepage;
	protected MyPage myPage;
	protected ReservationPage reservationPage;
	protected ReservationPlansPage reservePage;
	protected ConfirmReservationPage confirmPage;
	protected SignUpPage signUpPage;
	protected DriverSetUp driverSetUp;
	
	/**
	 * Set Up method that initializes all the Page classes and the webdriver instance
	 */
	@Parameters({"browser"})
	@BeforeClass(alwaysRun = true)
	public void setUp(String browser) {
		driverSetUp = new DriverSetUp();
		driverSetUp.initDriver(browser);
		driver = driverSetUp.getDriver();
		loginPage = new LoginPage(driver);
		navigationBar = new NavigationBar(driver);
		homepage = new HomePage(driver);
		myPage = new MyPage(driver);
		reservationPage = new ReservationPage(driver);
		reservePage = new ReservationPlansPage(driver);
		confirmPage = new ConfirmReservationPage(driver);
		signUpPage = new SignUpPage(driver);
	}
	/**
	 * Takes Screenshot for failed test scenarios
	 * @param result -  Parameter of ITestResult type which captures the state of the test scenario that was executed
	 */
	@AfterMethod
	public void takeScreenshotForFailures(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destinationFile = new File(
					System.getProperty("user.dir") + "/src/test/resources/screenshots" + result.getName() + ".png");
			try {
				FileHandler.copy(sourceFile, destinationFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Tear Down method that quits the driver session.
	 */

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
