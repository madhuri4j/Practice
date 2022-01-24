package com.learning.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreditCardInfo {
WebDriver driver;
By CCNumber=By.xpath("//*[@placeholder='Card Number']");
By mmYY=By.xpath("//*[@placeholder='MMYY']");
By cvc=By.xpath("//*[@placeholder='CVC']");
	public CreditCardInfo(WebDriver driver)
	{
this.driver=driver;
}
	public WebDriver enterCCInfo()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CCNumber));
		driver.findElement(CCNumber).sendKeys("55555555555544441122123");	
		return driver;
	}
	
}
