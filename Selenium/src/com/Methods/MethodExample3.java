package com.Methods;

public class MethodExample3 extends  MethodExample2{
// Global variables
	int var1=30;
	int var2=20;
	private void subtraction() 
	{
		
		int s=20;
		int t=5;
		int u=s-t;
		System.out.println("subtraction :"+u);
		
		
	}
	
public static void main(String[] args) {
	
	MethodExample3 m3=new MethodExample3();
	m3.addition2();
	m3.additionClass1();
	m3.subtraction();
	m3.subtractionClass1(50, 29);
	m3.multiplication2(3, 4);
	
	
	
	
}	
	
}
