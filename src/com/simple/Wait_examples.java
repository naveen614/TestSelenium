package com.simple;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Wait_examples {
	
	WebDriver driver;
	
	
	public void method(){
		
		driver=new FirefoxDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Explicit wait
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement elem=driver.findElement(By.xpath(""));
		WebElement elem2=driver.findElement(By.xpath(""));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("abc")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));	
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		wait.until(ExpectedConditions.visibilityOf(elem));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));
		wait.until(ExpectedConditions.elementSelectionStateToBe(elem2, true));
		
		
	}
	
	
	
	

}
