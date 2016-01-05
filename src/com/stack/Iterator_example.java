package com.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Iterator_example {

	public static void main(String[] args) {
		ArrayList l = new ArrayList();

		l.add("C");
		l.add("B");
		l.add("C");
		l.add("D");
		l.add("E");

		System.out.println(l);//printing values of a list
		
		 int freq = Collections.frequency(l, "C");
		 System.out.println(freq);
		

	}

}
