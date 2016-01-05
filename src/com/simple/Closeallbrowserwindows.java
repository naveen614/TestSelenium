package com.simple;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Closeallbrowserwindows {


	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.naukri.com/");
		String cHandle = driver.getWindowHandle();
        
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> it=allWindowHandles.iterator();
        
        while(it.hasNext()){
        	
        	String childwindow=it.next();
        	
        	if(!cHandle.equalsIgnoreCase(childwindow)){
        		driver.switchTo().window(childwindow);
        		System.out.println(driver.getTitle());
        		driver.close();
        	}
        }
        
        driver.switchTo().window(cHandle);
        System.out.println(driver.getTitle());
        
        
        
        
        
		
	}
	
}
