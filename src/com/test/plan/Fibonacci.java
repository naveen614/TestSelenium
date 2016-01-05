package com.test.plan;

class Fibonacci
{
	public static void main(String args[])
	{		
		int prev, next, sum;
		
		prev=next=1;
		
		for(int n=1; n<=5; n++)
		{
			System.out.println(prev);
			sum=prev+next;
			prev=next;
			next=sum;
		}
		
	}
}



