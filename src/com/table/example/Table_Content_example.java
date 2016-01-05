package com.table.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Table_Content_example {
	
	
	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\nvadla\\Selenium jars\\Drivers\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		driver.get("http://help.juno.com/support/email/email-setup.html");
		driver.findElement(By.xpath("html/body/table[3]/tbody/tr/td[4]/p[3]/a")).click();
		WebElement htmlbody=driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[3]/table[2]/tbody/tr/td[1]/table/tbody"));
		List<WebElement> row=htmlbody.findElements(By.tagName("tr"));
		for(int rnum=0; rnum<row.size(); rnum++)
		{
			
		}
		
		
	}

}
