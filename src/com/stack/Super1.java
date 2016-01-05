package com.stack;

class Supa{
	
	int speed=10;
	Supa(){
	System.out.println("Super class constructor");
	}
	
	public void superClassMethod(){
		System.out.println("Super class method");
	}
	
}

public class Super1 extends Supa {
	
	
	Super1(){
	super();//will invoke parent class constructor
	}
	
	public void superClassMethod(){
	System.out.println("sub class method");
	}

	
	void display(){
		superClassMethod();//current class method
		super.superClassMethod();//super class method
		super.speed=10;//Super class variable
		
		  
	int	speed=20;
		System.out.println(super.speed);//will print speed of supa class 
		System.out.println(speed);//will print speed of super1 class 
	}
	
	
	
	public static void main(String[] args) {
		
Super1 s1= new Super1();
s1.display();
	}

}
