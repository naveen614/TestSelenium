package com.test.plan;

import java.lang.reflect.Array;

public class Reverse_Sentence {
	
	public static void main(String[] args) {
		
	
	
	String Sentence="Naveen chary";
	
	
	
	
	
	//System.out.println(Sentence.charAt(i));
		
	String s[]=Sentence.split(" ");
	String reverse="";
	for(int i=s.length-1; i>=0; i--)
		
	//System.out.println(s[i]);
	
		reverse+=(s[i]+" ");
	System.out.println(reverse);
	
	
	
	
		
	
	}
}


