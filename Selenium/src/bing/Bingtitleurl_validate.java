package bing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bingtitleurl_validate {

	public static void main(String[] args) {
		
WebDriver driver;
		
 String AppUrl="https://www.bing.com/";
 
//Browser Launch
  System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe");
   driver=new ChromeDriver();
 
   //Navigate to Bing Application
   driver.get(AppUrl);
	
  
   //Bing Title Validation
  String Expected_Bing_HomePage_Title="Bing";
  String Actual_Bing_HomePage_Title=driver.getTitle();
  
  
  if(Actual_Bing_HomePage_Title.equals(Expected_Bing_HomePage_Title)) 
	 System.out.println("Title Validation : Pass"); 
	 else
     System.out.println("Title Validation : Fail");
	  
 
  //Bing CurrentUrl Validation
   String Expected_Bing_HomePage_CurrentUrl="bing.com";
  String Actual_Bing_HomePage_CurrentUrl=driver.getCurrentUrl();
  
  if(Actual_Bing_HomePage_CurrentUrl.contains(Expected_Bing_HomePage_CurrentUrl))
   System.out.println("CurrentUrl : Pass");
  else
   System.out.println("CurrentUrl : Fail");
	}

}
