package com.qa.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qa.BaseTest;
import com.qa.pages.AccountLoginPage;
import com.qa.pages.Homepage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class LoginTests extends BaseTest {
	Homepage homepage;
	AccountLoginPage accountloginpage;
	InputStream datais;
	JSONObject loginuser;
	static 	ExtentTest test;
	 @BeforeClass
	  public void beforeClass() throws Exception {
		 try{
			 String filename="data/loginUsers.json";
		 	datais= getClass().getClassLoader().getResourceAsStream(filename);
		 	JSONTokener tokener= new JSONTokener(datais);
		 	loginuser=new JSONObject(tokener);}
		 catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 if (datais !=null) {
				 datais.close();
			 }
		 }
	  }
	 @AfterClass
	  public void afterClass() {
	  }
	 @BeforeMethod
	  public void beforeMethod(Method m) {
		  homepage= new Homepage();
		  System.out.println("Method name is--"+m.getName());
	  }
	/*
	 * @AfterMethod
	 * 
	 * public void failuress(ITestResult result) { if(result.getThrowable()!=null) {
	 * StringWriter sw=new StringWriter(); PrintWriter pw= new PrintWriter(sw);
	 * result.getThrowable().printStackTrace(pw); System.out.println(sw.toString());
	 * } }
	 */
	  
	  
   
	  @Test
	  public void invalidUser() {
			test=extent.createTest("invalidUser", "Verify the invalidUser");
		  homepage.loginclcik();
		  test.info("User clicked it");
		  homepage.enterunsername(loginuser.getJSONObject("login_credentials").getString("user_name"));
		  homepage.enterpassword(loginuser.getJSONObject("login_credentials").getString("password"));
		  homepage.pressLoginbtn();
		   String actualtesext= homepage.getErrtext();
		   String expectedtext=stringss.get("Error_text_message");
			System.out.println("ActualResult"+actualtesext);
		   System.out.println("ActualResult"+expectedtext);
		   Assert.assertEquals(actualtesext, expectedtext);
		
	  }
	  	@Test
		  public void validUser() {
		
		  homepage.loginclcik();
		  homepage.enterunsername(loginuser.getJSONObject("login_credential").getString(
		  "user_name"));
		  homepage.enterpassword(loginuser.getJSONObject("login_credential").getString(
		  "password")); homepage.pressLoginbtn();
		 
	  		System.out.println("***Rafi");
	  		
		  }
		  
	  
}
