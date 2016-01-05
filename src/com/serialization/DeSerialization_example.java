package com.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialization_example {
	
		 public static void main(String args[])throws Exception{  
		    
		  ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
		  Student s=(Student)in.readObject();  
		  System.out.println(s.id+" "+s.name+" "+s.Number);  
		  
		  in.close();  
		 }  
		}  