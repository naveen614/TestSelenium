package com.testng.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {
	WebDriver driver;
	@BeforeMethod
	public void openBrowser(){
		
		//Selenium Profile creation
		ProfilesIni profile=new ProfilesIni();
		FirefoxProfile fp=profile.getProfile("SeleniumProfile");
		fp.setAcceptUntrustedCertificates(true);
		
		driver=new FirefoxDriver(fp);
		driver.get("http://webmail.netzero.net");
		
		
		
	}
	
	@Test(dataProvider="TestData", dataProviderClass=DataProvide_class.class)
	public void testMethod(String name, String pwd){
		driver.findElement(By.id("memberId")).sendKeys(name);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("signin")).click();
		
	}
	
	@AfterMethod
	public void close_Browser(){
		System.out.println(driver.getTitle());
		driver.close();
	}
	
	
	
	/*@DataProvider
	public Object[][] getData(){
		return new Object[][]{
				{"nqatest_gvinay24", "netzero"},
				{"nqatest_gvinay25", "netzero"},
				{"nqatest_gvinay32", "netzero"},
				{"nqatest_gvinay5", "netzero1"}
			
		};
		
	}*/
	
	
	
	

}
