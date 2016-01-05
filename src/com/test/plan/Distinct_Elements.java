package com.test.plan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class Distinct_Elements {
	
	 
	
		     
	    public static void main(String a[]){
	         
  String s = "25447";//sample string
	            String temp2="";//string with no duplicates
	            HashMap<Integer,Character> tc = new HashMap<Integer,Character>();//create a hashmap to store the char's
	            char [] charArray = s.toCharArray();
	            for (Character c : charArray)//for each char
	            {
	                if (!tc.containsValue(c))//if the char is not already in the hashmap
	                    {
	                        temp2=temp2+c.toString();//add the char to the output string
	                        tc.put(c.hashCode(),c);//and add the char to the hashmap
	                    }
	            }

	            System.out.println(temp2);//final string  
	    	
	    	
	    
	    	
	    	
	    
	    	/**
	    	
	    	String s="Naveen";
	    	   StringBuilder sb = new StringBuilder();
	    	    Set<Character> seen = new HashSet<Character>();

	    	    for(int i = 0; i < s.length(); ++i) {
	    	        char c = s.charAt(i);
	    	        if(!seen.contains(c)) {
	    	            seen.add(c);
	    	            sb.append(c);
	    	            
	    	        
	    	        System.out.println(c);
	    	        }
	    	**/
	    	
	    /*	int i,j;
	    	StringBuffer str=new StringBuffer();
	    	Scanner in = new Scanner(System.in);
	    	System.out.print("Enter string: ");
	    	str.append(in.nextLine());

	    	for (i=0;i<str.length()-1;i++){
	    	    for (j=i+1;j<str.length();j++){
	    	        if (str.charAt(i)!=str.charAt(j))
	    	            System.out.println(str);
	    	        else{
	    	        	str.deleteCharAt(i);
	    	        	
	    	        }
	    	        
	    	        
	    	    }
	    	}
*/	    	
	    	
	    
	    	   
	    	    }
	    	   
	    	    
	    	    
	    	}

	    
	    

	