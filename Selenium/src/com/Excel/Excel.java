package com.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static String getCellValue(String excelFilePath,String sheetName, int rowIndex, int cellIndex) throws IOException {
	
	  FileInputStream file = new FileInputStream(excelFilePath); 
	  XSSFWorkbook workBook = new XSSFWorkbook(file);
	  XSSFSheet sheet = workBook.getSheet(sheetName); XSSFRow row = sheet.getRow(rowIndex);
	  XSSFCell cell = row.getCell(cellIndex); return cell.getStringCellValue(); 
	}
	 
	
	public static void setCellValue(String excelFilePath,String sheetName, int rowIndex, int cellIndex, String data) throws IOException {
		FileInputStream file = new FileInputStream(excelFilePath);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowIndex);
		XSSFCell cell = row.createCell(cellIndex);
		cell.setCellValue(data);
		
		FileOutputStream saveFile = new FileOutputStream(excelFilePath);
		workBook.write(saveFile);
		saveFile.close();
	}
	
}
