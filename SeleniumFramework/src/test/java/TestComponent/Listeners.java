package TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resource.ExtendReporter;

public class Listeners extends BaseTest implements ITestListener{

	ExtentTest test;
	ExtentReports extend = ExtendReporter.getReport();
	//Thread safe
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		test = extend.createTest(result.getMethod().getMethodName());
		thread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {


		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());	
		} catch (Exception e) {
			e.printStackTrace();
		}

		thread.get().fail(result.getThrowable());

		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extend.flush();

	}
}
