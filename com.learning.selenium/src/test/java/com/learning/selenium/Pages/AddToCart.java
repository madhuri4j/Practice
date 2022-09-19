package com.learning.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	public WebDriver driver;

	public AddToCart(WebDriver driver) {
		this.driver = driver;
	}

	By productSearchZipcode = By.xpath("//*[@id=\"zipCode-35aJquKJSaHf2L77Ee6j8w\"]");
	By dateField = By.xpath("//*[@name='date']");
	By dateSelect = By.xpath("(//*[@aria-label='Choose Date'])[1]");
	By currentDate = By.xpath("//*[@aria-selected=\"true\"]");
	By dayIsSunday = By.xpath("//*[contains(@aria-label,'Sunday') and @aria-disabled='false']");
	By closePopup = By.xpath("closeIconContainer");
	By shopNow = By.xpath("//*[text()='Shop Now']");
	By Bouquet1 = By.xpath("(//*[contains(@aria-label,'image')])[1]");
	By Bouquet2 = By.xpath("(//*[contains(@aria-label,'image')])[4]");
	By dateVerification = By.xpath("//*[text()='Delivering to:']");
	By zipcode = By.xpath("//*[@id='zipCode-deliver-to']");
	By bouquetType = By.xpath("//*[text()='STANDARD']");
	By addToCart = By.xpath("//*[contains(text(),'add to bag')]");
	By deliverTo = By.xpath("//*[@id='date-deliver-to']");
	By continueButton = By.xpath("//*[contains(text(),'CONTINUE')]");
	By checkout = By.xpath("//*[contains(text(),'CHECKOUT')]");
	By balloonAddon = By.xpath("//*[contains(@arialabel,'Balloon')]");
	By greetingAddon = By.xpath("//*[contains(@arialabel,'Greeting ')]");
	By teddyBearAddon = By.xpath("//*[contains(@arialabel,'Plush Bear')]");
	By chocolatesAddon = By.xpath("//*[contains(@arialabel,'Chocolates')]");

	public WebDriver currentDateOrder(String day, String addons) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(productSearchZipcode).sendKeys("12205", Keys.ENTER);
		if (day.equals("current")) {
			wait.until(ExpectedConditions.elementToBeClickable(dateSelect));
			driver.findElement(dateSelect).click();
			driver.findElement(dateSelect).click();
		} else if (day.equals("sunday")) {
			wait.until(ExpectedConditions.elementToBeClickable(dateSelect));
			driver.findElement(dateSelect).click();
			wait.until(ExpectedConditions.elementToBeClickable(shopNow));
			driver.findElement(shopNow).click();
			wait.until(ExpectedConditions.elementToBeClickable(dateSelect));
			driver.findElement(dateSelect).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(dayIsSunday));
			driver.findElement(dayIsSunday).click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(shopNow));
		driver.findElement(shopNow).click();
		retryingFindClick(Bouquet1);
		Thread.sleep(3000);
		int a = driver.findElements(dateVerification).size();
		driver.findElement(bouquetType).click();
		driver.findElement(addToCart).click();
	/*	if (a == 1) {

		}

		else

		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode));
			driver.findElement(zipcode).sendKeys("12205", Keys.ENTER);
			wait.until(ExpectedConditions.elementToBeClickable(deliverTo));
			driver.findElement(deliverTo).sendKeys(Keys.ENTER);
		}*/
		addon(addons);
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkout));
		driver.findElement(checkout).click();
		return driver;
	}

	public WebDriver addon(String addon) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if (addon.equalsIgnoreCase("balloon")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(balloonAddon));
			driver.findElement(balloonAddon).click();
		} else if (addon.equalsIgnoreCase("greetingCard")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(greetingAddon));
			driver.findElement(greetingAddon).click();
		} else if (addon.equalsIgnoreCase("teddybear")) {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(teddyBearAddon));
			driver.findElement(teddyBearAddon).click();
		} else if (addon.equalsIgnoreCase("chocolates")) {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(chocolatesAddon));
			driver.findElement(chocolatesAddon).click();
		} else if (addon.equalsIgnoreCase("")) {
			System.out.println("addon not requested");
		}
		return driver;
	}

	public boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}
}
