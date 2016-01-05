package com.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


import java.util.LinkedHashSet;
import java.util.Set;



public class Set_Exaple {
	
	public static void main(String[] args) {
		
	Set s=new HashSet();//No order, no duplication

s.add("naveen");
s.add(null);
s.add("naveen");
s.add("15");

System.out.println(s);


Set ls=new LinkedHashSet();//maintains the order, no duplication

ls.add("praveen");
ls.add(null);
ls.add("praveen");
ls.add("25");

System.out.println(ls);


}
	

 	
}

	

