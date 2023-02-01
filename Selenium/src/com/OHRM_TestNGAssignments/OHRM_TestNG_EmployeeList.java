package com.OHRM_TestNGAssignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OHRM_TestNG_EmployeeList extends OHRM_BaseTest{

	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row row;
	Cell cell;
	
	Properties prop;
	FileInputStream propertiesFile;
	FileOutputStream fileOutputStream;
	
	@Test(priority=1)
	public void LoginPageInputs() throws IOException { 
	//Identifiying the Properties file
	propertiesFile=new FileInputStream("./src/com/Config/OHRM.properties");
	
	prop=new Properties();
//Loading the Properties File
	prop.load(propertiesFile);
	
	By usernameL=By.id(prop.getProperty("UsernameProperty"));
	WebElement UserName=driver.findElement(usernameL);
	UserName.sendKeys(prop.getProperty("userName"));
	
	By passwordL=By.id(prop.getProperty("PasswordProperty"));
	WebElement Password=driver.findElement(passwordL);
	Password.sendKeys(prop.getProperty("password"));
	
	By loginButtonL=By.id(prop.getProperty("LoginbuttonProperty"));
	WebElement LoginButton=driver.findElement(loginButtonL);
	LoginButton.click();
}

	@Test(priority=2)
	public void HomePageValidation() throws IOException {
		//Identifiying the Properties file
		propertiesFile=new FileInputStream("./src/com/Config/OHRM.properties");
		
		prop=new Properties();
	//Loading the Properties File
		prop.load(propertiesFile);
		// Admin Text Validation
				String Expected_OHRM_HomePage_AdminText = "Admin";

				By AdminTextLocator = By.className(prop.getProperty("AdminProperty"));
				WebElement AdminText = driver.findElement(AdminTextLocator);
				String Actual_OHRM_HomePage_AdminText = AdminText.getText();
				System.out.println("Home Page Admin Text  :" + Actual_OHRM_HomePage_AdminText);

				if (Actual_OHRM_HomePage_AdminText.equals(Expected_OHRM_HomePage_AdminText))
					System.out.println(" Homepage_Admin_Text is matched - Pass");
				else
					System.out.println("Homepage_Admin_Text is not matched - Fail");
				
				//Identify the Pim Element
				  By PimL=By.id(prop.getProperty("PimElementProperty"));
				 WebElement PIM=driver.findElement(PimL);
				String PimText= PIM.getText();
				 System.out.println("Pim element Text : "+PimText); 
				 
			//MouseHover Operation using Actions class
				  Actions action=new Actions(driver);
				  action.moveToElement(PIM).build().perform();
				  
				//Identify the EmployeeList Element
				  By EmployeeListL=By.id(prop.getProperty("EmployeeListProperty"));
				 WebElement EmployeeList=driver.findElement(EmployeeListL);
				 EmployeeList.click();
	}
				 
				 @Test(priority=3)
				 public void EmployeeList() throws IOException {
						//Identifiying the Properties file
						propertiesFile=new FileInputStream("./src/com/Config/OHRM.properties");
						
						prop=new Properties();
					//Loading the Properties File
						prop.load(propertiesFile); 
						
					 file=new FileInputStream("./src/excel_worksheets/EmployeeList.xlsx");
					 workbook=new XSSFWorkbook(file);
					  sheet=workbook.getSheet("sheet1"); 
					 
					 By EmployeeListTableL=By.id(prop.getProperty("EmployeeListTableProperty"));
					 WebElement EmployeeListTable=driver.findElement(EmployeeListTableL);
					 By TablerowsL=By.tagName("tr");
					 List<WebElement>EmployeeListTableRows=EmployeeListTable.findElements(TablerowsL);
//-------------------------------------------------------------------------------------------------------					
					List<WebElement >header =EmployeeListTable.findElements(By.tagName("th"));
					Row Headerrow=sheet.createRow(0);
					for(int l=0;l<header.size();l++) {
					
					Cell Headercell=Headerrow.createCell(l);
						String headerdata=header.get(l).getText();
						System.out.print(headerdata);
						Headercell.setCellValue(headerdata);
					}
					System.out.println();
//--------------------------------------------------------------------------------------------------------				
					 
					 int Rows_count= EmployeeListTableRows.size();
		
				//	System.out.println(Rows_count);
					
					for(int i=1;i<Rows_count;i++) {
						row=sheet.createRow(i);
						By TablecellsL=By.tagName("td");
						 List<WebElement>EmployeeListTableCells=EmployeeListTableRows.get(i).findElements(TablecellsL);
						 int Cells_count=EmployeeListTableCells.size();
						//System.out.println(Cells_count);
					for(int j=0;j<Cells_count;j++) {
						cell=row.createCell(j);
						String EmployeeListdata=EmployeeListTableCells.get(j).getText();
						System.out.print(EmployeeListdata);
						cell.setCellValue(EmployeeListdata);
					}
					System.out.println();
					
					
					
					
					}
					fileOutputStream=new FileOutputStream("./src/excel_worksheets/EmployeeList.xlsx");
					workbook.write(fileOutputStream);
					
					
					 
				 }
	
	
}
