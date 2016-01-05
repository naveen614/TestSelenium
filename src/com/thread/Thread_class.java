package com.thread;

public class Thread_class extends Thread {

	public static void main(String... args) {
		
		Thread_class ta=new Thread_class();
		
		ta.start();
		
		for(int i=0; i<=10; i++)
			System.out.println("Main method executing");
		
		
	}
	
	
	
	public void run(){
		for(int i=0; i<=10; i++)
			System.out.println("Run method executing");
	}
	
}
