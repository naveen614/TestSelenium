package com.common.funcitons;

import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class General_Functions {
	Properties prop=new Properties();
	
	
	DesiredCapabilities cap = new DesiredCapabilities();
	
	
	WebDriver driver;
	
	 public void Browser_startup(String baseurl)throws Exception{

	 		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\config.xml");
	 	try{	
	 		prop.load(fis);
	 		String browser= prop.getProperty("Browser");
	 		
	 		
	 		if(browser.equals("Mozilla"))
	 		    		{
	 			
	 			
	 			String PROXY = "squid.hyd.int.untd.com:3128";

	 			org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
	 			proxy.setHttpProxy(PROXY)
	 			     .setFtpProxy(PROXY)
	 			     .setSslProxy(PROXY);
	 			
	 			cap.setCapability(CapabilityType.PROXY, proxy);
	 			driver=new FirefoxDriver(cap);
	 			
	 		
	 			
	 		    		}
	 		
	 		else if (browser.equals("Chrome"))
	 		{
	 			System.setProperty("webdriver.chrome.driver", "D:\\nvadla\\Selenium jars\\Drivers\\chromedriver.exe");
	 			 driver = new ChromeDriver();
	 			 
	 		}
	 		
	 		else if (browser.equals("IE"))
	 		{
	 			System.setProperty("webdriver.chrome.driver", "D:\\nvadla\\Selenium jars\\Drivers\\IEDriverServer.exe");
	 			 driver = new InternetExplorerDriver();
	 		}
	 		
	 		
	 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 		driver.get(prop.getProperty("baseurl"));
	 			
	 	}
	 	catch (Exception e){
	 		System.out.println("Error: "+e.getMessage());
	 	}
	 		
	 		//driver.get(prop.getProperty(baseurl));
	         //driver.findElement(By.xpath("html/body/center/div[1]/table/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/a")).click();
	 		}
	 		 
	 

	}



