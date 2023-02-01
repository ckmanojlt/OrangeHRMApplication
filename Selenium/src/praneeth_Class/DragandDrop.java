package praneeth_Class;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;




public class DragandDrop {
public static void main(String[] args) {
	
	WebDriver driver;
	String ApplicationUrlAddress ="https://jqueryui.com/droppable/";

//Launching Browser	
	System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe" );

	driver = new ChromeDriver();
    
//Navigating to JqueryUi Application
	  driver.get(ApplicationUrlAddress);
	  driver.manage().window().maximize();
	  
By frameofWebPageL=By.className("demo-frame");
WebElement frameofWebPage =driver.findElement(frameofWebPageL);
//----------------------------------------------------------------------------------------------------------------------
//control or driver switching to webPage to Frame
driver.switchTo().frame(frameofWebPage);

By dragmeToMyTargetL=By.id("draggable");
WebElement DragMeToMyTarget=driver.findElement(dragmeToMyTargetL);

By dropHereL=By.id("droppable");
WebElement DropHere=driver.findElement(dropHereL);

//Drag element is Dragging to the Drop Element
Actions action=new Actions(driver);
action.dragAndDrop(DragMeToMyTarget, DropHere).build().perform();


//control or driver switching back from Frame to webPage
driver.switchTo().defaultContent();
//-----------------------------------------------------------------------------------------------------------------------------

    By resizableL=By.linkText("Resizable");
	WebElement Resizable=driver.findElement(resizableL);
	
	String ResizableText=Resizable.getText();
	System.out.println(ResizableText);
	

	
	
	
	
}
}
