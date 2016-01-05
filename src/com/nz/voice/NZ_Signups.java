package com.nz.voice;


import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.common.funcitons.General_Functions;

public class NZ_Signups extends General_Functions{
	
	Properties prop=new Properties();
	
	
	WebDriver driver;
    
 	@BeforeMethod
 	 public void before(){
 		
 		System.out.println(" Beforemethod");
 	
 	}
 		 
 	
 	@AfterMethod
 	public void after()
    {
 	
 		System.out.println(" After Method");
    }
    
    @Test

    public void Fury_Signup()
    {
 	

    	Select dropdown = new Select(driver.findElement(By.id("designation")));
    	dropdown.selectByIndex(2);
    	dropdown.selectByValue("sdjf");
    	dropdown.selectByVisibleText("sdfjsd");
    	
    	



    	
    	   	 
    	
    	   	
    	
    }
    
    @Test
    public void Fury_Signup2() {
    System.out.println(" Test Method2");
  
    }
    
    
    @Test
    public void Fury_Signup3() {
    System.out.println(" Test Method3");
  
    }
    
    
    
    @Test
    public void Fury_Signup4() {
    System.out.println(" Test Method4");
  
    }
    
    
    
}
