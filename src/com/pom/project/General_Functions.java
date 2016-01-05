package com.pom.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class General_Functions {
	public static Properties prop=new Properties();
	
	static final String file="D:\\Mars_Workspace\\com.selenium.test\\src\\main\\resources\\Xpath.properties";
	static FileInputStream fis;
	

	
	
	public  static void readPropertiesFile() throws FileNotFoundException {
		fis=new FileInputStream(file);
//		file="D:\\Andriod\\Selenium\\src\\com\\pom\\project\\Xpath.properties";
		
		
		try {
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		System.out.println(prop.getProperty("BaseURL"));
		
	}
	

}
