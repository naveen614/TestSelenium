package com.java;

import java.util.Scanner;

public class Palindrome_check {
	
	
	
	public static void main(String[] args) {
	/*	String s="malayalam", reverse=null;
		
		for(int i=s.length()-1; i>=0; i--){
			
			reverse=reverse+s.charAt(i);
			
			if(s.equals(reverse)){
				System.out.println("Palindrome" +reverse);
			}
					
			else{
				System.out.println("Not palindrome");
			}
	*/		
	
		
		
		      String original, reverse = "";
		      Scanner in = new Scanner(System.in);
		 
		      System.out.println("Enter a string to check if it is a palindrome");
		      original = in.nextLine();
		 
		      	 
		      for ( int i = original.length() - 1; i >= 0; i-- )
		         reverse = reverse + original.charAt(i);
		 
		      if (original.equals(reverse))
		         System.out.println("Entered string is a palindrome.");
		      else
		         System.out.println("Entered string is not a palindrome.");
		 
		   }
		
		
		
		
		
	
	

}
