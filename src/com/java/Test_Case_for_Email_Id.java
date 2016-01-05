package com.java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_Case_for_Email_Id {

	/**		private static final Pattern emailPattern = Pattern.compile("[\\w\\.]+@[\\w\\.]+.com");
			
		public static void main(String[] args) {
		  if(args.length == 0) {
		      System.out.println("Please provide one or more strings to validate");
		      return;
		  }
		  for(String input:args) {
			if(emailPattern.matches("naveen", "sdflsdjfj")) {
				System.out.println(input + "has valid email syntax");
			} else {
				System.out.println(input + "is not a valid email address");
			}
		   }
		}**/
	
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String line = scanner.nextLine();
	Pattern pattern =  Pattern.compile("[A-Z0-9._]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
	Matcher matcher = pattern.matcher(line.toUpperCase());
	if(matcher.matches()){
		System.out.println("E-mail validated!");
	}
	else{
		System.out.println("Invalid email!!");
	}
}
}
		