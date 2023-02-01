package assignments;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingHP_Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		String AppUrlAddress  = "http://bing.com";
		System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(AppUrlAddress);
		File CC=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(CC, new File("./Screenshot_OHRM/c.png"));
	}

}
