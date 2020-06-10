package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Homepage extends BaseTest{
	

	  @AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Prescriptions\"]/android.widget.LinearLayout/android.widget.TextView)")
	  public MobileElement prescription;
	 
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/lblWidPosCta")
	public MobileElement LoginBtn;
	
	@AndroidFindBy(xpath="//*[@text='Enter username']")
	public MobileElement usernametext;
	
	@AndroidFindBy(accessibility="Enter Password")
	public MobileElement passwordtext;
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/btnLogin")
	public MobileElement presslogin;
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/txt_err_msg")
	public MobileElement errortext;
	
	
	//*Methods creating
	public Homepage loginclcik() {
		click(LoginBtn);
		return this;
	}
	public Homepage enterunsername(String username) {
		sendkeys(usernametext,username);
		return this;
	}
	
	public Homepage enterpassword(String username) {
		sendkeys(passwordtext,username);
		return this;
	}
	
	public AccountLoginPage pressLoginbtn() {
		click(presslogin);
		return new AccountLoginPage();
		
	}
	
	public String getErrtext() {
		return getAttribute(errortext, "text");
		
	}
	
}
