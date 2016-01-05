package com.java;

public class This_Keyword {
	
	int id;
	String name;
	
	This_Keyword() {
	System.out.println("default constructor");
	
	
	
	}
	
	This_Keyword(int a, int b){
		System.out.println("Second constructor");
		
			
	}
	
	This_Keyword(int id, String name) {
	this();//it is used to invoked current class constructor.
	//this(5, 7);// Used to invoke current class parameterized constructor
		this.id=id;
	this.name=name;//To reffer a cuurrent class instance variables
	System.out.println(id);
		
	}
	void display(){
		
		System.out.println(id+ "  " +name);
		
		
	}
	void view(){
		System.out.println("View method");
		this.display();//this can be used to call current class method
	}

	
	
	public static void main(String[] args) {
		
		
		This_Keyword thiskey=new This_Keyword(10, "Naveen");
		This_Keyword thiskey2=new This_Keyword(50, "Kumar");
		
		
		//thiskey.display();
		//thiskey2.display();
		thiskey.view();
		
	}
}
