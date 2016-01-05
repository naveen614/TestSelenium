package com.simple;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JS_Alert_handle {
	
	static WebDriver driver;
	
	
	public static void main(String args[]) {
		
		driver=new FirefoxDriver();
		driver.get("http://jsbin.com/usidix/1");
		//driver.get("http://www.qa7.netzero.net");
		
		
		
		//Passing Parameeter to xpath using any variable
		String x="button";
		
		driver.findElement(By.xpath("//input[@type= '"+x+"']")).click();
		
		//driver.findElement(By.xpath("//input[@type='button']")).isDisplayed();
		//driver.findElement(By.xpath("//input[@type='button']")).getAttribute("");
		
		
		
		String alertmessage=driver.switchTo().alert().getText();
		
		
		
		
		
		
		driver.switchTo().alert().dismiss();
		System.out.println(alertmessage);
		
		
		
		
		
		
		
		
		
		
		
		
				
		
	}
	
	

}
