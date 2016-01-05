package com.polymorphism;

public class Override_example {
	
	
	private int privatemember=10;
	
	public void override(int a, int b){
		
		
		System.out.println(a+b);
	}
	
	public void overrideclasMethod(int c, int d){
		
		System.out.println("Class non-overriden method " +(c+d));
	}

}


