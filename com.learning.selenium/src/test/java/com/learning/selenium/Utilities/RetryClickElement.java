package com.learning.selenium.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RetryClickElement {
WebDriver driver;
public RetryClickElement(WebDriver driver)
{
	this.driver=driver;
	}
	public boolean retryingFindClick(By by,WebDriver driver) {
		boolean result = false;
		int attempts = 0;
		WebDriverWait wait2=new WebDriverWait(driver, 20);
		while (attempts < 2) {
			try {
				wait2.until(ExpectedConditions.elementToBeClickable(by)).click();
				
				result = true;
				break;
			} catch (Exception e) {
				System.out.println("the exception is"+e);
			}
			attempts++;
		}
		return result;
	}
}
