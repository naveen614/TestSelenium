package com.test.plan;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PalindromeExample {
	
	/**
	* The HelloWorld program implements an application that
	* simply displays "Hello World!" to the standard output.
	*
	* @author  Zara Ali
	* @version 1.0
	* @since   2014-03-31 
	*/
	
	
	public static void main(String[] args) {
		
		int r, sum=0, temp;
		
		int n=4574;
		temp=n;
		while(n>0){
			r=n%10;
			sum=(sum*10)+r;
			
			
			n=n/10;
			
		}
		
		if(temp==sum){
			
			System.out.println("Palindrome");
		}
		
		else{
			System.out.println("Not a palindrome");
		}
		
	}
	
	
	
	
/*	
	public static void main(String[] args) {
		String str="cricket, movies, music";	
		//str.contains("cricket");
		
		str.split(",", 2);
		
		System.out.println(str.split(","));
		//System.out.println(str.contains("cricket"));
	
	StringTokenizer st=new StringTokenizer(str, ",");
	List li=new ArrayList();
	
	while(st.hasMoreElements()){
		
		//System.out.println(st.nextElement());
	li.add(st.nextElement());	
	}
	
	System.out.println(li);
	
	}*/
	

}
