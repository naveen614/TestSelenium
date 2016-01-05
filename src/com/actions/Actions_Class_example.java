package com.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions_Class_example {
	
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "D:\\nvadla\\Selenium jars\\Drivers\\chromedriver.exe");
	
		WebDriver driver =new FirefoxDriver();
		//driver.get("http://jqueryui.com/resizable/");
		
		driver.get("http://jqueryui.com");
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		
		//driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[2]/a")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
	/*	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		
		Actions action=new Actions(driver);
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.cssSelector("#draggable"));
		
		WebElement element2=driver.findElement(By.cssSelector("#droppable"));
		

		//Drag and drop commands
		
		action.clickAndHold(element).moveToElement(element2).release(element2).build().perform();
		//action.dragAndDrop(element, element2).perform();
		
		WebElement sidelabel=driver.findElement(By.xpath(".//div[@id='sidebar']/aside[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(sidelabel));
		
		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[3]/a")).click();*/
		
		//Resize of an webElement
		
		
		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[3]/a")).click();
		
		//driver.findElement(By.xpath("")).getCssValue("color");
		
		/*
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		WebElement resize=driver.findElement(By.cssSelector(".ui-resizable-handle.ui-resizable-se"));
		
		action.clickAndHold(resize).moveByOffset(50, 50).release().build().perform();*/
		
		
		
		
		
	}

}
