package com.java;

class Honda3 {
	
	public void speed(){
	System.out.println("Upcasting");
	}
}

class Upcasting_Example extends Honda3{  
	
	public void speed(){
		System.out.println("Honda3");
	}
	
	  
		 public static void main(String args[])
		 {  
			 Honda3 obj=new Upcasting_Example();  
	obj.speed();
	
		  
		}  

}

