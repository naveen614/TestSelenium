package com.appium.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Web_view_Automation {

	public static void main(String[] args) throws MalformedURLException {
	
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("browserName","chrome");
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("deviceName","LGD325f7c1c6d6");
		capabilities.setCapability("platformVersion","4.4");
		capabilities.setCapability("platformName","Android");

		//capabilities.setCapability("appPackage","in.redbus.android");
		//capabilities.setCapability("appPackage","com.swappableapp");
		//capabilities.setCapability("appActivity", ".controllers.activities.SplashScreen");
		//capabilities.setCapability("appActivity", "in.redbus.android.activity.SplashScreen");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
			driver.manage().deleteAllCookies();
		driver.get("http://www.qa7.netzero.net/start/getCTCmLanding.do");
		System.out.println("Web View accessed");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//[@index=3]"));
		
		//Set<String> contextNames = driver.getContextHandles();
		//for (String contextName : contextNames) {
		    //System.out.println(contextNames); //prints out something like NATIVE_APP \n WEBVIEW_1

		
		}
		
		
	}


