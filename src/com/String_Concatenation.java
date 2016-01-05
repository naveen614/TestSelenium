package com;

public class String_Concatenation {
	public static void main(String[] args) {
		String s=30+40+"sachin"+50+70;
		System.out.println(s);
		
		String s1="Sachin ";  
		String s2="Tendulkar";  
		String s3=s1.concat(s2);  
		System.out.println(s3);//Sachin Tendulkar
		System.out.println(s2.substring(3));
		System.out.println(s1.substring(1, 2));
		}}
