package com.stack;


	public class Bike extends Vehicle{  
	  /*Bike5(){  
	   super();//will invoke parent class constructor  
	   System.out.println("Bike is created");  
	  }  
	    */
	
		  void display(){
				System.out.println("Bike");  
			  }
			  
		
		  public void dotest(){
				Vehicle b=new Bike();
			    super.display();
		  }
		public static void main(String args[]){  
			Vehicle v = new Bike();
			v.nodisplay();
		}  
} 
