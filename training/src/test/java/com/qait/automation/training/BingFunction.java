package com.qait.automation.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingFunction {
	WebDriver driver;

	public BingFunction(WebDriver driver) {
		this.driver = driver;
	}

	// boolean status = true;
	// WebElement textarea1 =
	// driver.findElement(By.xpath("//textarea[@id='t_sv']"));
	// WebElement textarea2 =
	// driver.findElement(By.xpath("//textarea[@readonly='readonly']"));
	// WebElement translateButton =
	// driver.findElement(By.xpath("//a[@id='t_revIcon']"));
	// Select langauge = new Select(driver.findElement(By.id("t_tl")));
	// langauge.selectByVisibleText("Hindi");
	//
	// textarea1.sendKeys("hello");
	// String str1 = textarea1.getAttribute("value");
	// System.out.println(str1);
	// translateButton.click();
	// // String str2 = textarea2.getAttribute("value");
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// String
	// str2=js.executeScript("document.querySelector(\"textarea[readonly='readonly']\").textContent").toString();
	// System.out.println(str2);
	// //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// WebDriverWait wait = new WebDriverWait(driver, 10);
	// WebElement element =
	// wait.until(ExpectedConditions.elementToBeClickable(By.id("t_revIcon")));
	// // element.click();
	// //translateButton.click();
	// String str3 = textarea2.getAttribute("value");
	// System.out.println(str3);
	// // if (value.equals(str3))
	// // status = true;
	// // else
	// // status = false;
	// return status;
	// }

	public boolean verify() {
		
		boolean status = true;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById(\"t_sv\").value='hello'");
		String str1=driver.findElement(By.cssSelector("div[class=t_txtblkin] textarea[id=t_sv]")).getText();
		driver.findElement(By.cssSelector("div[class='t_out trtl_inline col '] div[class=t_select] option[value=hi]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		js.executeScript("document.getElementById(\"t_revIcon\").click");
		String str2 = driver.findElement(By.cssSelector("div[class=t_txtblkout] textarea[id=t_tv]")).getText();
		if (str1.equals(str2))
			  status = true;
			  else
			  status = false;
			 return status;
	}
}
