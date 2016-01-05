package com.stack;

class Scooty{  
	  /*Vehicle(){System.out.println("Vehicle is created");}  
	} */ 
	  void display(){
		System.out.println("Vehicle");  
	  }
	  
}
	 class Bike5 extends Scooty{  
	  /*Bike5(){  
	   super();//will invoke parent class constructor  
	   System.out.println("Bike is created");  
	  }  
	    */
	
		  void display(){
			  super.display();
				System.out.println("Bike");  
			  }
			  
		
	
		public static void main(String args[]){  
			Scooty b=new Bike5();
			   b.display();
	
		}  
} 

