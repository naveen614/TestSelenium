package com.excel.task;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class Reading_from_Excel {
	static WebDriver driver = new FirefoxDriver();
	static String s;
	public static void main(String[] args)
	{
		
		
		try{
		final String FilePath = "D:\\Andriod\\Selenium\\src\\com\\excel\\task\\Test.xlsx";
		FileInputStream fs = new FileInputStream(FilePath);
		
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sh=wb.getSheetAt(0);
		
		System.out.println(sh.getLastRowNum());
	    System.out.println("Name: "+sh.getSheetName()); 
	   
	    //Gets the row number 
	    Row row = sh.getRow(1);

	    System.out.println(row.getRowNum());

	    System.out.println("Val: "+sh.getRow(3).getCell(1).getStringCellValue());
		
	    
	  //Gets the respective cell value 
	    for (int i=1; i<=10; i++){
	     s =row.getCell(i).getStringCellValue();
	    String addres = row.getCell(i).getStringCellValue();
	driver.findElement(By.xpath("//test/tr[1]/td[i]")).sendKeys(s);
	    }
	/*Pattern ptn = Pattern.compile(",");
	String[] parts= ptn.split(s);
	for(String p:parts){
        System.out.println(p);
	}*/
	
	//Spliting cell value to two variables
	
	String [] temp;
	temp=s.split(",");
	String a1=temp[0];
	String a2=temp[1];
	System.out.println(" "+a1 );
	System.out.println(  "" +a2);
	
		
		
		
		fs.close();
FileOutputStream out =
    new FileOutputStream(new File("D:\\Andriod\\Selenium\\src\\com\\excel\\task\\Test2.xlsx"));
wb.write(out);
out.close();
 
} 
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		
	
	}
	
	}}

	

		
	/*	Iterator<Row> itr = sh.iterator();
		while(itr.hasNext()){
			Row r= itr.next();
			Iterator<Cell> i = r.iterator();
			while(i.hasNext()){
				Cell ce = i.next();
				System.out.println(ce.getStringCellValue());
			}
		}
		*/
		//HSSFSheet worksheet = wb.getSheetAt(0);
	//HSSFRow row1 = worksheet.getRow(0);
	