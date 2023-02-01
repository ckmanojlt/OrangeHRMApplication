package chandrika_java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingScreenshot {

	public static void main(String[] args) throws IOException {
	WebDriver driver;
	String applicationUrlAddress="http://bing.com";
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\CK\\Selenium\\driverfiles\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(applicationUrlAddress);
	File bingscrrenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile
	(bingscrrenshot,new File("C:\\Users\\USER\\Desktop\\CK\\Selenium\\Screenshot_OHRM/bing.png") );	
		
	}

}
