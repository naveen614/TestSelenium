package com.simple;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class My_Popup_handle {

WebDriver driver;
	
	
	//Window handle with Title name
    public void getHandleToWindow( ){
    	driver=new FirefoxDriver();
    	driver.get("http://www.naukri.com/");
    	
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.switchTo().alert().accept();
    	
    WebDriverWait wait=new WebDriverWait(driver, 10);	
    
    driver.getWindowHandle();
    
    
    
    
        	
    	//driver.get("http://www.popuptest.com/");
		//driver.findElement(By.linkText("Multi-PopUp Test")).click();
  /*  	
String parentWindowHandle = driver.getWindowHandle(); // save the current window handle.
        WebDriver popup = null;
        Set<String> windowIterator = driver.getWindowHandles();
        System.err.println("No of windows :  " + windowIterator.size());
          for (String s : windowIterator) {
                 popup = driver.switchTo().window(s);
          System.out.println("Window Title : " + popup.getTitle());
          System.out.println("Window Url : " + popup.getCurrentUrl());
          driver.close();
          driver.switchTo().window(parentWindowHandle);
         
          }
		return popup;

        
        
        }*/
    
    
    String cHandle = driver.getWindowHandle();
    
    Set<String> allWindowHandles = driver.getWindowHandles();
    Iterator<String> it=allWindowHandles.iterator();
    
    String popup_handle = null;
    while(it.hasNext()){
    	popup_handle=it.next();
    	    	
    }
    Assert.assertTrue(popup_handle.contains("ICS"), "ICS United");
    System.out.println(driver.getTitle());
    driver.switchTo().window(popup_handle);
    driver.close();
}  
    
        
        public static void main(String args[]){
        	My_Popup_handle multi=new My_Popup_handle();
multi.getHandleToWindow();


        }
}
