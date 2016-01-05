package com.simple;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DriverCommand;



public class Landing_Pages {
	

	
	public static void main(String args[]) throws IOException, NullPointerException{
		
		WebDriver driver=new FirefoxDriver();
		/**List<String> lines = 
				FileUtils.readLines(new File(System.getProperty("D:\\Andriod\\Selenium\\src\\com\\simple\\URL.txt")));
				Iterator<String> it = lines.iterator();
				while(it.hasNext()) {
					
					String url = (String)it.next();
		===========================================================
		File file = new File("D:\\Andriod\\Selenium\\src\\com\\simple\\URL");
		FileReader fileReader = new FileReader(file);

		 BufferedReader br = new BufferedReader(fileReader);
String line;
		 		 // if no more lines the readLine() returns null
		 while ((line = br.readLine()) != null) {
		      // reading lines until the end of the file

		 } **/
		
		
	/**	
		File file = new File("D:\\Andriod\\Selenium\\src\\com\\simple\\URL");
		try {
		    List<String> strLine = FileUtils.readLines(file);
	
		    
				  System.out.println (strLine);

			
		    
		    
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		
		
		**/
		SimpleDateFormat gmtDateFormat = new SimpleDateFormat("MMddHHmmss");
		
		String fin="D:\\Andriod\\Selenium\\src\\com\\simple\\URL";
		FileInputStream fis = new FileInputStream(fin);
		 
		
		
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		while ((line = br.readLine()) != null) {
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(line);
			//System.out.println(driver.getCurrentUrl());
			//driver.findElement(By.xpath("")).getText();
			
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(scrFile, new File(System.getProperty("base.dir")+"\\src\\"+gmtDateFormat.format(new Date())+".jpg"));
			
			  
			  
			String redirected=null;
			redirected=driver.getCurrentUrl();
			
			System.out.println(driver.getCurrentUrl());
			
			String fin2="D:\\Andriod\\Selenium\\src\\com\\simple\\NewURL";
			File fout = new File(fin2);
			FileOutputStream fos = new FileOutputStream(fout);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(redirected);
			bw.newLine();
	 
			
			
			
				
		
			
		}
	 
		br.close();
		

	}
		
		
}
	
	


