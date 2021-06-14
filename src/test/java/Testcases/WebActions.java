package Testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;

public class WebActions extends TestBase {

	// public WebDriver driver;
	String driver_path = "browser_drivers\\";
	WebDriverWait wait;

	public WebElement waitForVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/*
	 * KeywordName:--> Click Element Author:--> Anusha Dondeti CreatedOn;--> 11
	 * May 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */
	public void click(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		elm.click();
		log.info("Successfully clicked on: " + info);
		logger.info("successfully clicked on" + info);
		System.out.println("Successfully clicked on: " + info);
	}

	/*
	 * KeywordName:--> Send Keys Author:--> Anusha Dondeti CreatedOn;--> 11 May
	 * 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */

	public void sendKeys(By locator, String text) {
		// driver.findElement(locator).sendKeys(text);
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(text);
		log.info("Successfully entered text: " + text);
		logger.info("successfully entered text:" + text);
		System.out.println("Successfully entered text: " + text);
	}

	/*
	 * KeywordName:--> GetText of field Author:-->Anusha Dondeti CreatedOn;--> 11
	 * May 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */

	public String getText(By locator) {
		// String str_getText = driver.findElement(locator).getText();
		String str_getText = waitForVisible(locator).getText();
		log.info("Successfully get text: " + str_getText);
		logger.info("Successfully get text: \" + str_getText");
		System.out.println("Successfully get text: " + str_getText);
		return str_getText;
	}

	/*
	 * KeywordName:--> Verify Text Author:--> Anusha Dondeti CreatedOn;--> 11 May
	 * 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */

	public void verifyText(String actual, String expected) {
		if (actual.equals(expected)) {
			log.pass(actual + " equals with " + expected);
			logger.error("(actual + \" equals with \" + expected");
			System.out.println(actual + " equals with " + expected);
		} else {
			log.fail(actual + " not equals with " + expected);
			logger.error("actual + \" not equals with \" + expected");
			System.out.println(actual + " not equals with " + expected);
		}

		assertEquals(actual, expected);

	}

	/*
	 * KeywordName:--> Select dropdown using value Author:--> Anusha Dondeti
	 * CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:--> Local
	 * LastUpdationDate:-->
	 */

	public WebElement element(By locator) {
		return driver.findElement(locator);
	}

	public void selectDropDownByValue(By locator, String value) {
		Select select = new Select(element(locator));
		select.selectByValue(value);
		log.info("Successfully entered value: " + value);
		logger.info("Successfully entered value: \" + value");
		System.out.println("Successfully entered value: " + value);
	}
	/*
	 * KeywordName:--> Alert Accept Author:--> Anusha Dondeti CreatedOn;-->11 May
	 * 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */

