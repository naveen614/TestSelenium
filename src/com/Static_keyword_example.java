package com;

public class Static_keyword_example {
	int rollnum;
	int marks;
	static String college="Sai Sudhir";
	static String university="OU";
	static{System.out.println("static block is invoked");} //static block invokes before main
	Static_keyword_example(int r, int m){
		rollnum=r;
		marks=m; }
	
	public static void staticMethod(){
	university="JNTU"; //static method can access the static data member and change its value
				}
	void display(){System.out.println(rollnum+ " " +marks+ " "+college+ "  " +university);}
	public static void main(String[] args) {
		Static_keyword_example.staticMethod();//static method can call with class
		Static_keyword_example s=new Static_keyword_example(12, 8);
		s.display();
		s.staticMethod();
	}}


