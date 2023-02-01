package selectclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Monster_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String AppUrlAddress= "https://my.monsterindia.com/sponsered_popup.html";
		System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(AppUrlAddress);
		
		By currentloacationL = By.className("border_grey1");
		WebElement currentloacation=driver.findElement(currentloacationL);
		Select currentloacationselect= new Select(currentloacation);
currentloacationselect.selectByVisibleText("Chennai");
//currentloacationselect.selectByIndex(4);	
//currentloacationselect.selectByValue("491");

By industryL = By.name("industry");
WebElement industry=driver.findElement(industryL);
 Select industryselect = new Select(industry);
 industryselect.selectByIndex(2);
 Thread.sleep(2000);
 industryselect.selectByVisibleText("Other");
 Thread.sleep(2000);
 industryselect.selectByValue("5");
 industryselect.deselectAll();
 
	}

}
