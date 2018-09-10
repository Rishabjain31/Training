package com.qait.automation.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hristestng {
	WebDriver driver;

	public  Hristestng(WebDriver driver) {
		this.driver = driver;
	}
	
	public String URL() {
		return driver.getCurrentUrl();
	}
	public void loginWithCorrectCredentials() {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUserName")).sendKeys("rishabh.jain1");
		driver.findElement(By.id("txtPassword")).sendKeys("rishabhjain1");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}
	public void loginWithIncorrectCredentials() {
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUserName")).sendKeys("rishabh.jain1");
		driver.findElement(By.id("txtPassword")).sendKeys("Rishabh123");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}
	public void loginWithNoCredentials() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement wait1 =wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtUserName")));
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUserName")).sendKeys("rishabhjain1");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}
	public void logout() {
		driver.findElement(By.className("profile-btn")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.findElement(By.cssSelector("a[href='https://hris.qainfotech.com:8086/user/logoff']")).click();
        
	}
	public Boolean isTimesheetPage() {
		return this.driver.getCurrentUrl().equals("https://hris.qainfotech.com:8086/time/timesheet");	
	}
	public void timeSheet() {
		String value= driver.findElement(By.xpath("//div[@id='dv_2018-06-18']//child::span[@class='ng-binding'][1]")).getText();
		System.out.println(value);
	}
}

