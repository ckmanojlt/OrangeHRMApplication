package arrays;

public class Singlediemensionarrayexample {

	public static void main(String[] args) {
		
		// syntax:- single Dimensional array
		// dataType arrayName[] = new dataType[size]
		
		int array1[] = new int[4];
		
		array1[0] = 10;
		array1[1] = 20;
		array1[2] = 30;
		array1[3] = 40;
		
	/*	System.out.println(array1[0]);
		 System.out.println(array1[1]);
		 System.out.println(array1[2]);
		 System.out.println(array1[3]);
		 
	*/
		
	//for(int index=0;index<=3;index++) {
	//	System.out.println(array1[index]);
	
		
		for(int index=0;index<array1.length;index++)
		{
			System.out.println(index+" "+array1[index]);
		}}}
	


