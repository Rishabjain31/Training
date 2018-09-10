package com.qait.automation.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class hristest {
	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rishabh.jain1\\Documents\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://hris.qainfotech.com");
	}
	
	@AfterTest
	public void closeBrowser() {
	  driver.close();	
	}
	@Test
	public void loginwithcorrectcredentials() {
		driver.findElement(By.id("txtUserName")).sendKeys("rishabh.jain1");
		driver.findElement(By.id("txtPassword")).sendKeys("rishabhjain1");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		//Assert.assertTrue("User did not login to HRIS", driver.findElement(By.id("txtPassword")).getAttribute("style").contains("solid red"));
	
		//driver.findElement(By.id("txtPassword")).sendKeys("rishabhjain1");
		//driver.findElement(By.cssSelector("input[type='submit']")).click();
		Assert.assertEquals("Invalid Login", driver.findElement(By.linkText("Invalid Login")).getText());
	}
}
