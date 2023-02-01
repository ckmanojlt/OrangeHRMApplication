package mousehover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousehover_Amazon {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
		driver = new ChromeDriver();
		String AppUrlAddress = "http://Amazon.in";
		driver.get(AppUrlAddress);
		driver.manage().window().maximize();
		
		// mouse hover on to HelloSign In element
		// identifying the properties of  HelloSign element
        // id="nav-link-accountList"
		By helloSignInL=By.id("nav-link-accountList");
		WebElement helloSignIn=driver.findElement(helloSignInL);
// mouse hover operation on to HelloSign In element-done using "ACTIONS CLASS"
		
		Actions action= new Actions(driver);
		action.moveToElement(helloSignIn).build().perform();
// Automating your orders Element(HiddenElement)-type of Element-Link
// Link Text - your orders
// since your orders is an hiddenElement-first performing mouse hover operation on to "	helloSignIn	"-making the"your orders"
// element(which is under test) visible and then recognization of "your orders"-performing operation
		 By yourordersL=By.linkText("Your Orders");
		WebElement yourorders= driver.findElement(yourordersL);
		yourorders.click();
	}

}
