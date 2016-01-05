package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ArrayList_LinkedList_example {

	public static void main(String[] args) {
		
		List alist=new ArrayList();
		alist.add("a");
		alist.add("44");
		alist.add("55");
		alist.add("ss");
		alist.add("78");
			System.out.println(alist.get(3));
			
			
	
			
			
			List llist=new LinkedList();
			llist.add("aa");
			llist.add("784");
			llist.add("554");
			llist.add("44");
			llist.add("741");
			llist.add("444");
			llist.add("44");
			llist.add("787");
			llist.add("nsdfsf");
			
			System.out.println(alist.addAll(llist));
			System.out.println(alist);
			System.out.println(llist.get(2));
			
			Iterator it=alist.iterator();
			

ListIterator lit=alist.listIterator();
			
			while(it.hasNext()){
				
				System.out.println(it.next());
				it.remove();
			
				
				
			}
			
			while(lit.hasPrevious()){
				System.out.print(lit.previous()+"/n");
				lit.nextIndex();
				lit.previousIndex();
				lit.set(lit);
				
				
			}
			
			
			
			
	}
}
