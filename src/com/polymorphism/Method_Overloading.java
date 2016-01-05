package com.polymorphism;

public class Method_Overloading {
	
	public void sum(int a, int b){
		
		System.out.println(a+b);
	}
	
	//Changing return type of method overloding is possible but parameeters should change
	public int sum(int a, char b){
		
		System.out.println(a+b);
		return b;
		
	}
	
	
	
	
	//Overloaded method with changing num of arguments. Changing return type of method overloding is not possible
	public void sum(int  a, int b, int c){
		System.out.println(a+b+c);
		
		
	}
	
	//Changing Data type of arguments. 
	public int sum(char a, char b){
		System.out.println(a+b);
		return b;
		
	}
	
	
	public static void main(String[] args) {
		
		Method_Overloading movlo=new Method_Overloading();
		movlo.sum(2, 3);
		movlo.sum(7, 8, 9);
	}

}
