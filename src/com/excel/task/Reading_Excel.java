package com.excel.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reading_Excel {
	
	public static void main(String[] args)
	{
		
		
		try{
		String FilePath = "D:\\Andriod\\Selenium\\src\\com\\excel\\task\\Test.xlsx";
		FileInputStream fs = new FileInputStream(FilePath);
		
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sh=wb.getSheetAt(0);
		
	
		
	
		
		
		
		
		Iterator<Row> rowIterator = sh.iterator();
		while(rowIterator.hasNext() ){
			
			Row row=rowIterator.next();
		
		Iterator<Cell> cellIterator = row.cellIterator();
		
		while(cellIterator.hasNext()){
			Cell cell=cellIterator.next();
			
			
			
			
			
			
			
			switch(cell.getCellType()) {
			
			
            case Cell.CELL_TYPE_BOOLEAN:
                System.out.print(cell.getBooleanCellValue() + "\t\t");
                
                
                break;
            case Cell.CELL_TYPE_NUMERIC:
                System.out.print(cell.getNumericCellValue() + "\t\t");
                break;
            case Cell.CELL_TYPE_STRING:
                System.out.print(cell.getStringCellValue() + "\t\t");
                break;
        }
    }
    System.out.println("");
}
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
	