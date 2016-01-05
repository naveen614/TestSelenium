package com.sendmail;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Autoit_File_upload {
	
	
	 WebDriver driver;
	 
	 @BeforeTest
	 public void setup() throws Exception {
	  driver =new FirefoxDriver();     
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	
	 }
	 
	
	 @Test
	 public void testCaseOne_Test_One() throws IOException, InterruptedException {
	  //Click on browse button.
	  driver.findElement(By.name("img")).click();    
	  
	  try{
	  //To execute autoIt script .exe file which Is located at E:\\AutoIT\\ location.
	  Runtime.getRuntime().exec("E:\\HTML\\test.exe");
	  
	  
	  }catch(Exception e){
		  System.out.println(e);
	  }
	  }
	}



