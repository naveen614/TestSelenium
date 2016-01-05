package com.test.plan;



public class Split_only_numbers {

	public static void main(String[] args) {
		String s="sdfsdf4411afsdf4111afsdf444";
		
		String sarr[]=s.split("\\d");//prints only alphabets
		String numbers[]=s.split("\\D");
		for(String var:sarr)
		     System.out.println(var);
			     System.out.print(sarr.length);
			     
			     for(String nums: numbers)
			 		System.out.print(nums);
			     
			     
	}
	
	
	
	
	
}
