package com.simple;

abstract class Bank{    
abstract int getRateOfInterest();    

public void display(){
System.out.println("sdfjsd");	


}


}    
    
class SBI extends Bank{    
int getRateOfInterest(){return 9;}    
}    
class PNB extends Bank{    
int getRateOfInterest(){return 8;}    
}    
    
class TestBank{    
public static void main(String args[]){    
Bank b=new SBI();//if object is PNB, method of PNB will be invoked    
b.display();
//int interest=b.getRateOfInterest();    
//System.out.println("Rate of Interest is: "+interest+" %");    
}}    