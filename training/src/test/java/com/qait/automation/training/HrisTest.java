package com.qait.automation.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HrisTest {
	WebDriver driver;
	Hristestng obj;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rishabh.jain1\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		obj = new Hristestng(driver);
		driver.get("https://hris.qainfotech.com/login.php");
		driver.findElement(By.cssSelector("a[href='#panel1']")).click();
		driver.manage().window().maximize();
	}

//	 @AfterTest
//	public void closeBrowser() {
//		driver.quit();
//	}

	protected void logMessage(String message) {
		Reporter.log(message, true);
	}

//	@Test(priority = 1)
//	public void firstCase() {
//		obj.loginWithCorrectCredentials();
//		driver.findElement(By.cssSelector("a[href='#panel1']")).click();
//		String label = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]/div")).getText().trim();
//		Assert.assertEquals("Invalid Login", label);
//		logMessage("element not visible");
//		// div[@id='login']//div[contains(@class,'loginTxt')]/div
//	}

	@Test(priority = 2)
	public void SecondCase() {
		obj.loginWithIncorrectCredentials();
		//driver.findElement(By.cssSelector("a[href='#panel1']")).click();
		Assert.assertTrue(obj.URL().contains("hris.qainfotech"));
		logMessage("element not visible");
		obj.logout();
	}

//	@Test(priority = 3)
//	public void ThirdCase() {
//		obj.loginWithNoCredentials();
//		driver.findElement(By.cssSelector("a[href='#panel1']")).click();
//		Assert.assertTrue(driver.findElement(By.id("txtPassword")).getAttribute("style").contains("red"));
//		logMessage("element not visible");
//	}

//	@Test(priority = 4)
//	public void FourthCase() {
//		obj.timeSheet();
//		Assert.assertTrue(obj.isTimesheetPage());
//		obj.logout();
//	}
}
