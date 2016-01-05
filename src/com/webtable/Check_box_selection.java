package com.webtable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Check_box_selection {
	static WebDriver driver;
	
public static void main(String[] args) {
	driver=new FirefoxDriver();
	
	driver.get("http://www.toolsqa.com/automation-practice-form");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*List<WebElement> checkboxes=driver.findElements(By.xpath(".//input[@type='radio']"));
	
	for(WebElement e: checkboxes){
		
		if(!e.isSelected()){
			e.click();
		}
	}*/
	
	List<WebElement> radio_button=driver.findElements(By.name("profession"));
	
	int isize=radio_button.size();
	
	for(int i=0;i<isize; i++){
		
		String svalue=radio_button.get(i).getAttribute("value");
		
		if(svalue.equalsIgnoreCase("Automation Tester")){
			radio_button.get(i).click();
		}
				
	}
	
	
	
	
	
	
	
}

}
