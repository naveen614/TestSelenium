package com.String;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class String_Example {
	static WebDriver driver;
	SimpleDateFormat gmtDateFormat = new SimpleDateFormat("MMddHHmmss");
	
	public static void main(String[] args) {
		driver=new FirefoxDriver();
	String s=new String("Naveen"); //using new operator
	s.concat("Chary");
	
	String s1="Thota";//literal format
	s1.concat("Chary");
	
	
	String s2="Naveen";
	
	System.out.println(s2==s);//s and s2 memory locations are different[Looks for the memory locations]
	System.out.println(s2.equals(s));//S2 and S objects holding same data[Looks for the content or data of object]
	
	
	System.out.println(s);//Strings are immutable
	System.out.println(s1);
	
	
	
	 
	//Taking screenshot
	/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrFile, new File(System.getProperty("base.dir")+"\\src\\"+gmtDateFormat.format(new Date())+".jpg"));
	  driver.quit();*/
	}

}
