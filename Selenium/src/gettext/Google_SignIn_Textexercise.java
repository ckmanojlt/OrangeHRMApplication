package gettext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_SignIn_Textexercise {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe");
		driver = new ChromeDriver();
		String AppUrlAddress = "https://google.com";
		driver.get(AppUrlAddress);
		
		
		// String SignInElementText = driver.findElement(By.linkText("Sign in")).getText();
		
		// System.out.println(SignInElementText); 
		
		      //OR
		
	/*	
		WebElement SignInElement = driver.findElement(By.linkText("Sign in"));
		
		String SignInElement_Text = SignInElement.getText();
		System.out.println(SignInElement_Text);
	*/
		
		    //OR
		
		// GETTING THE TEXT OF SIGNINELEMENT
		
		
		
		By SignInLocator = By.linkText("Sign in");
		
		WebElement SignIn = driver.findElement(SignInLocator);
		
		String SignIn_Text = SignIn.getText();
		
		System.out.println("the text of an element sign in is :"+SignIn_Text);
		
		
		// performing a click operation on sign in element
		
		SignIn.click();
		driver.quit();
				
	}
	

}
