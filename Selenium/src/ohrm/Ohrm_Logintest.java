package ohrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ohrm_Logintest {

	public static void main(String[] args) {
		
WebDriver driver;
String ApplicationUrlAddress ="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe" );

  driver = new ChromeDriver();
  driver.get(ApplicationUrlAddress);
  
  // Validating web page
  
 
/*
  <input name="txtUsername" id="txtUsername" type="text">
  
locator = id
selector= txtUsername	  
		  
attribute = id

value = txtUsername
*/

  // Identifiacation of Recognization of an element - Username
  // on the identified element - perform the operation
  
  driver.findElement(By.id("txtUsername")).sendKeys("ck@346");
  
  
  
 // <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
  
  // locator = name
  // selector = txtPassword
  
  driver.findElement(By.name("txtPassword")).sendKeys("Manojreddy@346");
  
  // <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
  
 // locator = class
 //selector = button
  
  driver.findElement(By.className("button")).click();

	
}
}
