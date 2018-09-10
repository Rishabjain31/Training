package com.qait.automation.training;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class testing {
	public static void main(String[] args) {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rishabh.jain1\\Documents\\chromedriver.exe");
		 
		WebDriver driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		//driver.findElement(By.cssSelector("a")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		WebElement basic= driver.findElement(By.cssSelector("a[href=\"/tatoc/basic\"]"));
		js.executeScript("arguments[0].click();", basic);
		driver.findElement(By.className("greenbox")).click();
		driver.switchTo().frame(0);
		WebElement box1 = driver.findElement(By.id("answer"));
		String Box1_color = box1.getAttribute("class");
		String Box2_color = "";
		while(!Box1_color.equals(Box2_color)){
			  
			    driver.switchTo().defaultContent();
			    driver.switchTo().frame(0);
			    driver.findElement(By.cssSelector("a")).click();
			    driver.switchTo().frame(0);
			    Box2_color=driver.findElement(By.id("answer")).getAttribute("class");
			     }
		   driver.switchTo().defaultContent();
		   driver.switchTo().frame(0).findElement(By.linkText("Proceed")).click();
		   
		   Actions action = new Actions(driver);
		   WebElement drag=driver.findElement(By.id("dragbox"));
		   WebElement drop=driver.findElement(By.id("dropbox"));
		   action.dragAndDrop(drag,drop).perform();
		   driver.findElement(By.linkText("Proceed")).click();
		   
		   driver.findElement(By.linkText("Launch Popup Window")).click();
		   String parentwindow=driver.getWindowHandle();
		   String subWindow=null;
		   Set <String> windows = driver.getWindowHandles();
		   Iterator itr = windows.iterator();
		   while(itr.hasNext()){
		   	subWindow = (String) itr.next();
		   }
		   driver.switchTo().window(subWindow);
		   driver.findElement(By.id("name")).sendKeys("abc");
		   driver.findElement(By.id("submit")).click();
		   driver.switchTo().window(parentwindow);
		   driver.findElement(By.linkText("Proceed")).click();
		   
		   driver.findElement(By.linkText("Generate Token")).click();
		   String token_value=driver.findElement(By.id("token")).getText();
		   //System.out.println(token_value);
		   String str=token_value.substring(token_value.indexOf(":")+2);
		   Cookie cookie=new Cookie("Token",str);
		   driver.manage().addCookie(cookie);
		   driver.findElement(By.linkText("Proceed")).click();
		
	}
}
