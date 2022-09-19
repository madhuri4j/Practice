package com.learning.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	public WebDriver driver;
	By locationType = By.xpath("//*[@name='checkout[attributes][location_type]']");
	By rcpntFname = By.xpath("(//*[@name='checkout[shipping_address][first_name]'])[2]");
	By rcpntLname = By.xpath("(//*[@name='checkout[shipping_address][last_name]'])[2]");
	By timeOfVisitation = By.xpath("(//*[contains(@name,'visitation')])[1]");
	By companyOrBusinessName = By.xpath("//*[@placeholder='Company/Business Name']");
	By rcpntStreet = By.xpath("//*[@placeholder='Address Line 1']");
	By addressSuggestionBusiness = By.xpath("(//*[@class='fs-mask'])[5]");
	By suggestion1 = By.xpath("(//*[@class='fs-mask'])[4]");
	By facilitySuggesstion = By.xpath("//*[contains(@data-addresssuggestion,'facility')][1]");
	By rcpntapmnt = By.xpath("//*[@placeholder='Apartment or Suite (Optional)']");
	By city = By.xpath("//*[@placeholder='City']");
	By occasionSelect = By.xpath("//select[@name='occasion']");
	By giftMessage = By.xpath("//*[@name='personal-message']");

	By deliveryPhnNum = By.xpath("//*[@placeholder='Delivery Phone Number']");
	By email = By.xpath("//*[@placeholder='Email']");
	By submitRcpnt = By.xpath("//*[text()='Continue to Payment']");

	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver recipientInfo(String typeOfLocation, String occasion) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locationType));
		WebElement type = driver.findElement(locationType);
		type.click();
		Select selectLocationType = new Select(type);
		selectLocationType.selectByValue(typeOfLocation);
		wait.until(ExpectedConditions.visibilityOfElementLocated(rcpntFname));
		driver.findElement(rcpntFname).sendKeys("test");
		driver.findElement(rcpntLname).sendKeys("test");
		if (typeOfLocation.equalsIgnoreCase("business")) {
			driver.findElement(companyOrBusinessName).sendKeys("Hello world solutions");
			// driver.findElement(city).sendKeys("Albany",Keys.ENTER);
			driver.findElement(rcpntStreet).sendKeys("420 ");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addressSuggestionBusiness));
			driver.findElement(addressSuggestionBusiness).click();
		} else if (typeOfLocation.equalsIgnoreCase("funeral")) {
			Select s = new Select(driver.findElement(timeOfVisitation));
			s.selectByValue("16:30");
			driver.findElement(rcpntStreet).sendKeys("a");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(facilitySuggesstion));
			driver.findElement(facilitySuggesstion).click();
		}

		else if (typeOfLocation.equalsIgnoreCase("Residence")) {
			driver.findElement(rcpntStreet).sendKeys("420 ");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestion1));
			driver.findElement(suggestion1).click();
		}
		driver.findElement(rcpntapmnt).sendKeys("419");
		driver.findElement(deliveryPhnNum).sendKeys("9876543219");
		selectOccasion(occasion);
		driver.findElement(email).sendKeys("autotest@learning.com");
		driver.findElement(submitRcpnt).click();
		return driver;
	}

	public WebDriver selectOccasion(String occasionvalue) {
		if (occasionvalue == null) {
			return driver;
		} else if (occasionvalue.equalsIgnoreCase("Sympathy")) {
			driver.findElement(giftMessage).sendKeys("Sorry for the loss");

		}

		else {
			Select s = new Select(driver.findElement(occasionSelect));
			s.selectByValue(occasionvalue);
			if (occasionvalue.equalsIgnoreCase("Birthday")) {
				driver.findElement(giftMessage).sendKeys("Happy Birthday");
			} else if (occasionvalue.equalsIgnoreCase("Congratulations")) {
				driver.findElement(giftMessage).sendKeys("congratulations on the success");
			}
			
		}
		return driver;
	}
}
