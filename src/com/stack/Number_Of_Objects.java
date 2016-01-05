package com.stack;

public class Number_Of_Objects {
	  
	   // Set count to zero initially.
	    static int count = 0;
	  
	   public Number_Of_Objects() {
	       
	       // Every time the constructor runs, increment count.
	       count = count + 1;
	     
	       // Display count.
	      System.out.println("Created object number: " + count);
	 }
	   
	   
	  public static void main(String[] args) {
		  Number_Of_Objects a=new Number_Of_Objects();
		
		  Number_Of_Objects a2=new Number_Of_Objects();
		  Number_Of_Objects a3=new Number_Of_Objects();
	}
	}