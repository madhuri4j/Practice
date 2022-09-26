package com.learning.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreditCardInfo {
public WebDriver driver;
String CCNum="5555555555554444";
String ExpiryDate="1123";
By CCNumberiFrame=By.xpath("//iframe[@title='Field container for: Credit Card Number']");
By NameonCard=By.xpath("//iframe[@title='Field container for: Name on Card' ]");
By mmYYiFrame=By.xpath("//iframe[@title='Field container for: Expiration Date (MM/YY)']");
By cvc=By.xpath("//iframe[@title='Field container for: CVC']");
	public CreditCardInfo(WebDriver driver)
	{
this.driver=driver;
}
	public WebDriver enterCCInfo()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.elementToBeClickable(CCNumberiFrame));
		WebElement frameCC=driver.findElement(CCNumberiFrame);
		driver.switchTo().frame(frameCC);
		WebElement CreditCardNumber=driver.findElement(By.xpath("//input[@placeholder='Credit Card Number']"));
		CreditCardNumber.click();
		for(int i=0;i<=15;i++)
		{
		char a=CCNum.charAt(i);
		String b=Character.toString(a);
		CreditCardNumber.sendKeys(b);
		}
		
		driver.switchTo().defaultContent();
		driver.findElement(NameonCard).sendKeys("test");
		wait.until(ExpectedConditions.elementToBeClickable(mmYYiFrame));
		WebElement mmYYframe=driver.findElement(mmYYiFrame);
		driver.switchTo().frame(mmYYframe);
		WebElement mmYY=driver.findElement(By.xpath("//input[@placeholder='Expiration Date (MM/YY)']")); 
		mmYY.click();
		for(int i=0;i<=3;i++)
		{
		char a=ExpiryDate.charAt(i);
		String b=Character.toString(a);
		mmYY.sendKeys(b);
		}
		driver.switchTo().defaultContent();
		driver.findElement(cvc).sendKeys("123");
		return driver;
	}
	
}
