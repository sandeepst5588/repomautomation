package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extentReports;

	public static ExtentReports getExtentReport() {
		String extentReportPath = System.getProperty("user.dir") + "\\reports\\extentreport.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("TutorialsNinja Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Operating System", "Windows 10");
		extentReports.setSystemInfo("Tested ", "ABC QA Engineer");

		return extentReports;
	}
}
