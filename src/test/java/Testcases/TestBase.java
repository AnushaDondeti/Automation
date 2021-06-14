package Testcases;

import java.security.KeyStore.TrustedCertificateEntry;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;
import utilities.ReportManager;
import utilities.ScreenshotUtil;

public class TestBase {

	
    Logger logger = Logger.getLogger("logs");
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest log;

	String str_Browser = ConfigReader.getValue("Browser");

	@BeforeClass
	public void openURL() {
		TestBase testBase = new TestBase();
		testBase.browser();
		System.out.println("url value: " + ConfigReader.getValue("URL"));
		driver.get(ConfigReader.getValue("URL"));
	}

	public void browser() {

		if (str_Browser.equalsIgnoreCase("Chrome")) {
			System.out.println("##################launched chrome driver#####################");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (str_Browser.equalsIgnoreCase("Firefox")) {
			System.out.println("##################launched firefox driver#####################");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (str_Browser.equalsIgnoreCase("IE")) {
			System.out.println("##################launched IE driver#####################");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (str_Browser.equalsIgnoreCase("Edge")) {
			System.out.println("##################launched edge driver#####################");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	}

	// =================Before Suite==================
	@BeforeSuite
	public void beforeSuite() {

		ReportManager.startReport();
		PropertyConfigurator.configure("D:\\workspace1\\Automationtask\\src\\test\\resources\\ConfigFiles\\Log4j.properties");
	}

	// =================After Suite==================
	@AfterSuite
	public void afterSuite() {

		ReportManager.endReport();
	}

	@AfterMethod

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			log.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			log.log(Status.FAIL, "Failed",
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.takeScreenshot()).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			log.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			log.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		//driver.quit();
	
	



}}
