package ohrm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class OHRM_LoginLogout {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String ApplicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";

		// Launching Browser
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");

		driver = new ChromeDriver();
		// Navigating to OrangeHRM Application
		driver.get(ApplicationUrlAddress);

//Validate LoginPage

		// LoginPage title validation
		String Expected_OHRM_LoginPageTitle = "OrangeHRM";
		String Actual_OHRM_LoginPageTitle = driver.getTitle();

		if (Actual_OHRM_LoginPageTitle.equals(Expected_OHRM_LoginPageTitle))
			System.out.println("Title is matched - Pass");
		else
			System.out.println("Title is not matched - Fail");

		// LoginPage url address validation
		String Expected_OHRM_LoginPageUrl = "orangehrm-4.2.0.1";
		String Actual_OHRM_LoginPageUrl = driver.getCurrentUrl();

		if (Actual_OHRM_LoginPageUrl.contains(Expected_OHRM_LoginPageUrl))
			System.out.println("LoginPage contains required Url  - Pass");
		else
			System.out.println("LoginPage does not contains required Url - Fail");

		// LoginPanel Text Validation
		String Expected_OHRM_LoginPanelText = "LOGIN Panel";

		// <div id="logInPanelHeading">LOGIN Panel</div>
		By LoginTextLocator = By.id("logInPanelHeading");
		WebElement LoginPanel = driver.findElement(LoginTextLocator);
		String Actual_OHRM_LoginPanelText = LoginPanel.getText();
		System.out.println("LoginPage LoginPanel Text :" + Actual_OHRM_LoginPanelText);

		if (Actual_OHRM_LoginPanelText.equals(Expected_OHRM_LoginPanelText))
			System.out.println("Text is matched - Pass");
		else
			System.out.println("Text is not matched - Fail");

		// Login with valid test data
		driver.findElement(By.id("txtUsername")).sendKeys("CK@346");
		driver.findElement(By.name("txtPassword")).sendKeys("Manojreddy@346");
		driver.findElement(By.id("btnLogin")).click();

//Validate HomePage

		// HomePage title validation
		String Expected_OHRM_HomePageTitle = "OrangeHRM";
		String Actual_OHRM_HomePageTitle = driver.getTitle();

		if (Actual_OHRM_HomePageTitle.equals(Expected_OHRM_HomePageTitle))
			System.out.println("HomePage Title is matched - Pass");
		else
			System.out.println("HomePage Title is not matched - Fail");

		// Admin Text Validation
		String Expected_OHRM_HomePage_AdminText = "Admin";

		By AdminTextLocator = By.className("firstLevelMenu");
		WebElement AdminText = driver.findElement(AdminTextLocator);
		String Actual_OHRM_HomePage_AdminText = AdminText.getText();
		System.out.println("Home Page Admin Text  :" + Actual_OHRM_HomePage_AdminText);

		if (Actual_OHRM_HomePage_AdminText.equals(Expected_OHRM_HomePage_AdminText))
			System.out.println(" Homepage_Admin_Text is matched - Pass");
		else
			System.out.println("Homepage_Admin_Text is not matched - Fail");
		// Automate Welcome Admin
		By WelcomeAdminLocator = By.linkText("Welcome Admin");
		WebElement WelcomeAdmin = driver.findElement(WelcomeAdminLocator);
		WelcomeAdmin.click();

		// Pausing the Execution for 5 seconds
		Thread.sleep(5000);

		// Automate Logout
		By LogoutLocator = By.linkText("Logout");
		WebElement Logout = driver.findElement(LogoutLocator);
		Logout.click();

		// LoginPanel Text Validation after Logout
		String Expected_OHRM_LoginPanelTextAfter_Logout = "LOGIN Panel";

		// <div id="logInPanelHeading">LOGIN Panel</div>
		By LoginTextLocatorAfter_Logout = By.id("logInPanelHeading");
		WebElement LoginPanelAfter_Logout = driver.findElement(LoginTextLocatorAfter_Logout);
		// String LoginPanelAttribute=LoginPanelAfter_Logout.getAttribute("id");
		// System.out.println("LoginPanelAttribute :"+LoginPanelAttribute);

		String Actual_OHRM_LoginPanelTextAfter_Logout = LoginPanelAfter_Logout.getText();
		System.out.println("LoginPage LoginPanel Text After Logout :" + Actual_OHRM_LoginPanelTextAfter_Logout);

		if (Actual_OHRM_LoginPanelTextAfter_Logout.equals(Expected_OHRM_LoginPanelTextAfter_Logout))
			System.out.println("Text is matched - Pass");
		else
			System.out.println("Text is not matched - Fail");
		// Application Close
		// driver.close();

	}

}
