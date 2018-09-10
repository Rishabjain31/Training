package com.qait.automation.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BingTest {
	WebDriver driver;
	BingFunction obj;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rishabh.jain1\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		obj = new BingFunction(driver);
		driver.get("https://www.bing.com/translator");
		driver.manage().window().maximize();
	}

	@Test
	public void match() {
		boolean status = obj.verify();
		Assert.assertTrue(status);
		System.out.println("strings are same");
	}

	// @AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
