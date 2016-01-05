package com.webtable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webtable {
	

    static WebDriver driver;
    int date=20;
	String montyyearExpected="Sept 2015";
	
	
	
	public static void clickingDtae(WebElement element, int date){
		
		driver.switchTo().alert().accept();
		
  		
  		List<WebElement> li=element.findElements(By.tagName("td"));
  		
  		for(WebElement e:li){
  			if(e.getText()==date+""){
  				e.click();
  			}
  		}
	}
	
	void selectTheMonthYear(WebDriver driver,String monthyearExpected){
		String monthYearText=driver.findElement(By.xpath(".//*[@id='rbcal_txtOnwardCalendar']/table[1]/tbody/tr[1]/td[2]")).getText();
		
		
		
		while(monthYearText==monthyearExpected)
		{
			
		}
		
		
	}	
	
			
			
			
			
			
   
	

                public static void main(String[] args) {  
                	
                	
                	
                	driver=new FirefoxDriver();
                	
              
                  driver.get("https://www.redbus.in");
                //  driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[4]/p[3]/a")).click();
                  driver.findElement(By.xpath(".//*[@id='txtOnwardCalendar']")).click();
                  
               String FirstTableheader=driver.findElement(By.xpath(".//*[@id='rbcal_txtOnwardCalendar']/table[1]/tbody/tr[1]/td[2]")).toString();
               String SecondTableheader=driver.findElement(By.xpath(".//*[@id='rbcal_txtOnwardCalendar']/table[2]/tbody/tr[1]/td[2]")).toString();
                  WebElement htmlbody=driver.findElement(By.xpath(".//*[@id='rbcal_txtOnwardCalendar']/table[1]"));
                  WebElement htmlbody2=driver.findElement(By.xpath(".//*[@id='rbcal_txtOnwardCalendar']/table[2]"));
                  
                  List<WebElement> TableData=htmlbody.findElements(By.tagName("td"));
                  System.out.print(TableData);
                  
                  List<WebElement> TableData2=htmlbody2.findElements(By.tagName("td"));
                  System.out.print(TableData);
                  
                  String Month_Year="Oct 2015";
                  String Date="20";
                  
               
                  
                  
                  
                  if(FirstTableheader==Month_Year){
                	  System.out.println("Date matched");
                	  
                	  
                  }
                  else if (SecondTableheader==Month_Year){
                	  System.out.println("Second table");
                	  
                	  
                  }else{
                	  
                	  driver.findElement(By.xpath(".//*[@id='rbcal_txtOnwardCalendar']/table[2]/tbody/tr[1]/td[3]/button")).click();
                  }
                  
                
                  
                  
                  for(WebElement Table : TableData){
                	  System.out.println(Table.getText());
                	  if(Table.getText().equals(Month_Year)){
                		
                		  System.out.println("ss");
                      	
                      	
                	  
                	  
                	  for(WebElement Table1: TableData){
                		  if(Table1.getText().equals(Date )){
                       		  
                       		  System.out.println("ss2");
                       		  
                       		  Table1.click();
                       	  
                       	//getText().equals("Sept 2015")   && Table.getText().equals("20")
                       		  
                		  }
                		  
                		  
                		  else{
                			  
                			  
                		  
                		  
                       	  
                       	  
                  for(WebElement Table2 : TableData2){
                	  System.out.println(Table2.getText());
                	  if(Table2.getText().equals(Month_Year)){
                		
                		  System.out.println("ss");
                      	
                      	
                	  
                	  
                	  for(WebElement Table3: TableData2){
                		  if(Table3.getText().equals(Date)){
                       		  
                       		  System.out.println("ss2");
                       		  
                       		  Table3.click();
                       	  
                       	//getText().equals("Sept 2015")   && Table.getText().equals("20")
                       		  
                		  }}}}
                          
                          }
                          
                	  } 
                	  }}}}
                  
                  
                	  
                	  
                



                
/*public class Webtable {

    public static void main(String[] args) {
                                    WebDriver driver;
                                    driver=new ChromeDriver();
                                    driver.get("http://help.juno.com/support/email/email-setup.html");
                                    driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[4]/p[3]/a")).click();
                                    
                                    
                                    WebElement htmlbody=driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[3]/table[2]/tbody/tr/td[1]/table/tbody"));
                                    List<WebElement> TotalRowCount=htmlbody.findElements(By.tagName("tr"));
                                    System.out.println("Number of rows in a table is: "+TotalRowCount.size());
int rowindex=0;
for(WebElement rowElement:TotalRowCount)
{

      List<WebElement> TotalColumnCount=rowElement.findElements(By.tagName("td"));
      int ColumnIndex=0;
      //System.out.println("No of columns:"+ TotalColumnCount.size());
      
      for(WebElement colElement:TotalColumnCount)
      {
            System.out.println(colElement.getText()); // To get entire table content row and column wise
                      //System.out.println("Row "+rowindex+" Column "+ColumnIndex+" Data "+colElement.getText());
            if(ColumnIndex==0 && ((colElement.getText()).equals("Password:")))
            {
                  System.out.println("My RowIndex is:"+rowindex);
            }           
            ColumnIndex=ColumnIndex+1;
      }
      System.out.println("===========row completed==========");
      rowindex=rowindex+1;
}
}


}
*/