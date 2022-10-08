package com.learning.selenium.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.learning.selenium.Utilities.RetryClickElement;

public class AddToCart {

	public WebDriver driver;
	public boolean clickSucess;
	RetryClickElement obj1=new RetryClickElement(driver);
	public AddToCart(WebDriver driver) {
		this.driver = driver;
	}

	By productSearchZipcode = By.xpath("//*[@id=\"zipCode-35aJquKJSaHf2L77Ee6j8w\"]");
	By dateField = By.xpath("//*[@name='date']");
	By dateSelect = By.xpath("(//*[@aria-label='Choose Date'])[1]");
	By currentDate = By.xpath("//*[@aria-selected=\"true\"]");
	By dayIsSunday = By.xpath("//*[contains(@aria-label,'Sunday') and @aria-disabled='false']");
	By nextMonthPointer=By.xpath("(//*[@cursor='pointer'])[2]");
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
			try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(dayIsSunday));
			driver.findElement(dayIsSunday).click();
			clickSucess=true;
			}
			catch(Exception e)
			{
				clickSucess=false;
				if (clickSucess=false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(nextMonthPointer));
					driver.findElement(nextMonthPointer).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(dayIsSunday));
					driver.findElement(dayIsSunday).click();
					clickSucess=true;
				}
				else 
				System.out.println("Exception occured because there are no sundays active for deliver in this month" + ""+e);
			}
			
			/*if(clickSucess=false)
			{
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(nextMonthPointer));
				driver.findElement(nextMonthPointer).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(dayIsSunday));
				driver.findElement(dayIsSunday).click();
				clickSucess=true;
			}
			catch(Exception e)
			{
			 System.out.println("Exception occured while clicking sunday date"+"  "+e);
			}
			}*/
		}
		wait.until(ExpectedConditions.elementToBeClickable(shopNow));
		driver.findElement(shopNow).click();
		try {
		obj1.retryingFindClick(Bouquet1,driver);
		}
		catch(Exception e)
		{
			System.out.println("exception"+e);
		}
		obj1.retryingFindClick(bouquetType, driver);
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		driver.findElement(addToCart).click();
		addon(addons);
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkout));
		driver.findElement(checkout).click();
		return driver;
	}

	public WebDriver addon(String addon) {
		if (addon.equalsIgnoreCase("balloon")) {
			obj1.retryingFindClick(balloonAddon,driver);
		} else if (addon.equalsIgnoreCase("greetingCard")) {
			obj1.retryingFindClick(greetingAddon,driver);
		} else if (addon.equalsIgnoreCase("teddybear")) {
			obj1.retryingFindClick(teddyBearAddon,driver);
		} else if (addon.equalsIgnoreCase("chocolates")) {
			obj1.retryingFindClick(chocolatesAddon,driver);
		} else if (addon.equalsIgnoreCase("")) {
			System.out.println("addon not requested");
		}
		return driver;
	}


}
