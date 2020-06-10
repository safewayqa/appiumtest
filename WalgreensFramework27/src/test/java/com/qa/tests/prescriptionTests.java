package com.qa.tests;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.BaseTest;
import com.qa.extentreportss.extentreportsss;
import com.qa.listeners.TestListener;
import com.qa.pages.AccountLoginPage;
import com.qa.pages.Userdetailpage;
import com.qa.pages.prescripdetailspage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class prescriptionTests<MobileElelment> extends BaseTest {

	prescripdetailspage prescrippage;
	AccountLoginPage logindetailpage;
	Userdetailpage userdetailstests;
	InputStream datais;
	JSONObject presdata;
	ExtentTest test;
	
	@BeforeClass
	public void beforeclass() throws Exception {
		 
		try {
		String filename="data/loginUsers.json";
		datais=getClass().getClassLoader().getResourceAsStream(filename);
		JSONTokener tokener= new JSONTokener(datais);
		 presdata=new JSONObject(tokener);
		} catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 if (datais !=null) {
				 datais.close();
			 }
		 }
	}
	
	@BeforeMethod
	public void beforeMethod() {
		 	
		prescrippage=new prescripdetailspage();
		logindetailpage=new AccountLoginPage();
		userdetailstests=new Userdetailpage();
	}
	
	@AfterClass
	public void afterclass() {
		
	}
	/*
	 * @AfterMethod public void failuress(ITestResult result) {
	 * if(result.getThrowable()!=null) { StringWriter sw=new StringWriter();
	 * PrintWriter pw= new PrintWriter(sw);
	 * result.getThrowable().printStackTrace(pw); System.out.println(sw.toString());
	 * } }
	 */
	
	
	@Test(priority=2)
	public void Refillaccount() {
		test=extent.createTest("Refillaccount", "Verify the Refillaccount");
	
		logindetailpage.preciption();
		prescrippage.refilclick();
		prescrippage.backpage();
		prescrippage.registernowclick();
		prescrippage.RegManallyclick();
		userdetailstests.fname(presdata.getJSONObject("Filldetails").getString("fname"));
		userdetailstests.lname(presdata.getJSONObject("Filldetails").getString("lname"));
		userdetailstests.backpage();
		userdetailstests.date();
		userdetailstests.months(presdata.getJSONObject("Filldetails").getString("month"));
		userdetailstests.days_years(presdata.getJSONObject("Filldetails").getString("dayear"));
		userdetailstests.confirmok();
		userdetailstests.lphone(presdata.getJSONObject("Filldetails").getString("phone"));
		userdetailstests.backpage();
	
		test.info("**********Rafi******************");
		userdetailstests.email(presdata.getJSONObject("Filldetails").getString("emailid"));
	}
	
	@Test(priority=1)
	public void erorchecks() {
		test=extent.createTest("Error_checks", "Vaidating error messages");
		SoftAssert sa=new SoftAssert();
		logindetailpage.preciption();
		prescrippage.refilclick();
		prescrippage.backpage();
		prescrippage.registernowclick();
		prescrippage.RegManallyclick();
		prescrippage.backpage();
		userdetailstests.scroldoneclick();
	
		String ActualResult=userdetailstests.fnamerror();
		String ExpectedResult=stringss.get("Fname");
		sa.assertEquals(ActualResult, ExpectedResult);
		test.log(Status.INFO,"Fname eror msg matched");
		
		String ActualResult1=userdetailstests.Lnamerror();
		String ExpectedResult1=stringss.get("Lname");
		sa.assertEquals(ActualResult1, ExpectedResult1);
		test.log(Status.INFO,"Lname error msg matched");
		
		String ActualResult2=userdetailstests.dob();
		String ExpectedResult2=stringss.get("DOBs");		
		sa.assertEquals(ActualResult2, ExpectedResult2);
		
		
		String ActualResult3=userdetailstests.phonenum();
		String ExpectedResult3=stringss.get("ph");		
		sa.assertEquals(ActualResult3, ExpectedResult3);
		
		System.out.println("All GOODDDDDDDDd");
			
			
		sa.assertAll();
		
	}
	@AfterMethod
	public void TestFailure(ITestResult iTestResult ) {
		//	System.out.println("I am in onStart method " + iTestResult.getName());
			
		
	//	  test=extent.createTest("Failed", "It is failed");
		/*
		 * System.out.println("I am in onTestFailure method " +
		 * getTestMethodName(iTestResult) + " failed");
		 */
	  try {
		  if(ITestResult.FAILURE==iTestResult.getStatus()) {
		  
		  String temp= TestListener.capturescreen( driver, iTestResult.getMethod().getMethodName());
		  
		  
		  test.fail(iTestResult.getThrowable().getMessage(),
		  MediaEntityBuilder.createScreenCaptureFromPath(temp).build()); } }
		  catch(IOException e) { 
			  e.printStackTrace();
			  }
		 
						        
	        }
	    	  
	
}
