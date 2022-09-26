package com.learning.selenium.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClosePopUp {
	public WebDriver driver;
	By popup= By.xpath("//form[@id='bx-form-1837939-step-1']");
	By closePopup=By.xpath("//button[@id='bx-close-inside-1837939']");
	By NothanksLink=By.xpath("(//button[text()='No Thanks'])[1]");
public ClosePopUp(WebDriver driver)
{
	this.driver=driver;
	}
	
	public WebDriver closePopUp()
	{
		driver.findElement(popup).click();
		driver.findElement(closePopup).click();
		return driver;
		
	}
}
