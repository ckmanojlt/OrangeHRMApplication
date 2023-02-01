package ohrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OHRM_LILO_PRACTICE {

	public static void main(String[] args) throws InterruptedException {
		// Launching ChromeBrowser
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe ");
		driver = new ChromeDriver();
		
		// Navigate to OHRM Application
		String AppUrlAddress ="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		driver.get(AppUrlAddress);
		
		// Validate LogIn Page
		//  LogInpage Title validation
		
		String Expected_OHRM_loginpage_Title ="OrangeHRM" ;
		String Actual_OHRM_loginpage_Title = driver.getTitle();
		System.out.println("the actual ohrm login page title is:"+Actual_OHRM_loginpage_Title);
		
		if(Actual_OHRM_loginpage_Title.equals(Expected_OHRM_loginpage_Title))
		System.out.println("the title is matched - PASS");
		else
			System.out.println("the title is not matched - FAIL");
		
		//  LogInpage Url validation
		
		String Expected_OHRM_loginpage_Url ="orangehrm-4.2.0.1" ;
		String Actual_OHRM_loginpage_Url = driver.getCurrentUrl();
		System.out.println("the actual ohrm login page Url is:"+Actual_OHRM_loginpage_Url);
		if(Actual_OHRM_loginpage_Url.contains(Expected_OHRM_loginpage_Url))
			System.out.println("the current url is matched - PASS");
		else
			System.out.println("the current url is not matched - FAIL");
		
// Login panel text validation
		
		String Expected_LogInPanel_Text = "LOGIN Panel";
		//<div id="logInPanelHeading">LOGIN Panel</div>
		
		By Loginpanellocator = By.id("logInPanelHeading");
		WebElement Loginpanel = driver.findElement(Loginpanellocator);
		String Actual_Loginpanel_Text = Loginpanel.getText();
		System.out.println("the actual login panel text is:"+Actual_Loginpanel_Text);
		if(Actual_Loginpanel_Text.equals(Expected_LogInPanel_Text))
			System.out.println("Loginpanel text is matched - PASS");
		else
			System.out.println("Loginpanel text is not matched - FAIL ");
		
// Login with valid test data	
		
	driver.findElement(By.id("txtUsername")).sendKeys("CK@346");
		driver.findElement(By.id("txtPassword")).sendKeys("Manojreddy@346");
		driver.findElement(By.id("btnLogin")).click();
		
// Validate HomePage
		
		 //HomePage title validation
		  String Expected_OHRM_HomePageTitle="OrangeHRM";
		  String Actual_OHRM_HomePageTitle = driver.getTitle();
		  
		  if(Actual_OHRM_HomePageTitle.equals(Expected_OHRM_HomePageTitle))
		  System.out.println("HomePage Title is matched - Pass");
		  else
			  System.out.println("HomePage Title is not matched - Fail");	
// Admin Text Validation				
		String Expected_OHRM_HomePage_AdminText ="Admin";
		 By AdminTextLocator = By.className("firstLevelMenu");
		WebElement AdminText=driver.findElement(AdminTextLocator);
		String Actual_OHRM_HomePage_AdminText = AdminText.getText();
		System.out.println("the actual orange hrm home page admin text is :"+Actual_OHRM_HomePage_AdminText);
		if(Actual_OHRM_HomePage_AdminText.equals(Expected_OHRM_HomePage_AdminText))
		{
			System.out.println("OHRM_HomePage_AdminText is matehed - PASS");
		}
			else
			{
				System.out.println("OHRM_HomePage_AdminText is not matehed - FAIL"); 
			}
		
// Automate Welcome Admin
		
		By WelcomeAdminLocator = By.linkText("Welcome Admin");
		 WebElement WelcomeAdmin=driver.findElement(WelcomeAdminLocator);
		 
		 WelcomeAdmin.click();
		 // pausing the Execution for 5 seconds
		 
		 Thread.sleep(5000);
		 // Automate Logout
		  By Logoutlocator = By.linkText("Logout");
		WebElement Logout =driver.findElement(Logoutlocator);
		
		Logout.click();
//LoginPanel Text Validation after Logout
		  String Expected_OHRM_LoginPanelTextAfter_Logout="LOGIN Panel";
		  //<div id="logInPanelHeading">LOGIN Panel</div>
		  By LoginTextLocatorAfter_Logout=By.id("logInPanelHeading");
		  WebElement LoginPanelAfter_Logout= driver.findElement(LoginTextLocatorAfter_Logout);
		 // String LoginPanelAttribute=LoginPanelAfter_Logout.getAttribute("id");
		 // System.out.println("LoginPanelAttribute :"+LoginPanelAttribute);
		  
		  
		  String Actual_OHRM_LoginPanelTextAfter_Logout= LoginPanelAfter_Logout.getText();
		  System.out.println("LoginPage LoginPanel Text After Logout :"+Actual_OHRM_LoginPanelTextAfter_Logout);
		 
		  if(Actual_OHRM_LoginPanelTextAfter_Logout.equals(Expected_OHRM_LoginPanelTextAfter_Logout))
			  System.out.println("Text is matched - Pass");
			  else
				  System.out.println("Text is not matched - Fail");
//Application Close  
		 // driver.close();
					}
			{
		}
		
	}


