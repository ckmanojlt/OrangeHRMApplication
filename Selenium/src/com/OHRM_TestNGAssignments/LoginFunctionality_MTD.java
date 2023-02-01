package com.OHRM_TestNGAssignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginFunctionality_MTD extends OHRM_BaseTest{

	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row row;
	Cell cell;
	
	Properties prop;
	FileInputStream propertiesFile;
	FileOutputStream fileOutputStream;
	
	
	@Test(priority=1)
	public void LoginPageValidation() {
		
		// LoginPage title validation
				String Expected_OHRM_LoginPageTitle = "OrangeHRM";
				String Actual_OHRM_LoginPageTitle = driver.getTitle();

				if (Actual_OHRM_LoginPageTitle.equals(Expected_OHRM_LoginPageTitle))
					System.out.println("Title is matched - Pass");
				else
					System.out.println("Title is not matched - Fail");

		// LoginPage url address validation
				String Expected_OHRM_LoginPageUrl = "orangehrm-4.2.0.1";
				String Actual_OHRM_LoginPageUrl = driver.getCurrentUrl();

				if (Actual_OHRM_LoginPageUrl.contains(Expected_OHRM_LoginPageUrl))
					System.out.println("LoginPage contains required Url  - Pass");
				else
					System.out.println("LoginPage does not contains required Url - Fail");

		// LoginPanel Text Validation
				String Expected_OHRM_LoginPanelText = "LOGIN Panel";

				// <div id="logInPanelHeading">LOGIN Panel</div>
				By LoginTextLocator = By.id("logInPanelHeading");
				WebElement LoginPanel = driver.findElement(LoginTextLocator);
				String Actual_OHRM_LoginPanelText = LoginPanel.getText();
				System.out.println("LoginPage LoginPanel Text :" + Actual_OHRM_LoginPanelText);

				if (Actual_OHRM_LoginPanelText.equals(Expected_OHRM_LoginPanelText))
					System.out.println("Text is matched - Pass");
				else
					System.out.println("Text is not matched - Fail");

	}
	
	@Test(priority=2)
	public void LoginFunctionalityTest() throws IOException, InterruptedException {
		//Excel File identificaton
		file= new FileInputStream("./src/excel_worksheets/OHRM_MultipleData.xlsx");
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet("sheet1");
		
		int row_count = sheet.getLastRowNum();
		for (int rowindex = 1; rowindex <= row_count; rowindex++) {

			Row row = sheet.getRow(rowindex);
			Cell UsernameCell = row.getCell(0);
			String username_data = UsernameCell.getStringCellValue();

			Cell Passwordcell = row.getCell(1);
			String Password_data = Passwordcell.getStringCellValue();
			
	//Identifiying the Properties file
			propertiesFile=new FileInputStream("./src/com/Config/OHRM.properties");
			
			prop=new Properties();
	//Loading the Properties File
			prop.load(propertiesFile);
			
			By usernameL=By.id(prop.getProperty("UsernameProperty"));
			WebElement UserName=driver.findElement(usernameL);
			UserName.sendKeys(username_data);
			
			By passwordL=By.id(prop.getProperty("PasswordProperty"));
			WebElement Password=driver.findElement(passwordL);
			Password.sendKeys(Password_data);
			
			By loginButtonL=By.id(prop.getProperty("LoginbuttonProperty"));
			WebElement LoginButton=driver.findElement(loginButtonL);
			LoginButton.click();
//Multiple Test Data Validation			
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

			String Expected_LoginPageUrl = "validateCredentials";
			String Actual_LoginPageUrl = driver.getCurrentUrl();

			if (Actual_LoginPageUrl.contains(Expected_LoginPageUrl)) 
			{

				Cell Resultcell = row.createCell(2);
				Resultcell.setCellValue("Fail");

				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("./Screenshot_OHRM/"  + username_data
						+ " and " + Password_data + ".Png"));
			}

			

			fileOutputStream = new FileOutputStream("./src/excel_worksheets/OHRM_MultipleData.xlsx");
			workbook.write(fileOutputStream);
			
	}
	
	
	
	}	
}
