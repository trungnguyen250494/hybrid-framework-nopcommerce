package javaBasic;

import org.testng.Assert;

public class Topic_04_Operator {
	
	public static void main(String[] args) 
	{
		int number = 10;
		number += 5;
		System.out.println(number);
		System.out.println(number / 5);
		System.out.println(number % 7);
		System.out.println(number++);
		System.out.println(++number);
		
		for (int i = 0; i < 3; ++i) {
			System.out.println(i);
		}
		
		Assert.assertTrue(false);
		
		
	}

}
