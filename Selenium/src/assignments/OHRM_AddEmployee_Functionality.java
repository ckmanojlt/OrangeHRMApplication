package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OHRM_AddEmployee_Functionality {

	public static void main(String[] args) {
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
		 
//Giving First,Middle,Last Name inputs		 
    By firstNameL=By.name("firstName");
	WebElement	FirstName=driver.findElement(firstNameL);
	FirstName.sendKeys("Manoj");
		 
	By middleNameL=By.name("middleName");
	WebElement	MiddleName=driver.findElement(middleNameL);
	MiddleName.sendKeys("Reddy");
	
	By lastNameL=By.name("lastName");
	WebElement	LastName=driver.findElement(lastNameL);
	LastName.sendKeys("Ck");
		 
	By employeeIdL=By.name("employeeId");
	WebElement	Expected_EmployeeIdElement=driver.findElement(employeeIdL); 
	String Expected_EmployeeId=Expected_EmployeeIdElement.getAttribute("value");
    System.out.println("Employee Id before Save : "+Expected_EmployeeId);
		 
		By saveL=By.id("btnSave"); 
		WebElement Save=driver.findElement(saveL);
		Save.click();
		
//Validating First Name	
		    String Expected_FirstName="Manoj";
		
	    	By Actual_firstNameL=By.id("personal_txtEmpFirstName");
			WebElement	Actual_FirstNameElement=driver.findElement(Actual_firstNameL);
			String Actual_FirstName=Actual_FirstNameElement.getAttribute("value");
		
		if(Actual_FirstName.equals( Expected_FirstName))
			System.out.println("FirstName is Matched - Pass");
		else
			System.out.println("FirstName is not Matched - Fail");
		
//Validating Middle Name	
	    String  Expected_MiddleName="Reddy";
	
    	By Actual_middleNameL=By.id("personal_txtEmpMiddleName");
		WebElement Actual_MiddleNameElement=driver.findElement(Actual_middleNameL);
		String Actual_MiddleName=Actual_MiddleNameElement.getAttribute("value");
	
	   if(Actual_MiddleName.equals( Expected_MiddleName))
		System.out.println("MiddleName is Matched - Pass");
	   else
		System.out.println("MiddleName is not Matched - Fail");
	   
//Validating Last Name	
	    String  Expected_LastName="Ck";
	
    	By Actual_lastNameL=By.id("personal_txtEmpLastName");
		WebElement Actual_LastNameElement=driver.findElement(Actual_lastNameL);
		String Actual_LastName=Actual_LastNameElement.getAttribute("value");
	
	   if(Actual_LastName.equals( Expected_LastName))
		System.out.println("LastName is Matched - Pass");
	   else
		System.out.println("LastName is not Matched - Fail");
	   
//EmployeeId Validation		
	   By Actual_employeeIdL=By.id("personal_txtEmployeeId");
		WebElement	Actual_EmployeeIdElement=driver.findElement(Actual_employeeIdL); 
		String Actual_EmployeeId=Actual_EmployeeIdElement.getAttribute("value");
	    System.out.println("Employee Id after Save : "+Actual_EmployeeId);
		
		if(Actual_EmployeeId.equals(Expected_EmployeeId))
			System.out.println("Employee Id is Matched - Pass");
		else
			System.out.println("Employee Id is not Matched - Fail");
		
	}

	
}

/* OutPut 

Pim element Text : PIM
Employee Id before Save : 0008
FirstName is Matched - Pass
MiddleName is Matched - Pass
LastName is Matched - Pass
Employee Id after Save : 0008
Employee Id is Matched - Pass

*/



