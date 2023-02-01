package com.apsrtc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class APSRTC_HeaderBlock_Texts {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.edge.driver","./driverfiles/msedgedriver.exe ");
		driver = new EdgeDriver();
		String AppUrlAddress = "https://www.apsrtconline.in/oprs-web/";
		driver.get(AppUrlAddress);
		driver.manage().window().maximize();
		
	 By HeaderBlockLocator = By.className("menu");
	 WebElement  HeaderBlock  = driver.findElement(HeaderBlockLocator);
	 List   <WebElement> HeaderLinks   = HeaderBlock.findElements(By.tagName("a"));
		 
	 int HeaderLinks_Length =HeaderLinks.size();
		 
	 System.out.println(HeaderLinks_Length);
	//String	abc =HeaderLinks.get(0).getText();
	//System.out.println(abc);
		 
	for(int i=0;i<HeaderLinks_Length;i++)
	{
	String HeaderLinks_Text=HeaderLinks.get(i).getText();
	System.out.println(HeaderLinks_Text);
	
		
	}
		 
	}}
	


