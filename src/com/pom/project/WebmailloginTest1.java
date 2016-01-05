package com.pom.project;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WebmailloginTest1{
	
	Properties prop;
	
	WebDriver driver;
	General_Functions gef;
	
	@BeforeTest
	public void setUp()  throws Exception{
		gef.readPropertiesFile();
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(gef.prop.getProperty("BaseURL"));
		
	}
	
	
	@Test
	public void test_Home_Page()  throws Exception {
		Login_Page Loginpage=new Login_Page(driver);
		
		Loginpage.loginTomail();
		driver.quit();
		
	
	
//	objHome = new Home_Page(driver);
	
	//Assert.assertTrue(objHome.getHomePageUserName().contains("nqatest_gvinay5@netz...!"));
	

	
	
	
	
	}
	
	
	

}