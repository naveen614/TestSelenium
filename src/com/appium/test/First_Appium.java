package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.*;
public class First_Appium {

public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
DesiredCapabilities capabilities = new DesiredCapabilities();

capabilities.setCapability("browserName","");
capabilities.setCapability("automationName","Appium");
capabilities.setCapability("deviceName","LGD325f7c1c6d6");
capabilities.setCapability("platformVersion","4.4");
capabilities.setCapability("platformName","Android");

capabilities.setCapability("appPackage","in.redbus.android");
//capabilities.setCapability("appPackage","com.swappableapp");
//capabilities.setCapability("appActivity", ".controllers.activities.SplashScreen");
capabilities.setCapability("appActivity", "in.redbus.android.activity.SplashScreen");

AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

//driver.findElement(By.xpath("//*[@in.redbus.android:id=action_bar]/ImageButton")).click();







	}

}
