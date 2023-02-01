package assignments;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Osmania_DropDownFunctionality {
public static void main(String[] args) throws IOException, InterruptedException {
	
		WebDriver driver;
		String ApplicationUrlAddress ="https://www.osmania.ac.in/";
	
//Launching Browser	
		System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe" );

		driver = new ChromeDriver();
        
//Navigating to Osmania Application
		  driver.get(ApplicationUrlAddress);
		  
		  
		  
		  By SelectLanguageElementL=By.className("notranslate");
		  WebElement SelectLanguageElement=driver.findElement(SelectLanguageElementL);
		  
		  By LanguagesListL=By.tagName("option");
		  List<WebElement>LanguagesList=SelectLanguageElement.findElements(LanguagesListL);
		  
		  int LanguagesList_count= LanguagesList.size();
		  System.out.println(LanguagesList_count);
		  
		  for(int i=0;i<LanguagesList_count;i++) {
			  
			  String NoOfLanguages=LanguagesList.get(i).getText();
			  System.out.println(NoOfLanguages);
			 			  
			  Select selection=new Select(SelectLanguageElement);
			// selection.selectByIndex(i);
			selection.selectByVisibleText(NoOfLanguages);
			  //selection.selectByValue("5");
			
			Thread.sleep(5000);
			
			File Screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Screenshot,new File("./ScreenShot/"+NoOfLanguages+".Png"));			  
		  }		  
}
}
