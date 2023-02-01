package webtable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable_Capturingfirstcolumndata {
 WebDriver driver;

	public void applicationlaunch() {
		String applicationurladdress = "https://www.timeanddate.com/worldclock/";
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationurladdress);
		driver.manage().window().maximize();
	}

	public void capturingfirstcolumndata() throws IOException {
		
		FileInputStream file=new FileInputStream("./src/excel_worksheets/WebTableData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		
		/// html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a

		/// html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[2]/td[1]/a
		/// html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[3]/td[1]/a

		/// html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[6]/td[1]/a

		String XpathExpressionPart1 = "html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String XpathExpressionPart2 = "]/td[1]";

		By TableXpathL = By.xpath("html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr");
		List<WebElement> WebTableCityNames = driver.findElements(TableXpathL);
		int Cities_count = WebTableCityNames.size();
		System.out.println(Cities_count);
		for (int i = 1; i <= Cities_count; i++) {

			WebElement CityNameElement = driver.findElement(By.xpath(XpathExpressionPart1 + i + XpathExpressionPart2));
			String CityNames = CityNameElement.getText();
			System.out.println(CityNames);
			
			Row row=sheet.createRow(i-1);
			Cell cell=row.createCell(0);
			
			cell.setCellValue(CityNames);
		
		}
		FileOutputStream file1=new FileOutputStream("./src/excel_worksheets/WebTableData.xlsx");
		workbook.write(file1);
	}
	
	public static void main(String[] args) throws IOException {
		Webtable_Capturingfirstcolumndata obj = new Webtable_Capturingfirstcolumndata();
		obj.applicationlaunch();
		obj.capturingfirstcolumndata();
	}

}
