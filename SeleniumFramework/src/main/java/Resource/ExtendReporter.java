package Resource;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtendReporter {
	
	public static ExtentReports getReport() {
		
		String path = System.getProperty("user.dir")+"//report//index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//set report name
		reporter.config().setReportName("Web Automation Results");
		//set document title
		reporter.config().setDocumentTitle("Test Results");
		
		//attach report
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Sathish");
		
		return extent;
		
	}

}
