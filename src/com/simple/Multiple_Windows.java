package com.simple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Multiple_Windows {
	WebDriver driver;
	
	
	//Multiple windows handling using Indexing
	    public void getHandleToWindow(){
	    	driver=new FirefoxDriver();
	    	driver.get("http://www.naukri.com/");
	    	
	    	String cHandle = driver.getWindowHandle();
	        
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        
	        
	        
	        
	        Iterator<String> it=allWindowHandles.iterator();
	        String popup_handle = null;
	        int i=0;
	        while(it.hasNext()){
	        	popup_handle=it.next();
	        	if(i==1) break;
	        	i++;
	        }
	    
	        driver.switchTo().window(popup_handle);
	        System.out.println(driver.getTitle());
	        driver.close();
	        driver.switchTo().window(cHandle);
	        driver.close();
	    }  
	    
	    
	   /* Set handles = driver.getWindowHandles();
        String[] individualHandle = new String[handles.size()];
        Iterator it = handles.iterator();
        int i =0;
        while(it.hasNext())
        {
            individualHandle[i] = (String) it.next();
            i++;
        }

driver.switchTo().window(individualHandle[1]);
System.out.println(driver.getTitle());
driver.close();

	    }*/
	    	
	    	
	    	
	     

	        		
	        		
	        		

	        public static void main(String args[]){
	Multiple_Windows multi=new Multiple_Windows();
	multi.getHandleToWindow();

	


}

}
	        
	

	
	
	
	
	 
		
	    
	
