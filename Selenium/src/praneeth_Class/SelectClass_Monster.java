package praneeth_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass_Monster {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver;
	String ApplicationUrlAddress ="https://my.monsterindia.com/sponsered_popup.html";

//Launching Browser	
	System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe" );

	driver = new ChromeDriver();
    
//Navigating to Monster Application
	  driver.get(ApplicationUrlAddress);
	  
	  By currentLocationL=By.className("border_grey1");
	WebElement CurrentLocation= driver.findElement(currentLocationL);
	
	  
	  Select CurrentLocationselect =new Select(CurrentLocation);
	  CurrentLocationselect.selectByVisibleText("Chennai");
	  Thread.sleep(2000);
	  CurrentLocationselect.selectByVisibleText("Bengaluru / Bangalore");
	  Thread.sleep(2000);
	  CurrentLocationselect.selectByValue("6");
	  Thread.sleep(2000);
	  
	  
	 // CurrentLocationselect.deselectByIndex(4);
	  
	  By IndustryL=By.name("industry");
		WebElement Industry= driver.findElement(IndustryL);
		  
		  Select Industryselect =new Select(Industry);
		  Industryselect.selectByVisibleText("Automotive/Automobile/Ancillaries");
		  Thread.sleep(2000);
		 Industryselect.selectByIndex(1);
		  Thread.sleep(2000);
		 Industryselect.selectByValue("5");
		 Industryselect.deselectAll();
	  
	  
}
}
