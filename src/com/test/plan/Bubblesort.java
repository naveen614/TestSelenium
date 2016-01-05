package com.test.plan;

import org.apache.tools.ant.taskdefs.Length;

public class Bubblesort {
	
	
	public int [] bubbleSort(int[] list){
		int i,j,temp;
		
		
		for(i=0; i<list.length-1; i++){
			
			for(j=0; j<list.length-1-i; j++){
			
				if(list[j]>list[j+1]){
					
					temp=list[j];
					list[j]=list[j+1];
					
					list[j+1]=temp;
					
							
					
				}
				
				
		}
		
			
		}
		
		
		return list;
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		int [] list={1, 9, 1000, 999, 1, 78,7};
		
		
		Bubblesort bsort=new Bubblesort();
int b[]=bsort.bubbleSort(list);


for(int i=0; i<list.length-1; i++){
	System.out.println(b[i]);
}
		
		
		
		
		
		
	}
		
	}


