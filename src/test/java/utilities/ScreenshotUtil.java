package utilities;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Testcases.TestBase;


public class ScreenshotUtil extends TestBase {
	
	
	public static String takeScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
        String source = ts.getScreenshotAs(OutputType.BASE64);            
        return source;
	}


}
