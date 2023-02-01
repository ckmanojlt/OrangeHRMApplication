package gettext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_SignIn_Text {

	public static void main(String[] args) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://google.com");
		
		WebElement SignInElement = driver.findElement(By.linkText("Sign in"));
		
		// Get the text of an Element - SignIn
		
		String SignInElement_Text = SignInElement.getText();
		
		System.out.println("the text of an element sign in is :"+SignInElement_Text);
		
		// Using the same variable SignInElement - performing another operation - click
		
		SignInElement.click();
		
		// When ever we save any identified element into a variable - using the variable we can perform multiple operations
		
		//
		driver.close();
		

	}

}
