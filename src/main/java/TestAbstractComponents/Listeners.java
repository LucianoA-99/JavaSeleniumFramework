package TestAbstractComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.extentReport;
import Tests.TestComponents.BaseTest;

public class Listeners extends BaseTest implements ITestListener {
	private ExtentTest test;
	private ExtentReports extent = extentReport.getReportObject();
	private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //assign unique thread ID 
	}

	public void onTestSucess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test pass");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			//can't use test method to get the driver cause fields are associated at class level
		} catch (Exception e) {
			e.printStackTrace();
		}

		String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {

	}

  	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
  	System.out.println("Failure of test cases and its details are : "+result.getName());
  	}

	public void onStart(ITestContext context) {

	}


	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
