package google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Google_title_url_validate {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.edge.driver","./driverfiles/msedgedriver.exe");
		
		driver = new EdgeDriver();
		
		String Appurladdress =" https://google.com";
		driver.get(Appurladdress);
		
		// google title validation
		
		String Expected_Google_Home_Page_title = "Google";
		String Actual_Google_Home_Page_title   = driver.getTitle();
		
		if(Actual_Google_Home_Page_title.equals(Expected_Google_Home_Page_title))
			System.out.println("title validation - pass");	
		else
		    System.out.println("title validation - fail");
		

		
		// Google Current Url Validation https://www.google.com/
		
		String Expected_Google_Homepage_currenturl = "https://www.google.com/";
		
		String Actual_Google_Homepage_currenturl   = driver.getCurrentUrl();
		if(Actual_Google_Homepage_currenturl.equals(Expected_Google_Homepage_currenturl))
			System.out.println("currenturl - PASS ");
		else
			System.out.println("currenturl - FAIL");
		
		
		
	}

}
