package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.Userdetailpage;

public class UserdetailTests extends BaseTest{
	
	Userdetailpage userdetailstests;
	
	@BeforeClass
	public void beforeclass() {
		
		
	}
	@BeforeMethod
public void beforemethod() {
		
		userdetailstests=new Userdetailpage();
	}
	@AfterClass
public void afterclass() {
	
	
}
	@Test
	public void userlog() {
		
		userdetailstests.fname("Rafi");
	}
@Test
public void userlog2() {
		
		userdetailstests.lname("nargees");
	}
}
