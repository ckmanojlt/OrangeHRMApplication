package chandrika_java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_CapturingFirstcolumData {
	WebDriver driver;
	public void applicationLaunch()
	{
	String applicationUrlAddress="https://www.timeanddate.com/worldclock/";
	System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\CK\\Selenium\\driverfiles\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(applicationUrlAddress);
	driver.manage().window().maximize();
	}
	public void capturingFirstcolumData()
	{
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
	String xpathExpression_part1="/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
	String xpathExpression_part2="]/td[1]";
	By tablexpathLocator=By.xpath(" /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr");
	List<WebElement>webTableCityNames=driver.findElements(tablexpathLocator);
	int citycount=webTableCityNames.size();
	
	System.out.println(citycount);
	
	for(int index=1;index<=citycount;index++)
	{
	
		WebElement citynameElement=driver.findElement(By.xpath(xpathExpression_part1+index+xpathExpression_part2));
	String cityname=citynameElement.getText();
	System.out.println(cityname);
	
	
	}
	
	}
	public static void main(String[] args) {
		WebTable_CapturingFirstcolumData rowCellData=new WebTable_CapturingFirstcolumData();
		rowCellData.applicationLaunch();
		
		rowCellData.capturingFirstcolumData();
		rowCellData.applicationclose();

	}

	public void applicationclose()
	{
		driver.quit();
	}

}
