package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testcases.TestBase;


public class ReportManager extends TestBase{
	
	public static  void startReport() {
		System.out.println(System.getProperty("user.dir"));
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/HtmlReports/QualityMatrix.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Quality Matrix");
		extent.setSystemInfo("Environment", "Test Env");
		extent.setSystemInfo("User Name", "Anusha Dondeti");
		extent.setSystemInfo("Version", "1.1");
		htmlReporter.config().setDocumentTitle("Quality Matrix");
		htmlReporter.config().setReportName("Quality Matrix Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public static void endReport() {
		extent.flush();
	}
}

