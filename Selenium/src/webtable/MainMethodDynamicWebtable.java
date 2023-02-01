package webtable;

import java.io.IOException;

public class MainMethodDynamicWebtable extends DynamicWebTable {

	public static void main(String[] args) throws IOException {
		DynamicWebTable obj=new DynamicWebTable();
		
		obj.setUp();
		obj.DynamicWebTableData();
		obj.tearDown();
	}
}

