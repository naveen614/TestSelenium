package com.hidden.element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.ExecuteScript;

public class Scrolling_page {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		driver=new FirefoxDriver();
		
		driver.get("http://www.qa7.netzero.net");
		driver.manage().window().maximize();
		
		//Scrolling to bottom of the page
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement element=driver.findElement(By.xpath(".//*[@id='landing-devices-www']/div[4]/div[2]/div/div[2]/a/div[2]"));
		//Scrolling to particular element
		((JavascriptExecutor)driver).executeScript("areguments[0].scrollIntoView, element)");
		//Scrolling by Co-ordinates of the page.
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
		
	}

}
