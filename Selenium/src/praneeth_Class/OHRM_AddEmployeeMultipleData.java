package praneeth_Class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OHRM_AddEmployeeMultipleData {
public static void main(String[] args) throws IOException {
	
	WebDriver driver;
	String ApplicationUrlAddress ="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";

//Launching Browser	
	System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe" );

	driver = new ChromeDriver();
    
//Navigating to OrangeHRM Application
	  driver.get(ApplicationUrlAddress);
	  
//Login with valid test data
	  driver.findElement(By.id("txtUsername")).sendKeys("CK@346"); 
	  driver.findElement(By.name("txtPassword")).sendKeys("Manojreddy@346");
	  driver.findElement(By.id("btnLogin")).click();
	    
	  
//Identify the Pim Element
	  By PimL=By.id("menu_pim_viewPimModule");
	 WebElement PIM=driver.findElement(PimL);
	String PimText= PIM.getText();
	 System.out.println("Pim element Text : "+PimText); 
	 
//MouseHover Operation using Actions class
	  Actions action=new Actions(driver);
	  action.moveToElement(PIM).build().perform();
	  
//Identify the AddEmployee Element
	  By AddEmployeeL=By.linkText("Add Employee");
	 WebElement AddEmployee=driver.findElement(AddEmployeeL);
	 AddEmployee.click();
//------------------------------------------------------------------------------------------------
	 //Add Employee Functionality with Multiple Test Data
	 
	 FileInputStream file=new FileInputStream("./src/excel_worksheets/OHRM_ADDEMPLOYEE MTD.xlsx");
	 XSSFWorkbook workbook=new XSSFWorkbook(file);
	 XSSFSheet sheet=workbook.getSheet("sheet1");
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
By firstNameL=By.name("firstName");
WebElement	FirstName=driver.findElement(firstNameL);
FirstName.sendKeys(firstName);
	 
By middleNameL=By.name("middleName");
WebElement	MiddleName=driver.findElement(middleNameL);
MiddleName.sendKeys(middleName);

By lastNameL=By.name("lastName");
WebElement	LastName=driver.findElement(lastNameL);
LastName.sendKeys(lastName);
	 
//Expected EmployeeId
By employeeIdL=By.name("employeeId");
WebElement	Expected_EmployeeIdElement=driver.findElement(employeeIdL); 
String Expected_EmployeeId=Expected_EmployeeIdElement.getAttribute("value");
System.out.println("Employee Id before Save : "+Expected_EmployeeId);

Cell Exp_EmpId= row.createCell(6);
Exp_EmpId.setCellValue(Expected_EmployeeId);

By saveL=By.id("btnSave"); 
WebElement Save=driver.findElement(saveL);
Save.click(); 

//-----------------------------------------------------------------------------------------
//Validating First Name	
String Expected_FirstName=firstName;

By Actual_firstNameL=By.id("personal_txtEmpFirstName");
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

By Actual_middleNameL=By.id("personal_txtEmpMiddleName");
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

By Actual_lastNameL=By.id("personal_txtEmpLastName");
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
By Actual_employeeIdL=By.id("personal_txtEmployeeId");
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
	  By addEmployeeL=By.id("menu_pim_addEmployee");
	 WebElement addEmployee=driver.findElement(addEmployeeL);
	 addEmployee.click();
	
	
	 }	
	 
	 FileOutputStream file1=new FileOutputStream("./src/excel_worksheets/ReadOperation.xlsx");
	 workbook.write(file1);
	 


}
}