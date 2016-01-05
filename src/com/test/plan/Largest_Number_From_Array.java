package com.test.plan;

public class Largest_Number_From_Array {

public static void main(String[] args) {
	
	int numbers[]={12,7,74,78,54,99};
	
	int Largest=numbers[0];
	int smallest=numbers[0];
	
	for(int i=1; i<numbers.length; i++){
		
		if(numbers[i]>Largest){
			Largest=numbers[i];
		}
		
		else if(numbers[i]<smallest){
			smallest=numbers[i];
		}
			
	}
	
	System.out.println(Largest);
	System.out.println(smallest);
	
	
	
	
	
	
}
	
	
}
