package com.learning.selenium.Testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.learning.selenium.Pages.AddressPage;
import com.learning.selenium.Pages.BillingInfo;
import com.learning.selenium.Pages.CreditCardInfo;
import com.learning.selenium.Pages.LaunchHomePage;

public class BirthdayOrder {
	WebDriver driver;
	
	public void loadSite()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ftd.com/flowers/best-sellers?cid=ftddts&prid=ftddts");
		driver.manage().window().maximize();
	}
	
	@Test
	public void birthdayOrder() throws Exception {
		loadSite();
		LaunchHomePage obj1 = new LaunchHomePage(driver);
		obj1.currentDateOrder("current");
	AddressPage obj2=new AddressPage(driver);
	obj2.recipientInfo();
	CreditCardInfo obj3= new CreditCardInfo(driver);
	obj3.enterCCInfo();
	BillingInfo obj4= new BillingInfo(driver);
	obj4.billingEqualsRecipient();
	
	}
	
	@Test
	public void sundayOrder() throws InterruptedException
	{
		loadSite();
		LaunchHomePage obj1 = new LaunchHomePage(driver);
		obj1.currentDateOrder("sunday");
		AddressPage obj2=new AddressPage(driver);
	obj2.recipientInfo();
	CreditCardInfo obj3= new CreditCardInfo(driver);
	obj3.enterCCInfo();
	BillingInfo obj4= new BillingInfo(driver);
	obj4.billingNotEqualRecipient();
	}
}
