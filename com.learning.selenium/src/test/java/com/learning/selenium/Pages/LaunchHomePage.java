package com.learning.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchHomePage {

	@Test
	public void homePage()
	
	{
		System.setProperty("webdriver.chrome.driver", "H:\\Practice\\com.learning.selenium\\src\\test\\resources\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ftd.com");
		boolean text=driver.findElement(By.xpath("//*[@id=\"menu-main\"]/div[3]/button[1]/span/span")).isDisplayed();
				Assert.assertTrue(text);
		System.out.println("checking logo is present or not: "+text);
	}
}
