package com.wrapper;

public class Wrapper_to_Primitive {
	
	
	public static void main(String[] args) {
		Integer a=new Integer(3);
		
		int i=a.intValue();//converting Integer to int  
		int j=a;
		System.out.println(a+ " " +i+ " " +j);
		
		
	}

}
