package com.test.plan;

public class Polindrome {
	
	public static void main(String[] args) {
		
		
		int number=121, sum=0, r, temp;
		
		
		temp=number;
		while(number>0){
		
			r=number%10;
			sum=(sum*10)+r;
			number=number/10;
				
		}
		
		if(temp==sum)
		{
			System.out.println("Palindrome");
		}else
			System.out.println("Not palindrome");
		
		
		
	}

}
