package webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimeandDate_capturingfirstrowoffirstcellcityname {
	
	WebDriver driver;
	public void applicationlaunch() 
	{
	String applicationurladdress ="https://www.timeanddate.com/worldclock/"	;
	System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe");
	driver= new ChromeDriver();
	driver.get(applicationurladdress);
	driver.manage().window().maximize();	
	}
	public void webtable_capturingcityname()
	{
		
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
	By citynamelocator = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]");
		
	WebElement citynameElement=driver.findElement(citynamelocator);
		String cityname=citynameElement.getText();
		System.out.println(cityname);
	}
	public void applicationclose()
	{
		driver.quit();
	}

	public static void main(String[] args) {
		TimeandDate_capturingfirstrowoffirstcellcityname tad = new TimeandDate_capturingfirstrowoffirstcellcityname();
tad.applicationlaunch();
tad.webtable_capturingcityname();
tad.applicationclose();
	}

}
