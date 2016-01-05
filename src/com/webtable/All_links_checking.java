package com.webtable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class All_links_checking {

	public static void main(String[] args) throws MalformedURLException {
		
		
		
		
		WebDriver driver=new FirefoxDriver();
		
		/*DesiredCapabilities capability=DesiredCapabilities.firefox();
		WebDriver driver=new RemoteWebDriver(new URL("http://10.103.27.26:5555/wd/hub"), capability);		
		driver.get("http://www.startnetzero.net");
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		*/
		driver.get("http://www.startnetzero.net");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		
		
		List<WebElement> linktext=driver.findElements(By.tagName("a"));
		/*
		 //For loop link text printing
		for(int i=1;i<=linktext.size(); i=i+1 ){
			
			System.out.println(linktext.get(i).getText());
			
			
		}
		*/
		
		

		
		String [] linktexts=new String[linktext.size()];
		System.out.println(linktext.size());
		int i=0;
		for(WebElement e: linktext){
			
			linktexts[i]=e.getText();
			System.out.println(linktexts[i]);
			
			i++;
			
		}
		
		
		for(String t: linktexts){
			driver.findElement(By.linkText("Sports")).click();
			
		}
		
		driver.navigate().back();
		
	
	}

		
		
	}

