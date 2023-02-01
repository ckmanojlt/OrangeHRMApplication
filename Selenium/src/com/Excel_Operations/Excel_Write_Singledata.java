package com.Excel_Operations;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write_Singledata {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("./src/excel_worksheets/writeoperations.xlsx");
		XSSFWorkbook WorkBook = new XSSFWorkbook(file);
		XSSFSheet sheet=WorkBook.getSheet("sheet1");
		Row row=sheet.createRow(3);
		Cell cell=row.createCell(3);
		 cell.setCellValue("chinnu");
		 FileOutputStream file1 = new FileOutputStream("./src/excel_worksheets/writeoperations.xlsx");
		 WorkBook.write(file1);
		 

	}

}
