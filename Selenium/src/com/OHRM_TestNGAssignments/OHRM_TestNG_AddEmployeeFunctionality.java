package com.OHRM_TestNGAssignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OHRM_TestNG_AddEmployeeFunctionality extends OHRM_BaseTest {
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
	public void HomePageValidation() {
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
				  
			//Identify the AddEmployee Element
				  By AddEmployeeL=By.linkText(prop.getProperty("AddEmployeeProperty"));
				 WebElement AddEmployee=driver.findElement(AddEmployeeL);
				 AddEmployee.click();
	}

@Test(priority=3)
public void AddEmployeePage() throws IOException {

	  file=new FileInputStream("./src/excel_worksheets/OHRM_ADDEMPLOYEE MTD.xlsx");
	 workbook=new XSSFWorkbook(file);
	  sheet=workbook.getSheet("sheet1");
	 int TotalRows_count=sheet.getLastRowNum();
	 
//For Loop for Executing multiple Test Data	 
  for(int i=1;i<=TotalRows_count;i++) {
		 Row row=sheet.getRow(i);
	 
	 Cell firstNameCell=row.getCell(0);
	 String firstName=firstNameCell.getStringCellValue();
	 
	 Cell middleNameCell=row.getCell(1);
	 String middleName=middleNameCell.getStringCellValue();
	 
	 Cell lastNameCell=row.getCell(2);
	 String lastName=lastNameCell.getStringCellValue();
	 
	 
//Giving First,Middle,Last Name inputs		 
By firstNameL=By.name(prop.getProperty("Exp_FirstNameProperty"));
WebElement	FirstName=driver.findElement(firstNameL);
FirstName.sendKeys(firstName);
	 
By middleNameL=By.name(prop.getProperty("Exp_MiddleNameProperty"));
WebElement	MiddleName=driver.findElement(middleNameL);
MiddleName.sendKeys(middleName);

By lastNameL=By.name(prop.getProperty("Exp_LastNameProperty"));
WebElement	LastName=driver.findElement(lastNameL);
LastName.sendKeys(lastName);
	 
//Expected EmployeeId
By employeeIdL=By.name(prop.getProperty("Exp_EmployeeIdProperty"));
WebElement	Expected_EmployeeIdElement=driver.findElement(employeeIdL); 
String Expected_EmployeeId=Expected_EmployeeIdElement.getAttribute("value");
System.out.println("Employee Id before Save : "+Expected_EmployeeId);

Cell Exp_EmpId= row.createCell(6);
Exp_EmpId.setCellValue(Expected_EmployeeId);

By saveL=By.id(prop.getProperty("SaveButtonProperty")); 
WebElement Save=driver.findElement(saveL);
Save.click(); 


	//Validating First Name	
	String Expected_FirstName=firstName;

	By Actual_firstNameL=By.id(prop.getProperty("Act_FirstNameProperty"));
	WebElement	Actual_FirstNameElement=driver.findElement(Actual_firstNameL);
	String Actual_FirstName=Actual_FirstNameElement.getAttribute("value");

	Cell FN_result=row.createCell(3);
	if(Actual_FirstName.equals( Expected_FirstName)) {
		FN_result.setCellValue("Pass");
	System.out.println("FirstName is Matched - Pass");
	}
	else {
		FN_result.setCellValue("Fail");
	System.out.println("FirstName is not Matched - Fail");
	}
	//----------------------------------------------------------------------------------------

	//Validating Middle Name	
	String  Expected_MiddleName=middleName;

	By Actual_middleNameL=By.id(prop.getProperty("Act_MiddleNameProperty"));
	WebElement Actual_MiddleNameElement=driver.findElement(Actual_middleNameL);
	String Actual_MiddleName=Actual_MiddleNameElement.getAttribute("value");

	Cell MN_result=row.createCell(4);
	if(Actual_MiddleName.equals( Expected_MiddleName)) {
		MN_result.setCellValue("Pass");
	System.out.println("MiddleName is Matched - Pass");
	}
	else {
		MN_result.setCellValue("Fail");
	System.out.println("MiddleName is not Matched - Fail");
	}
	//----------------------------------------------------------------------------------------------
	//Validating Last Name	
	String  Expected_LastName=lastName;

	By Actual_lastNameL=By.id(prop.getProperty("Act_LastNameProperty"));
	WebElement Actual_LastNameElement=driver.findElement(Actual_lastNameL);
	String Actual_LastName=Actual_LastNameElement.getAttribute("value");

	Cell LN_result=row.createCell(5);
	if(Actual_LastName.equals( Expected_LastName)) {
		LN_result.setCellValue("Pass");
	System.out.println("LastName is Matched - Pass");
	}
	else {
		LN_result.setCellValue("Fail");
	System.out.println("LastName is not Matched - Fail");
	}
	//---------------------------------------------------------------------------------------------

	//EmployeeId Validation		
	By Actual_employeeIdL=By.id(prop.getProperty("Act_EmployeeIdProperty"));
		WebElement	Actual_EmployeeIdElement=driver.findElement(Actual_employeeIdL); 
		String Actual_EmployeeId=Actual_EmployeeIdElement.getAttribute("value");
	 System.out.println("Employee Id after Save : "+Actual_EmployeeId);
	 
	Cell Act_EmpId= row.createCell(7);
	Act_EmpId.setCellValue(Actual_EmployeeId);

	Cell EmpId_Result=row.createCell(8);
		if(Actual_EmployeeId.equals(Expected_EmployeeId))
		{
			EmpId_Result.setCellValue("Pass");
			System.out.println("Employee Id is Matched - Pass");
		}
		else {
			EmpId_Result.setCellValue("Fail");
			System.out.println("Employee Id is not Matched - Fail");
		}


	//Identify the AddEmployee Element
		  By addEmployeeL=By.linkText(prop.getProperty("AddEmployeeProperty"));
		 WebElement addEmployee=driver.findElement(addEmployeeL);
		 addEmployee.click();
		}

    fileOutputStream=new FileOutputStream("./src/excel_worksheets/OHRM_ADDEMPLOYEE MTD.xlsx");
workbook.write(fileOutputStream);



}}