package radioButtons;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtons_Automate {
	WebDriver driver;
	Logger log=Logger.getLogger(getClass());
	@BeforeTest
	public void setUP() {
		PropertyConfigurator.configure("./Log4Properties/Log4j.properties");
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://echoecho.com/htmlforms10.htm");
	}
	@Test(priority=1)
	public void radioButton() {
		// <input type="radio" name="group1" value="Milk">
//		List<WebElement> radioButtons = driver.findElements(By.name("group1"));
//		int radioButtonsCount = radioButtons.size();
		List<WebElement> table = driver.findElements(By.className("table5"));
		List<WebElement> radioButtons = table.get(1).findElements(By.tagName("input"));
		int radioButtonsCount = radioButtons.size();
		System.out.println(radioButtonsCount);
		for(int index=0;index<radioButtonsCount;index++) {
			radioButtons.get(index).click();
			for(int statusIndex=0;statusIndex<radioButtonsCount;statusIndex++) {
				System.out.println(radioButtons.get(statusIndex).getAttribute("value")+" "+radioButtons.get(statusIndex).getAttribute("checked"));
				log.info(radioButtons.get(statusIndex).getAttribute("value")+" "+radioButtons.get(statusIndex).getAttribute("checked"));
			}
			System.out.println();
			
		}
		
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
	
	
}
