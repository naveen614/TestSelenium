package com.hub;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.lift.WebDriverTestContext;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Sample_Script {

public static void main(String[] args) throws MalformedURLException {
		
		

/*Grid hub starting:
Location: E:\
Jar: selenium-server-standalone-2.48.2
java -jar selenium-server-standalone-2.48.2.jar -role hub

to check hub is running or not 
 http://localhost:4444/grid/console 


Grid nodes starting:
java -jar selenium-server-standalone-2.48.2 -role webdriver -hub http://10.103.27.243:4444/grid/register -port 5566

IP address of the HUB need to be mentioned:  http://10.103.27.243:4444/grid/register 
*/	
	
//Mentioning BrowserName while starting node server	
//java -jar selenium-server-standalone-2.42.0.jar -role node -browser browserName=safari -hub http://localhost:4444/grid/register
	
		
		
		//WebDriver driver=new FirefoxDriver();
		
	
	
		DesiredCapabilities capability=DesiredCapabilities.firefox();
		capability.setVersion("32");
		capability.setPlatform(Platform.WINDOWS);
		WebDriver driver=new RemoteWebDriver(new URL("http://10.103.27.26:5555/wd/hub"), capability);		
		driver.get("http://www.startnetzero.net");
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		
		
		
	
	
}
}
