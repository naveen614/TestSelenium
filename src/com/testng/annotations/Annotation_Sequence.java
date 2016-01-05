package com.testng.annotations;

import java.sql.Driver;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.testng.annotations.*;



public class Annotation_Sequence {
	WebDriver driver=new FirefoxDriver();
	
	
	

	
	
	@BeforeSuite
	public void BeforeSuite(){
				
		System.out.println("before suite");
		
		
	}
	

@AfterSuite
public void AfterSuite(){
	System.out.println("After Suite");
}

@BeforeClass
public void BeforeClass(){
	System.out.println("BeforeClass");
}

@AfterClass
public void afterclass(){
	System.out.println("After class");
	}

@BeforeTest
public void beforetest(){
	System.out.println("beforetest");
}

@AfterTest
public void aftertest(){
	System.out.println("aftertest");
	
}

@Test
public void test(){
	System.out.println("test");
}


@Test
public void test2(){
	System.out.println("test2");
}



@Test
public void test3(){
	System.out.println("test3");
}

@BeforeMethod
public void beforemethod(){
	System.out.println("beforemethod");
	
}

@AfterMethod
public void aftermethod(){
	System.out.println("aftermethod");
	
}
@BeforeGroups
public void beforegroup(){
	System.out.println("beforegroup");
}

@AfterGroups
public void aftergroup(){
	System.out.println("after group");
	
	
	
	
}

}
