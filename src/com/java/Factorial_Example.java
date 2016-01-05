package com.java;

public class Factorial_Example {
	
	public static void main(String[] args) {
		int number=5, factorial;
		factorial=number;
		
		for( int i=(number-1); i>1; i--)
				
			factorial=factorial*i;
			System.out.println("Factorial of number is " +  factorial);
			
		
	}

}
