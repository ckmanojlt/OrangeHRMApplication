package com.Methods;

import getattribute.Methodexample;

public class MethodExample2 extends MethodsExample1 {
	//Global variables
	 int var1= 30;
	int var2=20;

	public  void addition2()
	{
		// loacal variable
		int var1=30;
		int var2=20;
		int var3;
		var3= var1+var2;
		System.out.println("the value of the variable var3 after addition is :"+var3);
	}
	
	private void subtraction2()
	{
		int var1=30;
		int var2=20;
		int var3;
		var3= var1-var2;
		System.out.println("the value of the variable var3 after addition is :"+var3);
		
	}
	 void multiplication2(int p,int q)
	{
		int r= p*q;
		System.out.println("the value of the variable var3 after addition is :"+r);	
	}
	
	
	 
	 public static void main(String[] args) {
		
		 MethodExample2 m2=new MethodExample2();
		m2.addition2();
		m2.subtraction2();
		m2.multiplication2(10,20);
		
		MethodsExample1 m1=new MethodsExample1();
		m1.additionClass1();
		m1.subtractionClass1(50,100);
		
		Methodexample m=new Methodexample();
		m.division2(20, 10);
		m.division(30, 20);
	} 
	 
	 
	 
	 
	 
	 
	 
	 

}
