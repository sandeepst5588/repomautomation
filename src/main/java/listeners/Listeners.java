package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	ExtentReports extentReport = ExtentReporter.getExtentReport();// This method will give setted report format template
	ExtentTest extentTest;

	ThreadLocal<ExtentTest> extendTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		// ExtentReports extentReport = ExtentReporter.getExtentReport();// This will
		// give extent report generated

		// To create a testcase this onTestStart() method will be invoked on every test
		// start
		extentTest = extentReport.createTest(testName);
		extendTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// creating report and print in to it
		String testName = result.getName();
		// extentTest.log(Status.PASS, testName + " got passed");

		extendTestThread.get().log(Status.PASS, testName + " got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testMethodName = result.getName();

		// extentTest.fail(result.getThrowable());// This will get details from
		// testclass and diplay in report
		extendTestThread.get().fail(result.getThrowable());

		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String screenshotFilePath = takeScreenshot(testMethodName, driver);
			extendTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();
	}

}