	public void AlertOk() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		log.info("sucessfully clicked on ok button of alert pop-up");
		logger.info("sucessfully clicked on ok button of alert pop-up");
		System.out.println("sucessfully clicked on ok button of alert pop-up");
	}
	/*
	 * KeywordName:--> Alert With Close Author:-->Anusha Dondeti CreatedOn;-->11
	 * May 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */

	public void AlertCancel() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		log.info("sucessfully clicked on cancel button of pop-up");
		logger.info("\"sucessfully clicked on cancel button of pop-up");
		System.out.println("\"sucessfully clicked on cancel button of pop-up");
	}

	/*
	 * KeywordName:--> Load webpage using http:// or https:// Author:--> Anusha Dondeti
	 * CreatedOn;--> 11 May 2021 ReviewedBy:--> Parameters used:--> Local
	 * LastUpdationDate:-->
	 */
	public void load_webpage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	/*
	 * KeywordName:--> Set implicit and explicit timeout Author:-->Anusha Dondeti
	 * CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:--> Local
	 * LastUpdationDate:-->
	 */
	public void set_timeout(int time_in_sec) {
		driver.manage().timeouts().implicitlyWait(time_in_sec, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, time_in_sec);
	}

	/*
	 * KeywordName:--> Entet inputvalue into editbox.[Possible with
	 * pagefactory @findby methods] Author:-->Anusha Dondeti CreatedOn;-->11 May
	 * 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */
	public void Enter_text(WebElement Element, String input) {
		WebElement Editbox = wait.until(ExpectedConditions.visibilityOf(Element));
		Editbox.clear();
		Editbox.sendKeys(input);
	}

	/*
	 * KeywordName:--> Selected Dropdown using SelectByvisibletext [Using By
	 * refernce] Author:--> Anusha Dondeti CreatedOn;-->11 May 2021 ReviewedBy:-->
	 * Parameters used:--> Local LastUpdationDate:-->
	 */
	public void select_dropdown(By locator, String Optionname) {
		WebElement Element = driver.findElement(locator);
		new Select(Element).selectByVisibleText(Optionname);
	}

	/*
	 * KeywordName:--> Click Any clickable element
	 * [link,button,radiobutton,checkbox] [Using By class refernce] Author:-->
	 * Anusha Dondeti CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:-->
	 * Local LastUpdationDate:-->
	 */
	public void click_element(By locator) {
		WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		Element.click();
	}

	/*
	 * KeywordName:--> Mousehover on element.[Using By parameter] Author:-->
	 * Anusha Dondeti CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:-->
	 * Local LastUpdationDate:-->
	 */

	public void mousehover(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		WebElement Element = driver.findElement(locator);
		new Actions(driver).moveToElement(elm).pause(2000).perform();
		log.info("cursor moved to the element location");
		System.out.println("mouse hover action sucessfull");
		logger.info("Sucessfully clicked on : " + locator);
	}

	/*
	 * KeywordName:--> Fileupload using robot class Author:--> Anusha Dondeti
	 * CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:--> Local
	 * LastUpdationDate:-->
	 */

	public void FileUploading(String filepath) {
		String text = filepath;

		// Select String
		StringSelection Stext = new StringSelection(text);
		// Get default system clipboard
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// set content to clipboard at runtime.
		clipboard.setContents(Stext, Stext);

		// Crate object for Robot class
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.setAutoDelay(1000);

		// Press Ctrl+V to paste copied text into notepad file
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Press enter key
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Control key
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}

	/*
	 * KeywordName:--> CaptureScreen using [Filename] Author:--> Anusha Dondeti
	 * CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:--> Local
	 * LastUpdationDate:-->
	 */
	public void capturescreen(String imagename) {
		try {
			Thread.sleep(5000);
			// creating simple date format
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MMM/dd/ hh-mm-ss");
			// get system default date
			Date d = new Date();
			// Convert system date using default format
			String time = df.format(d);

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("screens\\" + time + imagename + ".png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * KeywordName:--> SwitchTo window Author:-->Anusha Dondeti CreatedOn;--> 11
	 * May 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */
	public void switchto_window(String windowtitle) {
		// Get All dynamic window ID's
		Set<String> Allwindow_IDS = driver.getWindowHandles();

		// Iteate for all window times
		for (String EachWindowID : Allwindow_IDS) {
			// Switch to Every window
			driver.switchTo().window(EachWindowID);
			// Capture every window title
			String Runtime_title = driver.getTitle();

			// Condition to accept on expected window title match
			if (Runtime_title.contains(windowtitle)) {
				break; // Stop Iteration and get execution control out of for loop.
			}
		}
	}

	/*
	 * KeywordName:--> Verify title presented at webpage. Author:--> Anusha Dondeti
	 *  CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:--> Local
	 * LastUpdationDate:-->
	 */
	public boolean isTitle_presented(String Exp_title) {
		String Runtime_title = driver.getTitle();
		boolean flag = Runtime_title.contains(Exp_title);
		return flag;
	}

	/*
	 * KeywordName:--> Verify title presented using explicit wait. Author:-->
	 * Anusha Dondeti CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:-->
	 * Local LastUpdationDate:-->
	 */
	public boolean wait_and_VerifyTitle_Presented(String Exp_title) {
		try {
			boolean flag = wait.until(ExpectedConditions.titleContains(Exp_title));
			return flag;
		} catch (TimeoutException e) {
			return false;
		}

	}

	/*
	 * KeywordName:--> Verify url presented using explicit wait. Author:--> Anusha Dondeti
	 *  CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:--> Local
	 * LastUpdationDate:-->
	 */
	public boolean is_urlpresented(String Exp_url) {
		try {
			boolean flag = wait.until(ExpectedConditions.urlContains(Exp_url));
			return flag;
		} catch (TimeoutException e) {
			return false;
		}

	}

	/*
	 * KeywordName:--> window handling Author:-->Anusha Dondeti CreatedOn;-->11
	 * May 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */

	public void window_handling() throws InterruptedException {
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				log.info("successfully switched to child window:");
				logger.info("successfully switched to child window:");
				System.out.println(driver.switchTo().window(child_window).getTitle());

				Thread.sleep(2000);

			}
		}
	}
	/*
	 * KeywordName:--> Is Alert presented Author:-->Anusha Dondeti
	 * CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:--> Local
	 * LastUpdationDate:-->
	 */

	public boolean isAlert_Presented() {
		try {
			driver.switchTo().alert();
			logger.info("Alert is present on the page");
			log.info("Alert is present on the page");
			System.out.println("Alert is present on the page");
			return true;
		} catch (Exception e) {
			log.info("Alert is not present on the page");
			return false;
		}
	}
	/*
	 * KeywordName:-->File uploading Author:--> Anusha Dondeti CreatedOn;-->11 May
	 * 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */

	public void upload(By locator, String value) {
		waitForVisible(locator).sendKeys(value);
		log.info("Successfully uploaded file: ");
		logger.info("Successfully Uploaded file" + value);
		System.out.println("Successfully entered text:");
	}

	/*
	 * KeywordName:-->Switch to frame Author:--> Anusha Dondeti CreatedOn;-->11
	 * May 2021 ReviewedBy:--> Parameters used:--> Local LastUpdationDate:-->
	 */

	public void switchtoframe(By locator) {
		WebElement frame1 = waitForVisible(locator);
		driver.switchTo().frame(frame1);
		logger.info("Successfully switched to child frame" + frame1);

	}

	/**
	 * =============================================================================
	 * Method: Switchtomainframe | Author:Anusha Dondeti | Date:11 May 2021 |
	 * Description: This method will Switchtomainframe | Parameters: locator, info |
	 * Return: none
	 * =============================================================================
	 */

	public void switchtomainframe() {
		// TODO Auto-generated method stub
		driver.switchTo().defaultContent();
		logger.info("Successfully switched to Parent frame");

	}

	/*
	 * KeywordName:--> window handling with alert Author:--> Anusha Dondeti
	 * CreatedOn;-->11 May 2021 ReviewedBy:--> Parameters used:--> Local
	 * LastUpdationDate:-->
	 */

	public void window_handling1(By locator) throws InterruptedException {
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				log.info("successfully switched to child window:");
				logger.info("successfully switched to child window:");
				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.findElement(locator).click();
				log.info("successfully clicked on project:");
				logger.info("successfully clicked on project:");

				Alert alert = driver.switchTo().alert();
				alert.accept();

				Thread.sleep(2000);

			}
		}
		// switch to the parent window
		driver.switchTo().window(parent);
		log.info("successfully switched to parent window:");
		logger.info("successfully switched to parent window:");
	}

	/**
	 * =============================================================================
	 * Method:  keybordactions | Author:Anusha Dondeti | Date:25 May 2021 |
	 * Description: This method will use the KeyBordaction | Parameters: locator, info |
	 * Return: none
	 * =============================================================================
	 */
	public void keybordactions(By locator) throws Throwable {
		Robot robot = new Robot();
		robot.setAutoDelay(500);
		robot.keyPress(KeyEvent.VK_ENTER);

	}
	/**
	 * =============================================================================
	 * Method:  ScrollDown | Author:Anusha Dondeti | Date:25 May 2021 |
	 * Description: This method will use the KeyBordaction | Parameters: locator, info |
	 * Return: none
	 * =============================================================================
	 */
	public void ScrollDown(By Locator) {
		WebElement sel = waitForVisible(Locator);
		Point loc = sel.getLocation();
		System.out.println(loc);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy" + loc);
		System.out.println("Sucessfully Scrolled down to " + loc);
		log.info("Sucessfully scrolled doen to " + loc);
		logger.info("sucesfully scrolled down to the " + loc + "using the locator " + Locator);
	}
	/**
	 * =============================================================================
	 * Method:  ScrollDown | Author:Anusha Dondeti | Date:25 May 2021 |
	 * Description: This method will use the KeyBordaction | Parameters: locator, info |
	 * Return: none
	 * =============================================================================
	 */
	public void Scrolldown1() throws Throwable {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
	}
	/**
	 * =============================================================================
	 * Method:  ScrollDown | Author:Anusha Dondeti | Date:25 May 2021 |
	 * Description: This method will use the KeyBordaction | Parameters: locator, info |
	 * Return: none
	 * =============================================================================
	 */

   public void doubleClick(By locator){
	   Actions actions = new Actions(driver);
	   WebElement locator1 = driver.findElement(By.id("ID"));
	   actions.doubleClick(locator1).perform();

	
	
}
   /**
	 * =============================================================================
	 * Method:  ScrollDown | Author:Anusha Dondeti | Date:25 May 2021 |
	 * Description: This method will use the KeyBordaction | Parameters: locator, info |
	 * Return: none
	 * =============================================================================
	 */
   public void Scrolldown2() throws Throwable {
	   Thread.sleep(2000);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,500)");
	   }
   /**
	 * =============================================================================
	 * Method:  ScrollDown | Author:Anusha Dondeti | Date:25 May 2021 |
	 * Description: This method will use the KeyBordaction | Parameters: locator, info |
	 * Return: none
	 * =============================================================================
	 */
   public void window_handling2(By locator) throws Throwable {
	// TODO Auto-generated method stub
	String parent = driver.getWindowHandle();
	Set<String> s = driver.getWindowHandles();
	// Now iterate using Iterator
	Iterator<String> I1 = s.iterator();
	while (I1.hasNext()) {
	String child_window = I1.next();
	if (!parent.equals(child_window)) {
	driver.switchTo().window(child_window);
	log.info("successfully switched to child window:");
	logger.info("successfully switched to child window:");
	System.out.println(driver.switchTo().window(child_window).getTitle());
	// driver.findElement(locator).click();
	waitForVisible(locator).click();
	log.info("successfully clicked on project:");
	logger.info("successfully clicked on project:");
	Thread.sleep(1000);

	 }
	}
	}
   /**
	 * =============================================================================
	 * Method: MoveToElement | Author:Anusha Dondeti | Date:25 May 2021 |
	 * Description: This method will move the  | Parameters: locator, info |
	 * Return: none
	 * =============================================================================
	 */
   public void MoveToElement(By locator) {
//     WebElement element = driver.findElement(locator);
     WebElement element = waitForVisible(locator);
     Actions ac = new Actions(driver);
     ac.moveToElement(element).build().perform();
     log.info("cursor moved to the element location");
     System.out.println("mouse hover action sucessfull");
     logger.info("Sucessfully located the element using the locator: " + locator);
 }
   
}
