package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {
	
		
		public static void main(String[] args) {
			
			
			WebDriverManager.chromedriver().version("97").setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.facebook.com/");
			
			
			
			WebElement textuser = driver.findElement(By.id("email"));
			textuser.sendKeys("hari4064@gmail.com");
			
			WebElement textpass = driver.findElement(By.name("pass"));
			
			textpass.sendKeys("Soda@006600");
			
			WebElement b = driver.findElement(By.name("login"));
			
			b.click();
			driver.quit();
			
		}
 
}
