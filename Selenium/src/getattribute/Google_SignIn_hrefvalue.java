package getattribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_SignIn_hrefvalue {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe");
		driver = new ChromeDriver();
		String AppUrlAddress = "https://google.com";
		driver.get(AppUrlAddress);
		
		// inspect the sign in element and identified the properties
		// sign in element properties
		
		
//<a class="gb_7 gb_8 gb_de gb_dd" href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;continue=https://www.google.com/&amp;ec=GAZAmgQ" target="_top">Sign in</a>		

	By SignInLocator = By.linkText("Sign in");	
	WebElement SignIn = driver.findElement(SignInLocator);
 String SignInAttributeValue = SignIn.getAttribute("href");
 
 //String SignInAttributeValue = SignIn.getAttribute("class");
 System.out.println("the attribute value of  sign in element is :"+SignInAttributeValue);
 
    String SignIn_Text = SignIn.getText();
    System.out.println(" the text of an element sign in is :"+SignIn_Text);
		
    SignIn.click();
    
    String SignInWebPage_Title = driver.getTitle();
    System.out.println("the title of the sign in webpage is :"+SignInWebPage_Title);
    driver.quit();
    
		
		
	}

}
