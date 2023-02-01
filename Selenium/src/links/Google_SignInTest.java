package links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_SignInTest {

	public static void main(String[] args) {
		
		WebDriver driver;
		
		String applicationurladdress = "http://google.com";
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationurladdress);
		
//	<a class="gb_7 gb_8 gb_de gb_dd" href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;continue=https://www.google.com/%3Fgws_rd%3Dssl&amp;ec=GAZAmgQ" target="_top">Sign in</a>
		
// a = Anchor Tag 
// href = Attribute
// Value = https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;
// When An Element properties contains a tag and href attribute then the type of element is link	
		
// if the element is of type link than either User linkText() OR Partial link text()  
		//driver.findElement(By.linkText("Sign in")).click();
		
		//OR
		
		
	//driver.findElement(By.partialLinkText("Sign in")).click();
		
		//OR should be as follow
		
		WebElement signinelement = driver.findElement(By.linkText("Sign in"));
		
		
		String SigninText=signinelement.getText();
		System.out.println(SigninText);
		
		signinelement.click();
		
		
	}

}
