package com.simple;

import com.sendmail.SendEmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser_Testing {
	
	
	
	
	
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	
	public void before_Test(String browser)throws Exception{
		
		if(browser.equalsIgnoreCase("FF")){
			driver=new FirefoxDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "D:\\nvadla\\Selenium jars\\Drivers\\IEDriverServer.exe");
			
			driver=new InternetExplorerDriver();
	}

		
		
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\nvadla\\Selenium jars\\Drivers\\chromedriver.exe");
	
			driver=new ChromeDriver();
		}
		
		
		
		else{
			 
            //If no browser passed throw exception
 
            throw new Exception("Browser is not correct");
 
        }
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
    }
	
	
	
	@Test(priority=1)
	public void First_test(){
		driver.navigate().to("http://www.qa7.netzero.net");
		//driver.get("http://www.qa7.netzero.net/new");
		//driver.findElement(By.xpath(".//*[@id='servicesNav']/following-sibling::ul/a[3]")).click();
		
		System.out.println(driver.getTitle());
		driver.close();
		
	}
	
	
	
 
}
