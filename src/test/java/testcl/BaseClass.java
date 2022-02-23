package testcl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeSuite
	public void beforeSuite() {
		browserlaunch("http://adactinhotelapp.com/");
		System.out.println("My Before Suite");
	}	

	@AfterMethod
	public void afterMethod() {
//		extent.flush();
	}
//    @BeforeTest
	public static void browserlaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
//		public static void browserlaunch(@Optional("firefox")String browser)
//		System.setProperty("webdriver.chrome.driver", "E:\\eclipse-workspace\\JavaCombine\\Driver\\chromedriver.exe");

//		switch (browser) {
//		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			break;
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//			break;
//		case "edge":
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//			driver.manage().window().maximize();
//			break;
//		default:
//			System.out.println("No Browser Matched");
//			break;
//		}
//		
	}

	// driver.findelement(By.id()) //String Concept
	public static WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement findElementByxpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	// Abstract method
	public static WebElement findElementAB(By ab) {
		return driver.findElement(ab);
	}

	public static void typeData(WebElement element, String data) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(data);
	}

	public static void click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void jsClick(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}

	public static void clickandhold(WebElement element) {
		new Actions(driver).clickAndHold(element).perform();
	}

	public static void mouseHover(WebElement element) {
		new Actions(driver).moveToElement(element).build().perform();
	}

	public static void dragdrop(WebElement src, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, target);
	}

	public static void selectDropDownIndex(WebElement element, int id) {
		new Select(element).selectByIndex(id);
	}

	public static void selectDropDownValue(WebElement element, String name) {
		Select select = new Select(element);
		select.selectByValue(name);
	}

	public static String testData(String key) throws FileNotFoundException {
		// File f = new File("./target/props.properties");
		File f = new File("./TestData/Data.properties");
		FileReader reader = new FileReader(f);
		Properties prop = new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	

}
