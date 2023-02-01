package arrays;

import java.util.ArrayList;
import java.util.List;

public class ArraylistExample {

	public static void main(String[] args) {
	
		// List<datatype> arraylistName = new ArrayList<>();

		List<Object> array1 = new ArrayList<>();
		array1.add("10");
		array1.add("selenium");
		array1.add('A');
		array1.add(10.123);
		array1.add("manu");
		array1.add("chinnu");
		
	/*	
		System.out.println(array1.get(0));
		System.out.println(array1.get(1));
		System.out.println(array1.get(2));
		
	*/
		for(int i=0;i<array1.size();i++)
		{
			System.out.println(array1.get(i));
		}	
	}

}
