package com.learning.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingInfo {
	WebDriver driver;
	By billingSameAsRecipient = By.xpath("//*[@for='use-delivery-address']");
	By placeYourOrder = By.xpath("(//*[text()='Place Your Order'])[1]");
	By firstName=By.xpath("//*[@id='firstName']");
	By lastName=By.xpath("//*[@id='lastName']");
	By streetAddress= By.xpath("//*[@placeholder='Street Address']");
	By city=By.xpath("//*[@placeholder='City']");
	By zipcode=By.xpath("//*[@placeholder='Enter ZIP Code']");
	By bilingPhoneNum=By.xpath("//*[@placeholder='Phone Number']");
	public BillingInfo(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver billingEqualsRecipient() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(billingSameAsRecipient));
		driver.findElement(billingSameAsRecipient).click();
		driver.findElement(placeYourOrder).click();
		return driver;
	}
	
	public WebDriver billingNotEqualRecipient()
	{
		driver.findElement(firstName).sendKeys("test1");
		driver.findElement(lastName).sendKeys("test1");
		driver.findElement(streetAddress).sendKeys("212 Shaker road");
		driver.findElement(zipcode).sendKeys("12205",Keys.ENTER);
		driver.findElement(city).sendKeys("Albany");
		driver.findElement(bilingPhoneNum).sendKeys("9999999999");
		driver.findElement(placeYourOrder).click();
		return driver;
		
	}

}
