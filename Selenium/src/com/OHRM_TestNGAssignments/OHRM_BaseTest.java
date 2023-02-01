package com.OHRM_TestNGAssignments;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class OHRM_BaseTest {
	
	public WebDriver driver;
	String ApplicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	public static Logger log;
	
	@BeforeTest
	public void setUp() {	
	System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(ApplicationUrlAddress);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	log=Logger.getLogger("OHRM_BaseTest");
	PropertyConfigurator.configure("Log4j.properties");
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
