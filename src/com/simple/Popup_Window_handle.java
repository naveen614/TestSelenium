package com.simple;

import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Popup_Window_handle {
	

		static WebDriver driver;

		
		public void test_CloseAllWindowsExceptMainWindow() {
			driver = new FirefoxDriver();
			// It will open Naukri website with multiple windows
			driver.get("http://www.naukri.com/");
			//driver.get("http://www.popuptest.com/");
			//driver.findElement(By.linkText("Multi-PopUp Test")).click();
			// To get the main window handle
			String windowTitle= getCurrentWindowTitle();
			String mainWindow = getMainWindowHandle(driver);
			Assert.assertTrue(closeAllOtherWindows(mainWindow));
			Assert.assertTrue(windowTitle.contains("Jobs - Recruitment"), "Main window title is not matching");
		}
			
		public String getMainWindowHandle(WebDriver driver) {
			return driver.getWindowHandle();
		}

		public String getCurrentWindowTitle() {
			String windowTitle = driver.getTitle();
			return windowTitle;
		}
		
		//To close all the other windows except the main window.
		public static boolean closeAllOtherWindows(String openWindowHandle) {
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String currentWindowHandle : allWindowHandles) {
				if (!currentWindowHandle.equals(openWindowHandle)) {
					driver.switchTo().window(currentWindowHandle);
					driver.close();
				}
			}
			
			driver.switchTo().window(openWindowHandle);
			if (driver.getWindowHandles().size() == 1)
				return true;
			else
				return false;
		
		
		}

		public static void main(String args[]){
		
		Popup_Window_handle popup=new Popup_Window_handle();
		popup.test_CloseAllWindowsExceptMainWindow();
		popup.getCurrentWindowTitle();
		
				
		
	}

}
