package com.simple;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_selectction {

	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://www.jsbin.com/osebed/2");
		WebElement el=driver.findElement(By.id("fruits"));
	
		
		Select sel=new Select(el);
		
		sel.selectByIndex(1);
		sel.selectByVisibleText("Banana");
		if(sel.isMultiple()){
			System.out.println("multiple selected");
			
		}else{
			System.out.println("not selected");
		}
		
		sel.deselectAll();
		
		
		
		
	}
	
}
