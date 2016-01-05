package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PatternDocumentImpl;

public class RegexMatch {
	public static void main(String[] args) {
		
		String line="ThisorderwasplacedforQT3000!OK?";
		String pattern="(\\D)";
		
		
		// Create a Pattern object
	      Pattern r = Pattern.compile(pattern);
	      
	      r.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
		
		if(m.find()){
			System.out.println(m.group(0));
			//System.out.println(m.group(1));
			//System.out.println(m.group(2));
		}
		
		else{
			System.out.println("No MATCH");
		}
		
	}

}
