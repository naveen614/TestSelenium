package com.java;

import java.util.Scanner;

public class Removing_chars {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();		
		char ch=sc.next().charAt(0);
		String s2="";
		for(int i=0;i<s1.length();i++) 
			
		if(s1.charAt(i)!=ch) s2=s2+s1.charAt(i);
		
		System.out.println(s2);
	}
	
}
