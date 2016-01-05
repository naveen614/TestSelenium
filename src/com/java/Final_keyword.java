package com.java;

class Final_keyword {
	
	final int i=5;
	final int Max_Marks;//Final blank variable must be initialized in construcotr
	
	public void final_Test(int i){
		
		i=7;//Final variable can't be assigned
		
		
	}
	
	public Final_keyword(){
		Max_Marks=100;
	}
	
	
	final public void final_Test2(int a, int b){
		int sum;
		sum=a+b;
	}
	

	
	
	class Final_keyword2 extends Final_keyword{
		
		public void final_Test2(int a, int b)//Final method can't be override
		{
			
		}
		
	}
	public static void main(String[] args) {
		Final_keyword Finalkey=new Final_keyword();
		Finalkey.final_Test();
		Finalkey.final_Test2(4, 8);//Final method can be inherited
	}

}
