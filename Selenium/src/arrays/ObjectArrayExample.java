package arrays;

public class ObjectArrayExample {

	public static void main(String[] args) {
		
	//	Syntax:- object arrayName[] = new object[size];
		
		Object array1[] = new Object[4];
		
		array1[0] = 10;
		array1[1] = "selenium";
		array1[2] = 10.1234;
		array1[3] = 'A';
		
		for(int i=0;i<array1.length;i++)
		{
			System.out.println(i+" "+array1[i]);
		}

	}

}
