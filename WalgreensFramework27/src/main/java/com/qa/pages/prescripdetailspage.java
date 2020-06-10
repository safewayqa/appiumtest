package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class prescripdetailspage extends BaseTest{
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/refill_from_account_label")
	public MobileElement Refillaccount;
	
	@AndroidFindBy(id="Don't have an account? Register now")
	public MobileElement RegNow;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'registermanually')]")
	public MobileElement RegManally;

	
	//Creating Methods
	
	public AccountLoginPage registernowclick() {
		
		click(RegNow);
		return new AccountLoginPage();
	}
	public AccountLoginPage RegManallyclick() {
			
			click(RegManally);
			return new AccountLoginPage();
		}
	
	public AccountLoginPage refilclick() {
		
		click(Refillaccount);
		return new AccountLoginPage();
	}
	
	
	
	
	
}
