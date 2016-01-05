package com.stack;

import java.util.*;

public class Main
{
	public static boolean operand(String s)
	{
		if(s.charAt(0) == '*' || s.charAt(0) == '/' || s.charAt(0) == '$' ||
				s.charAt(0) == '%' || s.charAt(0) == '+' || s.charAt(0) == '-')
		{
			return false;
		}
		return true;
	}

	public static String preToIn(String s)
	{
		ArrayStack stack = new ArrayStack(20);
		String a, b, test;
		for(int i = 0;i!= s.length();i++)
		{
			test= "" + s.charAt(i);
			if(!operand(test))
			{
				stack.push(test);
			}
			else
			{
				if(operand(stack.top()))
				{
					a = stack.pop();
					b = stack.pop();
					test = "(" + a + b + test + ")";
				}
				stack.push(test);
			 }
		 }
		return stack.pop();
	}

	public static String preToPost(String s)
	{
		ArrayStack stack = new ArrayStack(20);
		String a, b, test;
		for(int i = 0;i<s.length();i++)
		{
			test= "" + s.charAt(i);
			if(!operand(test))
			{
				stack.push(test);
			}
			else
			{
				if(operand(stack.top()))
				{
					a = stack.pop();
					b = stack.pop();
					test = a + test + b;
				}
				stack.push(test);
			 }
		 }
		return stack.pop();
	}

	public static String postToPre(String s)
	{
		ArrayStack stack = new ArrayStack(20);
		String a, b, test;
		for(int i = 0; i != s.length(); i++)
		{
			test = "" + s.charAt(i);
			if(operand(test))
				stack.push(test);
			else
			{
				a = stack.pop();
				b = stack.pop();
				stack.push(test + b + a);
			}
		}
		return stack.pop();
	}

	public static String postToIn(String s)
	{
		ArrayStack stack = new ArrayStack(20);
		String a, b, test;
		for(int i = 0; i <s.length(); i++)
		{
			test = "" + s.charAt(i);
			if(operand(test))
				stack.push(test);
			else
			{
				a = stack.pop();
				b = stack.pop();
				stack.push("(" + b + test + a + ")");
			}
		}
		return stack.pop();
	}

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		ArrayStack stack = new ArrayStack(20);
		int count = 0;
		String test, garbage;
		while(count != 5)
		{
			System.out.print("Please enter your exp<b></b>ression : ");
			test = kb.nextLine();
			System.out.println("Prefix to Infix 1)");
			System.out.println("Prefix to postfix 2)");
			System.out.println("Postfix to Prefix 3)");
			System.out.println("Postfix to Infix 4)");
			System.out.println("Exit 5)\n");
			System.out.print("Please enter your selection : ");
			garbage = kb.nextLine();
			count = kb.nextInt();

			switch(count)
			{
				case 1: System.out.print("\nInfix : ");
				System.out.println(preToIn(test));
				break;
				case 2: System.out.print("\nPostfix : ");
				System.out.println(preToPost(test));
				break;
				case 3: System.out.print("\nPrefix : ");
				System.out.println(postToPre(test));
				break;
				case 4: System.out.print("\nInfix : ");
				System.out.println(postToIn(test));
				break;
				case 5: break;
			}
		}
	}
}
