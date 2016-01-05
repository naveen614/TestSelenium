package com.actions;

import mx4j.util.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Select_multiple_elements {

	
	
	public static void main(String[] args) {
		
	
		//System.setProperty("webdriver.chrome.driver", "D:\\nvadla\\Selenium jars\\Drivers\\chromedriver.exe");
	
		WebDriver driver =new FirefoxDriver();
		//driver.get("http://jqueryui.com/resizable/");
		
		driver.get("http://jqueryui.com");
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		
		//driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[2]/a")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		
		
		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[4]/a")).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		
		WebElement element=driver.findElement(By.xpath(".//*[@id='selectable']/li[3]"));
		Select sel=new Select(element);
		
		
		
		
		
		
		
		action.keyDown(Keys.CONTROL).click(sel.getOptions().get(3)).keyUp(Keys.CONTROL);
		
		action.build().perform();

	driver.manage().deleteAllCookies();
	
	
	}
}
