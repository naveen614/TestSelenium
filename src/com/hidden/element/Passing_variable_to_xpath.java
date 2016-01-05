package com.hidden.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Passing_variable_to_xpath {
	static WebDriver driver;
	public static void main(String[] args) {
		driver=new FirefoxDriver();
		driver.get("http://jsbin.com/usidix/1");
		
		
		
		
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
