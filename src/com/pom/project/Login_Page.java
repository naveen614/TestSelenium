package com.pom.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page  {
	
	
	public Properties prop;
	
	public General_Functions gef;
	

	private  WebDriver driver;
	
	public Login_Page(WebDriver driver){
		
		
		this.driver=driver;
		
	}
	
	public void setUserName() throws FileNotFoundException{
		
		gef.readPropertiesFile();
		//System.out.println(gef.prop.getProperty("Member_id_fieled"));
		
		
		
		driver.findElement(By.id(gef.prop.getProperty("Member_id_fieled"))).sendKeys(gef.prop.getProperty("UserName"));
			}
	
	public void setPwd(){
		driver.findElement(By.id(gef.prop.getProperty("Password_Field"))).sendKeys(gef.prop.getProperty("pwd"));
	}
	
	public void clickSignin(){
		driver.findElement(By.id(gef.prop.getProperty("SigninBtn"))).click();
	}
	
	public void loginTomail() throws FileNotFoundException{
		this.setUserName();
		this.setPwd();
		this.clickSignin();
		
		
	}
	


}



