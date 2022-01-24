package com.learning.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	public WebDriver driver;

	By rcpntFname = By.xpath("//*[@placeholder='Recipient First Name']");
	By rcpntLname = By.xpath("//*[@placeholder='Recipient Last Name']");
	By rcpntStreet = By.xpath("//*[@placeholder='Street Address']");
	By addressSuggestion = By.xpath("//*[@class='addressList']");
	By suggestion1 = By.xpath("(//*[@class='fs-mask'])[4]");
	By rcpntapmnt = By.xpath("//*[@placeholder='Apartment or Suite (Optional)']");
	By deliveryPhnNum = By.xpath("//*[@placeholder='Delivery Phone Number']");
	By email = By.xpath("//*[@placeholder='Email']");
	By submitRcpnt = By.xpath("//*[text()='Continue to Payment']");

	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver recipientInfo() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(rcpntFname));
		driver.findElement(rcpntFname).sendKeys("test");
		driver.findElement(rcpntLname).sendKeys("test");
		driver.findElement(rcpntStreet).sendKeys("420 ");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestion1));
		driver.findElement(suggestion1).click();
		driver.findElement(rcpntapmnt).sendKeys("419");
		driver.findElement(deliveryPhnNum).sendKeys("9876543219");
		driver.findElement(email).sendKeys("autotest@learning.com");
		driver.findElement(submitRcpnt).click();
		return driver;
	}

}
