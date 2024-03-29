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
	By timeOfVisitationList=By.xpath("//select[@id='checkout_shipping_address_visitation_timing']");
	By companyOrBusinessName = By.xpath("//*[@placeholder='Business Name']");
	By rcpntStreet = By.xpath("//*[@placeholder='Address Line 1']");
	By addressSuggestionBusiness = By.xpath("(//*[@class='fs-mask'])[5]");
	By suggestion1 = By.xpath("(//div[@class='suggestion-item'])[1]");
	By facilitySuggesstion = By.xpath("//*[@placeholder='Business Name']");
	By rcpntapmnt = By.xpath("//*[@placeholder='Address Line 2 (optional)']");
	By city = By.xpath("//*[@placeholder='City']");
	By occasionSelect = By.xpath("//select[@id='checkout_shipping_address_occasion']");
	By giftMessage = By.xpath("//*[@id='checkout_shipping_address_gift_message']");
	
	By deliveryPhnNum = By.xpath("//*[@placeholder='Delivery Phone Number']");
	By email = By.xpath("//*[@id='checkout_email']");
	By submitRcpnt = By.xpath("//button[@id='continue_button']");

	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver recipientInfo(String typeOfLocation, String occasion) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		driver.findElement(email).sendKeys("autotest@learning.com");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locationType));
		WebElement type = driver.findElement(locationType);
		type.click();
		Select selectLocationType = new Select(type);
		//selectLocationType.selectByValue(typeOfLocation);
		selectLocationType.selectByVisibleText(typeOfLocation);
		if (typeOfLocation.equalsIgnoreCase("Business")) {
			driver.findElement(companyOrBusinessName).sendKeys("Hello world solutions");
			// driver.findElement(city).sendKeys("Albany",Keys.ENTER);
			driver.findElement(rcpntStreet).sendKeys("420 ");
			wait.until(ExpectedConditions.elementToBeClickable(suggestion1));
			driver.findElement(suggestion1).click();
		} else if (typeOfLocation.equalsIgnoreCase("Funeral Home")) {
			wait.until(ExpectedConditions.elementToBeClickable(timeOfVisitation));
			driver.findElement(timeOfVisitation).click();
			wait.until(ExpectedConditions.elementToBeClickable(timeOfVisitationList));
			Select s = new Select(driver.findElement(timeOfVisitationList));
			s.selectByValue("16:30");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(facilitySuggesstion));
			WebElement facilty=driver.findElement(facilitySuggesstion);
			facilty.sendKeys(" ");
			driver.findElement(By.xpath("(//div[@class='suggestion-item'])[1]")).click();
			//facilty.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			
		}

		else if (typeOfLocation.equalsIgnoreCase("Residence")) {
			driver.findElement(rcpntStreet).sendKeys("420 ");
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(suggestion1));
			driver.findElement(suggestion1).click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(rcpntFname));
		driver.findElement(rcpntFname).sendKeys("test");
		driver.findElement(rcpntLname).sendKeys("test");
		driver.findElement(rcpntapmnt).sendKeys("419");
		driver.findElement(deliveryPhnNum).sendKeys("9876543219");
		selectOccasion(occasion);
		
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
