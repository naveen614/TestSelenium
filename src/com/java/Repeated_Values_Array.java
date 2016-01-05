package com.java;

public class Repeated_Values_Array {
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
int J = 1 ;//initialize
int i= 0;
int Array[] = new int[]{1,2,2,3,3,3,4,5,6,7,7,8,9,9};

for( i=0; i< (Array.length-1); i++) 
{
if(Array[i] == Array[i+1]) 
   {  J = J+1;
       if( (i+1) == (Array.length-1)) // for the last-1 item if true
  {
         System.out.println(Array[i] + " is repeated" + J + " times " );
  }
       continue;
    }

    if(J>=1 ) 
       {  
        	System.out.println(Array[i] + " is repeated" + J + " times " );
         J = 1;
        }
 }
}
}
