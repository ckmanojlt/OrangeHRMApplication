package com.tsrtc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Get_alllinks_HB_Text {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe");
		driver = new ChromeDriver();
		String AppUrlAddress = "https://www.tsrtconline.in/oprs-web/";
		driver.get(AppUrlAddress);
		driver.manage().window().maximize();
		// to go to the headerblock
		// identify the headerblock - class ="menu-wrap"
		By TSRTC_HeaderBlockL= By.className("menu-wrap");
		WebElement TSRTC_HeaderBlock=driver.findElement(TSRTC_HeaderBlockL);
		
	//	<a class="selectedtabcopy" href="/oprs-web/guest/home.do?h=1" target="_top" title="Home">
	//	Home</a>
		
	//	<a class="tabcopy blinking" href="/oprs-web/guest/specialHire.do" target="_top" title="Bus on Contract">Bus on Contract</a>
		
	//	<a class="tabcopy" href="/oprs-web/ticket/waitlist.do" target="_top" title="Enquiry">Enquiry</a>
		
		By linksL=By.tagName("a");
		List<WebElement>TSRTC_HeaderBlockLinks=TSRTC_HeaderBlock.findElements(linksL);
		
		int TSRTC_HeaderBlockLinks_count=TSRTC_HeaderBlockLinks.size();
		System.out.println("the number of links in the tsrtc headerblock are:"+TSRTC_HeaderBlockLinks_count);
		
		for(int index=0;index<TSRTC_HeaderBlockLinks_count;index++)
		{
			String TSRTC_HeaderBlock_LinkName =TSRTC_HeaderBlockLinks.get(index).getText();
			System.out.println(index+" "+TSRTC_HeaderBlock_LinkName);
		 
		 }
		
		
		driver.quit();
	}

}
