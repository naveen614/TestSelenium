package com.thread;

public class Thread_example{
	
	int a=100;
	public void m1(){
		System.out.println("M1 method executing");
		System.out.println(a);
	}
	
	public int hashCode(){
		
		
		return 9;
		
	}
	
	public static void main(String... args) {
		for(int i=0; i<=10; System.out.println("naveen" +i), i++){
			System.out.println("naveen loop");
		
			
		}
		
		
		Thread_example tex=new Thread_example();
		Object aa=new Object();
		
		
		System.out.println(tex.a);
		tex.m1();
		
		System.out.println(aa.hashCode());
		System.out.println(tex.hashCode());
		System.out.println(tex.getClass());
	}

}
