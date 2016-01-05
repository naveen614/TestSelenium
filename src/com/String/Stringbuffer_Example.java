package com.String;

public class Stringbuffer_Example {

	public static void main(String[] args) {
		
		long starttime=System.currentTimeMillis();
		StringBuffer sb=new StringBuffer("hello");
		for(int i=0; i<=1000000; i++){
		sb.append("World");
		//System.out.println(sb);//StringBuffer is mutable and threadsafe and synchronized
		}
		
		System.out.println("Time taken by Buffer:"  +(System.currentTimeMillis() - starttime)+"ms");
		
		starttime=System.currentTimeMillis();
		StringBuilder sbuil=new StringBuilder("Naveen");
		for(int i=0; i<=1000000; i++){
			
			sbuil.append("Chary");//StringBuilder is mutable and not thread and not synchronized hence performance will be high
			
		}
		System.out.println("Time taken by Builder" +(System.currentTimeMillis() - starttime)+"ms");
		
		
	}
}
