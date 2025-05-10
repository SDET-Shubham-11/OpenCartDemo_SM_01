package com.opencart.qa.ExtentReportsListeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencart.qa.utilis.ScreenshotUtil;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
	
	 public static ExtentReports extent;
	    static ExtentTest test;
	    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	    @Override
	    public void onStart(ITestContext context) {
	        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
	        spark.config().setReportName("OpenCart Test Report");
	        spark.config().setDocumentTitle("Automation Report");

	        extent = new ExtentReports();
	        extent.attachReporter(spark);

	        extent.setSystemInfo("Tester", "Shubham");
	        extent.setSystemInfo("Browser", "Chrome");
	    }
	    
	    

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	        extentTest.set(test);
	        
	    }
	    

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	String screenshotPath = ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());
	        extentTest.get().pass("Test Passed").addScreenCaptureFromPath(screenshotPath);
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	String screenshotPath = ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());
	        extentTest.get().fail(result.getThrowable()).addScreenCaptureFromPath(screenshotPath);
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.skip("Test Skipped: " + result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    } 
	    
	    public static ExtentTest getTest() {
	        return extentTest.get();
	    }
	    
	    
	
}
