package chandrika_java;

public class Strings {
	public static void main(String[] args) {
		//char ch=0;
		String name="Chandrika@*123";
		for(int i=0;i<=name.length()-1;i++) {
			char ch=name.charAt(i);

		if(ch>='A' && ch<='Z' || ch>='a'&& ch<='z'){
		
		}
			else if(ch>='0'&&ch<='9') {
			
			}
			else
			{
				System.out.println(ch);
			}
			
		}
	}
}
		

