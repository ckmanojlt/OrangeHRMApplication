package assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_Manoj {

	
	public static void main(String[] args) {
		String ApplicationUrlAddress = "https://www.tsrtconline.in/oprs-web/";
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ApplicationUrlAddress);
		
		
		List<String>Expected_Tsrtc_HrefAttributes=new ArrayList<String>();
		List<String>Actual_Tsrtc_CurrentUrls=new ArrayList<String>();
		
		By headerblockL=By.className("menu-wrap");
		WebElement HeaderBlock=driver.findElement(headerblockL);
		
		By headerBlocklinksL=By.tagName("a");
		List<WebElement>HeaderBlockLinks=HeaderBlock.findElements(headerBlocklinksL);
		
		int HeaderBlockLinks_count=HeaderBlockLinks.size();
		System.out.println(HeaderBlockLinks_count);
		
		for(int index=0;index<HeaderBlockLinks_count;index++) {
			
			String HeaderBlockLinks_Text=HeaderBlockLinks.get(index).getText();
			System.out.println(HeaderBlockLinks_Text);
			
			//HeaderBlockLinks.get(index).click();
		
			Expected_Tsrtc_HrefAttributes.add(HeaderBlockLinks.get(index).getAttribute("href"));
			HeaderBlockLinks.get(index).click();
			Actual_Tsrtc_CurrentUrls.add(driver.getCurrentUrl());
			
			if(Actual_Tsrtc_CurrentUrls.get(index).equals(Expected_Tsrtc_HrefAttributes.get(index)))
				System.out.println("TSRTC Menu block "+HeaderBlockLinks_Text+" Link is matched - PASS");
				else
					System.out.println("TSRTC Menu block "+HeaderBlockLinks_Text+" Link is not matched - Fail ");
				
				driver.navigate().back();
				
				
				
				headerblockL=By.className("menu-wrap");
				HeaderBlock=driver.findElement(headerblockL);
				
				headerBlocklinksL=By.tagName("a");
				HeaderBlockLinks=HeaderBlock.findElements(headerBlocklinksL);
				
			}
			
			driver.close();
		}
		
	}
/*
8

Home
TSRTC Menu block Home Link is matched - PASS

Bus on Contract
TSRTC Menu block Bus on Contract Link is matched - PASS

Enquiry
TSRTC Menu block Enquiry Link is matched - PASS

Cancel Tickets
TSRTC Menu block Cancel Tickets Link is matched - PASS

Cancelled Services
TSRTC Menu block Cancelled Services Link is matched - PASS

About Us
TSRTC Menu block About Us Link is matched - PASS

Tourism
TSRTC Menu block Tourism Link is matched - PASS

Driver Info
TSRTC Menu block Driver Info Link is matched - PASS

*/

