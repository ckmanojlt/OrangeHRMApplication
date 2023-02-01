package com.tsrtc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Get_allLinks_tsrtc_HP {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe");
		driver= new ChromeDriver();
		String AppUrlAddress = "https://www.tsrtconline.in/oprs-web/";
driver.get(AppUrlAddress);
driver.manage().window().maximize();

By LinksLocator = By.tagName("a");

List<WebElement>TSRTC_HomePageLinks = driver.findElements(LinksLocator);

// finding the size of the ArrayList(TSRTC_HomePageLinks)
int TSRTC_HomePageLinks_count=TSRTC_HomePageLinks.size();
System.out.println("the number of links of TSRTC Home page are:"+TSRTC_HomePageLinks_count);

for(int i=0;i<TSRTC_HomePageLinks.size();i++)
{
	String TSRTC_HomePageLinkName = TSRTC_HomePageLinks.get(i).getText();
	System.out.println(i+" "+TSRTC_HomePageLinkName);
}
driver.quit();
}
	}


