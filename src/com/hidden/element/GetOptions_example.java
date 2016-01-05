package com.hidden.element;

import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

 

public class GetOptions_example {

            public WebDriver driver;

            public void verifyLogin(){

                        driver.findElement(By.name("username")).sendKeys("user1");

                        driver.findElement(By.name("password")).sendKeys("user1");

                        driver.findElement(By.name("submit")).click();                                 

            }

            public void verifyRegistration(){

                        driver.findElement(By.linkText("Registration")).click();

                        driver.findElement(By.linkText("Permanent Registration")).click();

            }

  @Test(enabled=true)

  public void printDrodowns_Loc_Values() {

              List<WebElement> str=driver.findElements(By.tagName("select"));

              System.out.println(str.size());

              for(int i=0; i<str.size(); i++)

              {

                          if(str.get(i).getText().equalsIgnoreCase("Self"))

                                    {

                                    System.out.println(str.get(i).getText());

                        new Select(driver.findElement(By.name("PATIENT_CAT"))).selectByVisibleText(str.get(i).getText());   

                                    }

                          System.out.println("Dropdown name locator :"+str.get(i).getAttribute("name"));

                          System.out.println("Dropdown values are :"+str.get(i).getText());

              }

             

  }

  @Test

  public void printTxtBox_Loc() {

            List<WebElement> str=driver.findElements(By.tagName("input"));

            System.out.println(str.size());

            for (int i = 0; i < str.size(); i++) {

                        if(str.get(i).getAttribute("type").equalsIgnoreCase("text"))

                        {

                                    System.out.println("Textbox loc :"+str.get(i).getAttribute("name"));

                        } else if(str.get(i).getAttribute("class").equalsIgnoreCase("log"))

                        {

                                    System.out.println("Button values :"+str.get(i).getAttribute("value"));

                        }

            }           

  }

 

  @BeforeTest

  public void beforeTest() {

              driver=new FirefoxDriver();

              driver.get("http://selenium4testing.com/hms");

              verifyLogin();

              verifyRegistration();

  }

}