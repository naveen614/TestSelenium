package com.wrapper;

public class EnumExample
{

	public enum Seasons {

	Winter,
	spring,
	summer,
	fall


}


public static void main(String[] args) {
	
	
for(Seasons s: Seasons.values()){
	System.out.println(s);
}
	
}
}