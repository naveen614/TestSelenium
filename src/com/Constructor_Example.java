package com;

public class Constructor_Example {
	
	float f;
	double d;
	char s;
	int id;  
	String name;  
		  
void display(){System.out.println(id+" "+name+ "" +f+ " " +d+ " " +s);}  
		  
		public static void main(String args[]){  
			Constructor_Example s1=new Constructor_Example();  
			Constructor_Example s2=new Constructor_Example();  
		s1.display();  //Constructor will provide default values while object creation
		s2.display();  
		}  
		
}  


