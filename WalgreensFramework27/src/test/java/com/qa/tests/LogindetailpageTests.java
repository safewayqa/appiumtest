package com.qa.tests;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.BaseTest;
import com.qa.pages.AccountLoginPage;
import com.qa.pages.Homepage;
import com.qa.pages.prescripdetailspage;
import com.qa.utils.SrolldownScreen;

public class LogindetailpageTests extends BaseTest{
	AccountLoginPage logindetailpage;
	 SrolldownScreen scrollings;
	 static 	ExtentTest test;
	@BeforeClass
	public void beforeclass() throws Exception {
		
	  }

	@BeforeMethod
	public void beforemethod(Method e) {
		 scrollings=new SrolldownScreen();
		logindetailpage= new AccountLoginPage();
		System.out.println("Method name is--"+e.getName());
	}
	 @AfterClass
	  public void afterClass() {
	  }
	//Test case
	@Test(priority=7)
	public void logochecks() {
		test=extent.createTest("logochecks", "Verify the Logo");
		logindetailpage.logocheck();
		test.log(Status.INFO, "checklogo is correct");
		System.out.println("Rafi");
	}
	
	@Test(priority=4)
	public void swipeaddpre() throws Exception {
	//	SrolldownScreen.Screenupdown(driver,"up");
		logindetailpage.Addpref();
		
	}
	
	@Test(priority=5)
	  public void preschecks() { 
	  logindetailpage.preciption();
	  logindetailpage.backpage(); 
	  System.out.println("Rehan");
	  
	  }
	 
	@Test(priority=6)
	  public void findstore() {
		  logindetailpage.findstoreclick();
		  logindetailpage.backpage();
	  }
	  
	@Test(priority=3)
	  public void shopproducts() throws Exception {
	//	SrolldownScreen.Screenupdown(driver,"up");
		  logindetailpage.shopprod();
		  logindetailpage.backpage();
	  }
	  
	@Test(priority=2)
	  public void photosss() throws Exception {
	//	  SrolldownScreen.Screenupdown(driver,"up");
		  logindetailpage.photoss();
		  logindetailpage.backpage();
	  }
	  
	@Test(priority=1)
	  public void weeklyss() throws Exception {
	//	  SrolldownScreen.Screenupdown(driver,"up");
		logindetailpage.weeklss();
	//	  logindetailpage.weeklys();
		  logindetailpage.backpage();
	  }
}

