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


public class DynamicWebTable {
WebDriver driver;
public void setUp() {
	String applicationurladdress = "https://www.timeanddate.com/worldclock/";
	System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(applicationurladdress);
	driver.manage().window().maximize();
}
public void tearDown() {
	driver.close();
}
public void DynamicWebTableData() throws IOException {
FileInputStream file =new FileInputStream("./src/excel_worksheets/dynamicwebtabledata.xlsx");
XSSFWorkbook workBook = new XSSFWorkbook(file);
XSSFSheet sheet= workBook.getSheet("sheet1");
	By tableL=By.className("tb-scroll");
	WebElement TableElement=driver.findElement(tableL);
	
	By rowL=By.tagName("tr");
	
	List<WebElement>TotalRows=TableElement.findElements(rowL);
	int rows_count=TotalRows.size();
	for(int rowindex=1;rowindex<rows_count;rowindex++) {
		Row row=sheet.createRow(rowindex-1);
		By rowofcellL=By.tagName("td");
		List<WebElement>TotalRowofCells=TotalRows.get(rowindex).findElements(rowofcellL);
		int rowofcells_count=TotalRowofCells.size();
		for(int cellindex=0;cellindex<rowofcells_count;cellindex++) {
			Cell cell=row.createCell(cellindex);
			String WebTableData=TotalRowofCells.get(cellindex).getText();
			System.out.print(" "+WebTableData+" ");
			cell.setCellValue(WebTableData);
		}
		System.out.println();
	}
	
	FileOutputStream file1= new FileOutputStream("./src/excel_worksheets/dynamicwebtabledata.xlsx");
	workBook.write(file1);
}

public static void main(String[] args) throws IOException {
	DynamicWebTable obj=new DynamicWebTable();
	
	obj.setUp();
	obj.DynamicWebTableData();
	obj.tearDown();
}





}
