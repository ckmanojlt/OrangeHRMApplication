package chandrika_java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.DeferredFileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMScreenshots {




	public static void main(String[] args) throws IOException, InterruptedException  {
		WebDriver driver;
		String ApplicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";

//Launching Browser	
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");

		driver = new ChromeDriver();

//Navigating to OrangeHRM Application
		driver.get(ApplicationUrlAddress);
		
		FileInputStream file=new FileInputStream("./src/praneeth_Class/OHRM_MultipleData.xlsx");
		XSSFWorkbook workBook=new XSSFWorkbook(file);
		XSSFSheet sheet=workBook.getSheet("Sheet1");
		
		int rowcount=sheet.getLastRowNum();
		for(int rowindex=1;rowindex<=rowcount;rowindex++)
		{
			Row row=sheet.getRow(rowindex);
			
			Cell UserName=row.getCell(0);
			String UserNameData=UserName.getStringCellValue();
			
			Cell Password=row.getCell(1);
			String PasswordData=Password.getStringCellValue();
			
			// Login with valid test data	
			driver.findElement(By.id("txtUsername")).sendKeys(UserNameData);	
			driver.findElement(By.name("txtPassword")).sendKeys(PasswordData);
			driver.findElement(By.className("button")).click();
			
            String Expected_OrangeHRMaHomePageUrlAddress="dashboard";
            String Actual_OrangeHRMaHomePageUrlAddress=driver.getCurrentUrl();
            if(Actual_OrangeHRMaHomePageUrlAddress.contains(Expected_OrangeHRMaHomePageUrlAddress))
            {
            	System.out.println("OrangeHRM HomePage UrlAddress is Matched-Pass");
            	
            	Cell resultcell=row.createCell(3);
            	resultcell.setCellValue("OrangeHRM HomePage UrlAddress is Matched-Pass");
            	// Pausing the Execution for 5 seconds
        		Thread.sleep(5000);
            	// Automate Welcome Admin
        		By WelcomeAdminLocator = By.linkText("Welcome Admin");
        		WebElement WelcomeAdmin = driver.findElement(WelcomeAdminLocator);
        		WelcomeAdmin.click();

        		// Pausing the Execution for 5 seconds
        		Thread.sleep(5000);

        		// Automate Logout
        		By LogoutLocator = By.linkText("Logout");
        		WebElement Logout = driver.findElement(LogoutLocator);
        		Logout.click();
        		
            }else {
            
            	Cell Resultcell = row.createCell(3);
				Resultcell.setCellValue("Fail");

				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("./Screenshot_OHRM/" + rowindex + " OHRM.Png"));
				
				
				

			}
			FileOutputStream file1 = new FileOutputStream("./src/praneeth_Class/OHRM_MultipleData.xlsx");
			workBook.write(file1);
		
		}
	}
}
			
			
			
			
	
	
	


