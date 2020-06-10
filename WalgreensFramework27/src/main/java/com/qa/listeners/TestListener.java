package com.qa.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.BaseTest;

	public class TestListener extends BaseTest implements ITestListener {


	public static 	ExtentTest test;
	

	    private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	        
	    }
	 
	    
	
	  public static String capturescreen(WebDriver driver, String screenshotName) {
	//	  test=extent.createTest("F");
	  TakesScreenshot screens= ((TakesScreenshot) driver); File src=
	  screens.getScreenshotAs(OutputType.FILE); String
	  path=System.getProperty("user.dir")+"/Screenshot/"+screenshotName+".png";
	  File destination=new File(path);
	  
	  try { 
		  FileUtils.copyFile(src, destination);
	  System.out.println("Captured the screenshot"); 
	  } catch (IOException e) { 
	   e.printStackTrace(); 
	  } return path;
	  
	  }
	 
	    
	 
	
	  public void onTestFailure(ITestResult iTestResult ) { //
	  System.out.println("Test Failure" + iTestResult.getName());
	  
		/*
		 * // test=extent.createTest("Failed", "It is failed");
		 * System.out.println("I am in onTestFailure method " +
		 * getTestMethodName(iTestResult) + " failed"); try {
		 * if(ITestResult.FAILURE==iTestResult.getStatus()) {
		 * 
		 * String temp= capturescreen( driver, iTestResult.getMethod().getMethodName());
		 * 
		 * 
		 * test.fail(iTestResult.getThrowable().getMessage(),
		 * MediaEntityBuilder.createScreenCaptureFromPath(temp).build()); } }
		 * catch(IOException e) { e.printStackTrace(); }
		 */
	  
	  }
	 
	    
		
		
	    
	    
	    public void onStart(ITestContext iTestContext) {
	        System.out.println("I am in onStart method " + iTestContext.getName());
	        iTestContext.setAttribute("WebDriver", this.driver);
	    }
	 
	    public void onFinish(ITestContext iTestContext) {
	        System.out.println("I am in onFinish method " + iTestContext.getName());
	        //Do tier down operations for extentreports reporting!
	       
		/*
		 * extentreportsss.getInstance().flush(); driver.quit();
		 */
	    }
	 
	    public void onTestStart(ITestResult iTestResult) {
	        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
	    }
	 
	    public void onTestSuccess(ITestResult iTestResult) {
	 //   	test=extent.createTest(getTestMethodName(iTestResult));
	        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
	        //ExtentReports log operation for passed tests.
	 //        test.log(Status.PASS, "Test passed");
	    }
	 
	    	 
	    public void onTestSkipped(ITestResult iTestResult) {
	    	
	        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
	        //ExtentReports log operation for skipped tests.
	        test.log(Status.SKIP, "Test Skipped");
	    }
	 
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	    }


	

	

		
}
