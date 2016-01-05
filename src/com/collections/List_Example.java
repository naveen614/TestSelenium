package com.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class List_Example {
	
	public static void main(String[] args) {
		
		
		
		//Array List example
	    
        
    	ArrayList al=new ArrayList();//Order preserved and duplicates allowed, Good for searching an element
    	
    	al.add("5");
    	al.add(null);
    	al.add("5");
    	al.add("Naveen");
    	
    	System.out.println(al);
    	System.out.println(al.size());
    	System.out.println(al.get(2));
    	System.out.println(al.set(1, 17));
    	System.out.println(al);
    	

    	
    	
    	//Linked List example
		
		 LinkedList lList = new LinkedList();//Order preserved and duplicates allowed, Good for insertion and removal an element
		 
	        // add elements to LinkedList
	        lList.add("1");
	        lList.add("1");
	        lList.add(null);
	        lList.add("String");
	        lList.add("5");
	 
	        /*
	         * Please note that primitive values can not be added into LinkedList
	         * directly. They must be converted to their corresponding wrapper
	         * class.
	         */
	 
	        System.out.println(lList);
	        System.out.println( lList.size());
	        System.out.println(lList.get(3));
	        System.out.println( lList.remove(2));
	        System.out.println( lList.get(3));
	        System.out.println(lList.size());
	        System.out.println(lList);
	        
	        
	    }
	
	
	
	
	
	
}
