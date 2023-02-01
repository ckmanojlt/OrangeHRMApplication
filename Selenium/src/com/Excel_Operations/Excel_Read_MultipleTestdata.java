package com.Excel_Operations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_MultipleTestdata {

	public static void main(String[] args) throws IOException {
	FileInputStream file=new FileInputStream("C:\\Users\\USER\\Desktop\\CK\\Selenium\\src\\excel_worksheets\\multipledata.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	int rowcount=sheet.getLastRowNum();
	for(int rowindex=0;rowindex<=rowcount;rowindex++)
	{
		int cellcount=sheet.getRow(rowindex).getLastCellNum();
		for(int cellindex=0;cellindex<cellcount;cellindex++)
		{
			Row row=sheet.getRow(rowindex);
			Cell cell=row.getCell(cellindex);
			String Data=cell.getStringCellValue();
			System.out.print(Data+" ");
			
			
		}
		System.out.println();
	}
	
		
		
		
		
		
		
}
}


