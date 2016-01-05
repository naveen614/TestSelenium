package com.hidden.element;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Hidden_Element {
	
	
	public static void main(String[] args) throws IOException {
		
		try{
			final String FilePath = "E:\\Java programs\\Test.xlsx";
			FileInputStream fs = new FileInputStream(FilePath);
			
			XSSFWorkbook wb=new XSSFWorkbook(fs);
			XSSFSheet sh=wb.getSheetAt(0);
			
			System.out.println(sh.getLastRowNum());
		    System.out.println("Name: "+sh.getSheetName()); 
		   
		    //Gets the row number 
		   // Row row = sh.getRow(3);
		    Row row=sh.getRow(1);

		    System.out.println(row.getRowNum());

		   // System.out.println("Val: "+sh.getRow(3).getCell(1).getStringCellValue());
			
		    
		  //Gets the respective cell value  
		String s=row.getCell(3).getStringCellValue();
		
		//String s=sh.getCellComment(1, 3).toString();
	String s2=row.getCell(4).getStringCellValue();
		//String s2=sh.getCellComment(1, 4).toString();
		
		/*Pattern ptn = Pattern.compile(",");
		String[] parts= ptn.split(s);
		for(String p:parts){
	        System.out.println(p);
		}*/
		
		//Spliting cell value to two variables
		
		/*String [] temp;
		temp=s.split(",");
		String a1=temp[0];
		String a2=temp[1];
		System.out.println(" "+a1 );
		System.out.println(  "" +a2);*/
		
			
			
			
		
		
		
			
	  	
    	WebDriver driver=new FirefoxDriver();
    	driver.manage().window().maximize();
		driver.get("http://www.netzero.net");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='servicesNav']/following-sibling::ul/a[1]")).click();
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
		
		
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(s);
		
		//Retrieving the text entered in input field
		String text=driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value");
		System.out.println(text);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(s2);
		
		WebElement dropdown=driver.findElement(By.id("billingAddress.state"));
		
		//Get the dropdown elements using Select 
		Select sel = new Select(dropdown);
		
		
	//	sel.selectByIndex(5);
		
		
		
		
		
		List<WebElement> options = sel.getOptions();
		String expecteddropdownnames="AK;CA;FA;IN ";
		String dropdownnames []=expecteddropdownnames.split(";");
		
		
		for(String str:  dropdownnames){
			boolean found=false;
			for(WebElement ele: options){
				if(str.equals(ele.getText())){
					found=true;
					
					System.out.println("Found options" +str);
					
					break;
				}
				
			}
		if(!found){
			
			System.out.println("Option value does not exist");
		}
		
		
		}
		
		
		for(WebElement optionss:options){
			System.out.println(optionss.getText());
		}
		
		
		if(sel.isMultiple()){
			System.out.println("it will select more than one option");
		}
		else
		{System.out.println("it wont select multiple options");}
		
		/*
		//Selection dropdown elements using List 
		
		 List<WebElement> TableData=dropdown.findElements(By.tagName("option"));
		for(WebElement table: TableData){
			System.out.println(table.getText());
		}
		*/
		
		//Hidden element handling
		
		((JavascriptExecutor)driver)
		.executeScript("document.getElementById('10005').setAttribute('style','display:block')");
	
	driver.findElement(By.xpath(".//*[@id='bankRoutingNumber']")).sendKeys("42145555");
	
	
		
		}
		catch (FileNotFoundException e) {
		    e.printStackTrace();

		}
			
		
    	
    }

		
	
}		
	
		
