package com.hotal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hotalreg {

	public static WebDriver driver;	
	public static JavascriptExecutor js = (JavascriptExecutor) driver; 
	
	
	//Avenstack Extends Report
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	
	
	public static void browser(String browser) {
		switch (browser) {
         case ("chrome"):
			WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Hp\\eclipse-workspace\\SaturdayClass\\src\\test\\resources\\file\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
			driver.manage().window().maximize();
			break;
		case ("firefox"):
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
			driver .manage().window().maximize();
			break;
		}
	}
	 public static  void loadurl(String url) {
		 driver.get(url);
		
	 }
	public static String getcururl() {
		String url=	driver.getCurrentUrl();
		return url;
		
		}
		
		
	
	public static WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement findElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement findElementname(By name) {
		return driver.findElement(name);
	}

	public static WebElement findElementid(By id) {
		return driver.findElement(id);
	}

	public static String sendtestData(WebElement element ,String key) throws FileNotFoundException {
		File f = new File("D:\\programs\\Example\\src\\test\\resources\\Data\\file.property");
		FileReader reader = new FileReader(f);
		Properties prop = new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String k =  prop.getProperty(key);
		element.sendKeys(k);
		return k;
	}
	public static String SendByExcel(WebElement element,int i, int j) throws IOException {
		String value = null;
		File f = new File("C:\\Users\\Hp\\eclipse-workspace\\SaturdayClass\\src\\test\\resources\\Data\\Datafile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		value = cell.getStringCellValue();
		element.sendKeys(value);
		return value;
	}
	public static String readbysheet(int i, int j) throws IOException {
		String value = null;
		File f = new File("C:\\Users\\Hp\\eclipse-workspace\\SaturdayClass\\src\\test\\resources\\Data\\Datafile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		value = cell.getStringCellValue();
		return value;
	}
	
	public static int getrowcount() throws IOException {
		File f = new File("C:\\Users\\Hp\\eclipse-workspace\\SaturdayClass\\src\\test\\resources\\Data\\Datafile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
	 int numofrows =sheet.getPhysicalNumberOfRows();
	    return numofrows;
	}
	public static int getcellcount() throws IOException {
		File f = new File("C:\\Users\\Hp\\eclipse-workspace\\SaturdayClass\\src\\test\\resources\\Data\\Datafile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row =sheet.getRow(0);
		int rows= sheet .getPhysicalNumberOfRows();
		int numofcolumns =row.getPhysicalNumberOfCells();
		return numofcolumns;
		
	}
	
	
	
	public static void pageClose() {
		driver.close();
	}

	public static void screenShot() {
		try {
			TakesScreenshot tk = (TakesScreenshot) driver;
			FileUtils.copyFile(tk.getScreenshotAs(OutputType.FILE), new File("./ScreenShot/screen.jpeg"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void captureScreen() throws IOException {
		Date d = new Date();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./ScreenShot/" + d.toString().replace(":", "_") + ".png"));
	}
	public static void selectDropDownindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public static void selectDropDowntext(WebElement element,  String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
}
	
	
	
 
//	public static void pagload(String url) {
//		driver.switchTo().window(getcururl());
//		
//	}
	