package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Cell;

public class base {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	String[] data;
	Sheet sheetObj;
	Workbook WorkbookObj;
	File file;
	String fileExtensionName;
	int rowCount;
	Row row;
	Cell cell;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		fis = new FileInputStream(
				"D:\\Automation\\T-Res-New\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("Webdriver.chrome.driver",
					prop.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.marionette",
					prop.getProperty("FirefoxDriverPath"));
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					prop.getProperty("IEDriverPath"));
			driver = new InternetExplorerDriver();
		}

		else {
			System.setProperty("Webdriver.chrome.driver",
					prop.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenShotPath(String testCaseName, WebDriver driver)
			throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports"
				+ testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}

	public void pleaseWait() throws InterruptedException {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.invisibilityOfElementLocated(By
						.xpath("//*[@id='AjaxBusyImg']")));
		Thread.sleep(5000);
	}

	public void createConnection(String filePath, String fileName,
			String sheetName) throws IOException {

		file = new File(filePath);
		fis = new FileInputStream(file);
		fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {
			WorkbookObj = new XSSFWorkbook(fis);
		} else if (fileExtensionName.equals(".xls")) {
			WorkbookObj = new HSSFWorkbook(fis);
		}
		
		System.out.println("excel connection success");

		sheetObj = WorkbookObj.getSheet(sheetName);
		rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();

	}

	public int getRowCount() {
		return rowCount;
	}
	
	public int getColCount()
	{
		return row.getLastCellNum();
	}

	public String[] fetchData(int i) {
		
			int value = 0;
		
		for (int j = 0; j < row.getLastCellNum(); j++) {
			 cell= row.getCell(j);
			 data[value]=row.getCell(j).getStringCellValue();
			value++;
		}
	
		return data;

		
	}
}
