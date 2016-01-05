package com.polymorphism;

public class Overridden extends Override_example {
	
		
	
		
		public void override(int a, int b){
			System.out.println("Overridden method " +(a+b));
		
			
			
		}
		
		public void overriden_Class_method(){
			System.out.println("Overridden class method");
			
			
		}
		
		
		public static void main(String[] args) {
			Override_example over=new Overridden();
			over.override(5, 5);
			
			
			over.overrideclasMethod(7, 5);
			Overridden overr=new Overridden();
			
			
			
			
			
			
			
		}
		
	}