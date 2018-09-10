package com.qait.automation.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Test_Hris {
	WebDriver driver;

	@BeforeTest(dependsOnMethods = {})
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rishabh.jain1\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://hris.qainfotech.com/login.php");
		Assert.assertEquals(driver.getCurrentUrl(), "https://hris.qainfotech.com/login.php");
	}

	@Test(priority = 1)
	public void login_with_incorrect_credentials() {
		driver.findElement(By.id("txtUserName")).sendKeys("rishabh.jain1");
		driver.findElement(By.id("txtPassword")).sendKeys("rishabhjain1");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		// Assert.assertTrue("User did not login to HRIS",
		// driver.findElement(By.id("txtPassword")).getAttribute("style").contains("solid
		// red"));

		// driver.findElement(By.id("txtPassword")).sendKeys("rishabhjain1");
		// driver.findElement(By.cssSelector("input[type='submit']")).click();
		Assert.assertEquals("Invalid Login", driver.findElement(By.linkText("Invalid Login")).getText());

	}

	@Test(priority = 2)
	public void login_with_correct_credentials() {
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("rishabh.jain1");
		driver.findElement(By.id("txtPassword")).sendKeys("Qait@123");
		driver.findElement(By.cssSelector("input[type='submit']")).click();

	}

	@Test(priority = 3)
	public void attempt_Login_With_No_Password_Should_Annotate_Black_Password_Field() {
		driver.get("https://hris.qainfotech.com/login.php");
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("rishabh.jain1");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		Assert.assertTrue(driver.findElement(By.id("txtPassword")).getAttribute("style").contains("red"));
	}
}
