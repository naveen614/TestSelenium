package com.simple;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Security_certificates_handle {
	

	
	
	public static void main(String[] args) {
		WebDriver driver;
		
		
	//Handling SSL certificates 
		
		DesiredCapabilities cap=new DesiredCapabilities().firefox();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver=new FirefoxDriver(cap);

		
     	ProfilesIni profile=new ProfilesIni();
		FirefoxProfile fp=profile.getProfile("SeleniumProfile");
		//iPad user agent 
		fp.setPreference("general.useragent.override", "Mozilla/5.0(iPad; U; CPU iPhone OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B314 Safari/531.21.10");
	    driver=new FirefoxDriver(fp);
		driver.navigate().to("https://webmail.lax.qa1.netzero.net");
        //driver.get("https://webmail.lax.qa1.netzero.net");	





//Adding Keys of keyboard using Keys
driver.findElement(By.id("fsdfs")).sendKeys(Keys.NUMPAD1, Keys.ADD, Keys.ENTER);



		
	}
	

}
