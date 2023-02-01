package autoIT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UploadingPhoto {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		String ApplicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";

		// Launching Browser
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");

		driver = new ChromeDriver();

		// Navigating to OrangeHRM Application
		driver.get(ApplicationUrlAddress);

		// Login with valid test data
		driver.findElement(By.id("txtUsername")).sendKeys("CK@346");
		driver.findElement(By.name("txtPassword")).sendKeys("Manojreddy@346");
		driver.findElement(By.id("btnLogin")).click();

		// Identify the Pim Element
		By PimL = By.id("menu_pim_viewPimModule");
		WebElement PIM = driver.findElement(PimL);
		String PimText = PIM.getText();
		System.out.println("Pim element Text : " + PimText);

		// MouseHover Operation using Actions class
		Actions action = new Actions(driver);
		action.moveToElement(PIM).build().perform();

		// Identify the AddEmployee Element
		By AddEmployeeL = By.linkText("Add Employee");
		WebElement AddEmployee = driver.findElement(AddEmployeeL);
		AddEmployee.click();

		// Giving First,Middle,Last Name inputs
		By firstNameL = By.name("firstName");
		WebElement FirstName = driver.findElement(firstNameL);
		FirstName.sendKeys("Manoj");

		By middleNameL = By.name("middleName");
		WebElement MiddleName = driver.findElement(middleNameL);
		MiddleName.sendKeys("Reddy");

		By lastNameL = By.name("lastName");
		WebElement LastName = driver.findElement(lastNameL);
		LastName.sendKeys("Ck");

		By employeeIdL = By.name("employeeId");
		WebElement Expected_EmployeeIdElement = driver.findElement(employeeIdL);
		String Expected_EmployeeId = Expected_EmployeeIdElement.getAttribute("value");
		System.out.println("Employee Id before Save : " + Expected_EmployeeId);

		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);

		Runtime.getRuntime().exec("C:\\Users\\USER\\Desktop\\CK\\Selenium\\UploadingPhoto\\Photo.exe");

		Thread.sleep(2000);
		  By saveL=By.id("btnSave"); WebElement Save=driver.findElement(saveL);
		  Save.click();
		 
WebElement photoElement=driver.findElement(By.id("empPic"));
		  boolean photo=photoElement.isDisplayed();
		  if(photo) {
			  System.out.println("Photo is displayed - pass");
		  }
		  else {
			  System.out.println("Photo is not displayed - fail");
		  }
	}
}
