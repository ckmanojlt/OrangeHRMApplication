package com.Excel_Operations;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_SingleTestdata {
	public static void main(String[] args) throws IOException {
	
		FileInputStream file = new FileInputStream("./src/excel_worksheets/ReadOperation.xlsx");
		
		XSSFWorkbook Workbook=new XSSFWorkbook(file);
		XSSFSheet Sheet=Workbook.getSheet("sheet1");
		Row row=Sheet.getRow(1);
		Cell cell=row.getCell(1);
		String testdata=cell.getStringCellValue();
		System.out.println(testdata);
	}

	
	}