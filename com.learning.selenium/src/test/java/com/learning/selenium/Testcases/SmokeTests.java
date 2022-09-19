package com.learning.selenium.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.learning.selenium.Pages.AddressPage;
import com.learning.selenium.Pages.BillingInfo;
import com.learning.selenium.Pages.CreditCardInfo;
import com.learning.selenium.Pages.AddToCart;

public class SmokeTests {
	WebDriver driver;
	AddToCart obj1;
	AddressPage obj2;
	CreditCardInfo obj3;
	BillingInfo obj4;

	@BeforeTest
	public void loadSite() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ftd.com/flowers/best-sellers?cid=ftddts&prid=ftddts");
		driver.manage().window().maximize();
	}

	@Test
	public void birthdayOrder() throws Exception {
		//loadSite();
		obj1 = new AddToCart(driver);
		obj1.currentDateOrder("current","balloon");
		obj2 = new AddressPage(driver);
		obj2.recipientInfo("Residence","Birthday");
		obj3 = new CreditCardInfo(driver);
		obj3.enterCCInfo();
		obj4 = new BillingInfo(driver);
		obj4.billingEqualsRecipient();
		driver.quit();
	}

	/*@Test
	public void sundayOrder() throws InterruptedException {
		loadSite();
		obj1 = new AddToCart(driver);
		obj1.currentDateOrder("sunday","greetingCard");
		obj2 = new AddressPage(driver);
		obj2.recipientInfo("business","Congratulations");
		obj3 = new CreditCardInfo(driver);
		obj3.enterCCInfo();
		obj4 = new BillingInfo(driver);
		obj4.billingNotEqualRecipient();
		driver.quit();
	}

	@Test
	public void funeralOrder() throws InterruptedException {
		loadSite();
		obj1 = new AddToCart(driver);
		obj1.currentDateOrder("current","");
		obj2 = new AddressPage(driver);
		obj2.recipientInfo("funeral","Sympathy");
		obj3 = new CreditCardInfo(driver);
		obj3.enterCCInfo();
		obj4 = new BillingInfo(driver);
		obj4.billingNotEqualRecipient();
		driver.quit();
	}*/
	
	
	
	
	
	
}
