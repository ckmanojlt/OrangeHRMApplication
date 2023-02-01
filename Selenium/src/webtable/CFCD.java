package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CFCD {
	WebDriver driver;

	public void applicationlaunch() {

		String applicationurladdress = "https://www.timeanddate.com/worldclock/";

		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationurladdress);
		driver.manage().window().maximize();
	}

	public void cfcd() {

		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]/a
		String xpathExpressonpart1 = "/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String xpathExpressionpart2 = "]/td[1]";
		By tablexpathL = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr");
		List<WebElement> webtablecitynames = driver.findElements(tablexpathL);

		int citiescount = webtablecitynames.size();
		System.out.println(citiescount);
		for (int index = 1; index <= citiescount; index++) {
			WebElement citiesnameselement = driver
					.findElement(By.xpath(xpathExpressonpart1 + index + xpathExpressionpart2));
			String citynames = citiesnameselement.getText();
			System.out.println(citynames);

		}
	}

	public void applicationclose() {
		driver.quit();
	}

	public static void main(String[] args) {
		CFCD manoj = new CFCD();
		manoj.applicationlaunch();
		manoj.cfcd();
		manoj.applicationclose();
	}

}
