package com.hidden.element;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Google {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		
		//To find height and width of specific webElement
		Dimension d=driver.findElement(By.xpath("//input[@id='lst-ib']")).getSize();
		System.out.println("Width: " +d.width);
		System.out.println("hight: " +d.height);
		
		//To get the exact x and y axis position
		Point point=driver.findElement(By.xpath("//input[@id='lst-ib']")).getLocation();
		System.out.println("X Position: " +point.x);
		System.out.println("y Position: " +point.y);
		
		
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Motorola");
		
		//.//*[@id='sbtc']/div[2]/div[2]/div[1]
		WebElement table=driver.findElement(By.className("sbdd_b"));
		
		List<WebElement> rows=table.findElements(By.tagName("ul"));
		
		Iterator<WebElement> i=rows.iterator();
		
		
		System.out.println("====================================");
		while(i.hasNext()){
			
			WebElement row=i.next();
			List<WebElement> columns=row.findElements(By.tagName("span"));
			
			
			Iterator<WebElement> j=columns.iterator();
			while(j.hasNext()){
				
				WebElement column=j.next();
				
System.out.println(column.getText());
			}
			
			System.out.println("");
			
			System.out.println("=============================");
			
			
			
		}
		/*
		driver.findElement(By.xpath("//button[@class='lsb']")).click();
//		WebElement el=driver.findElement(By.cssSelector("ol#rso"));
		WebElement el=driver.findElement(By.xpath("//ol[@id='rso']"));
		List<WebElement> optionCount = el.findElements(By.tagName("h3"));
		
		
		
		System.out.println(optionCount.size());*/
		
		
		
		
		
		
	
	}

}
