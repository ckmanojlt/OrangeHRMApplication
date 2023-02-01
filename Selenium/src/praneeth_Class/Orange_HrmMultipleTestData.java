package praneeth_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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

public class Orange_HrmMultipleTestData {
	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver;
		String ApplicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";

//Launching Browser	
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");

		driver = new ChromeDriver();

//Navigating to OrangeHRM Application
		driver.get(ApplicationUrlAddress);

		FileInputStream file = new FileInputStream("./src/praneeth_Class/OHRM_MDT.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("sheet1");

		int row_count = sheet.getLastRowNum();
		for (int rowindex = 1; rowindex <= row_count; rowindex++) {

			Row row = sheet.getRow(rowindex);
			Cell UsernameCell = row.getCell(0);
			String username_data = UsernameCell.getStringCellValue();

			Cell Passwordcell = row.getCell(1);
			String Password_data = Passwordcell.getStringCellValue();

			// Login with valid test data
			driver.findElement(By.id("txtUsername")).sendKeys(username_data);
			driver.findElement(By.name("txtPassword")).sendKeys(Password_data);
			driver.findElement(By.id("btnLogin")).click();

			
		 String ExpUrl = "validateCredentials"; 
			  String ActUrl =driver.getCurrentUrl();
			  
			  if(ActUrl.contains(ExpUrl)) { 
				
			 WebElement InvalidCredentials=driver.findElement(By.id("spanMessage"));
			boolean InvalidTestText=InvalidCredentials.isDisplayed();
			if(InvalidTestText) {
				
				Cell Resultcell = row.createCell(2);
				Resultcell.setCellValue("PASS");}
			
				else {
					File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshot, new File("./Screenshot_OHRM/OHRM.Png"));
					
					Cell Resultcell = row.createCell(2);
					Resultcell.setCellValue("Fail");
					}}
				
			  else {		
			String Expected_CurrentUrl = "dashboard";
			String Actual_CurrentUrl = driver.getCurrentUrl();

			if (Actual_CurrentUrl.contains(Expected_CurrentUrl)) {

				Cell Resultcell = row.createCell(2);
				Resultcell.setCellValue("Pass");

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
			}

			else {
				
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("./Screenshot_OHRM/OHRM.Png"));
				
				//Thread.sleep(3000);
				sheet.getRow(rowindex);
				Cell Resultcell = row.createCell(2);
				Resultcell.setCellValue("Fail");

				

			}

			FileOutputStream file1 = new FileOutputStream("./src/praneeth_Class/OHRM_MDT.xlsx");
			workBook.write(file1);

		}

	}
}}
