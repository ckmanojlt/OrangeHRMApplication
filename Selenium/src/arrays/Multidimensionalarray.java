package arrays;

public class Multidimensionalarray {

	public static void main(String[] args) {
		// syntax
		// dataType arrayName[][] = new dataType[size][size]
		
		String array1[][] = new String[2][2];
		
		array1[0][0] = "Venkat Sir";
		array1[0][1] = "Manual Testing";
		array1[1][0] = "Srini";
		array1[1][1] = "Automation";
		
		for(int rowindex=0;rowindex<=1;rowindex++) // to go every row
		{
			// to go to every row of all the columns
			
			for(int rowofcolumnindex=0;rowofcolumnindex<=1;rowofcolumnindex++)
			{
				System.out.print(array1[rowindex][rowofcolumnindex]+ ' ');
			}
			System.out.println();
			}
		
		}

	}


