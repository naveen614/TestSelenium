package com.testng.annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataproviderForEYI {
	
		
	
	
	WebDriver driver;
	
	
	
	@BeforeMethod
	public void browserstart(){
		driver=new FirefoxDriver();
	
	driver.manage().window().maximize();
	driver.get("http://store.qa7.netzero.net");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.findElement(By.xpath(".//*[@id='servicesNav']/following-sibling::ul/a[1]")).click();
	driver.findElement(By.xpath(".//*[@id='serviceList']/section[1]/div[3]/button")).click();
	
	//Getting ID attribute value using get attribute
	System.out.println(driver.findElement(By.xpath(".//*[@id='realButton']")).getAttribute("id"));
	
	
	driver.findElement(By.xpath(".//*[@id='realButton']")).click();
	
	String pagename=driver.findElement(By.xpath("//div[@class='nexabook32pt mTop30']")).getText();
	
	//Hard assertion will stop the execution
	Assert.assertEquals(pagename, "CUSTOMER INFO");
	
	//Softassertion will not stop the execution 
	SoftAssert asr=new SoftAssert();
	asr.assertEquals(pagename, "CUSTOER INFO", "Asssertion Failed");
	}
	
@Test(dataProvider="getData")
public void Enterdata(String firstname, String lastname, String Street){
	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstname);
	
	//Retrieving the text entered in input field
	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastname);
	
	driver.findElement(By.id("billingAddress.streetName")).sendKeys(Street);
	
	}





@DataProvider
public Object[][] getData(){
	return new Object[][]{
			{"Naveen", "Chary", "State"}
			
	};
	
}

}



