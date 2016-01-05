package com.test.plan;

public class Twodimensional_array {

	
	public static void main(String[] args) {
		
		int twodim[][]={{10,45,54,77,77}, {10,45,54,77,77, 31,600,888},{1,5,4,7,77},{0,4445,44, 8,79, 100}};
		
		int rows=twodim.length;
		
		System.out.println("rows:" +rows);
		
		
		//int [] array=new int[twodim.length];
		
		
		for(int i=0; i<rows; i++){
			
			int columns=twodim[i].length;
			
			System.out.println("Number of columns : "  +columns);
			
		
			
					
					
			
			
			for(int j=0; j<columns; j++){
				
				System.out.println(twodim[i][j]);
				
			}
		}
		
		
	}
	
	
}
